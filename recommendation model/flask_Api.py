from flask import Flask, request, jsonify
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import linear_kernel

app = Flask(__name__)

# Load user metadata
metadata = pd.read_csv('D:/courses/AI/dataset/Guides_subset.csv', low_memory=False)

# Define a TF-IDF Vectorizer Object. Remove all English stop words
tfidf = TfidfVectorizer(stop_words='english')

# handel empty call bu Nun
metadata['Interests'] = metadata['Interests'].fillna('')

# trans data on matrix form
tfidf_matrix = tfidf.fit_transform(metadata['Interests'])

# Compute the cosine similarity matrix
cosine_sim = linear_kernel(tfidf_matrix, tfidf_matrix)

# Construct a reverse map of indices and user IDs
indices = pd.Series(metadata.index, index=metadata['UserID']).drop_duplicates()

# Function to get recommendations
def get_recommendations(user_id, country=None):
     # Get the index of the user that matches the id
    idx = indices[user_id]
     # Get the pairwsie similarity scores of all useres with that user
    sim_scores = list(enumerate(cosine_sim[idx]))
    # Sort the useres based on the similarity scores
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    
     # Get the indices of the 100 most similar users
    guide_indices = [i[0] for i in sim_scores[:10000]]
    
    # Apply country filter if provided
    if country:
        country = country.lower()  # Convert to lowercase
        country_users = metadata[metadata['Country'].str.lower() == country]
        guide_indices = country_users.index.intersection(guide_indices)

    # Get the top 10 most similar users' UserIDs
    recommendations = metadata.loc[guide_indices[:10], 'UserID'].tolist()
    
    return recommendations

@app.route('/recommendations', methods=['GET'])
def recommendations():
    try:
        user_id = int(request.args.get('user_id'))
        country = request.args.get('country')  # Get country parameter
        recommendations = get_recommendations(user_id, country)
        return jsonify({'recommendations': recommendations})
    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    app.run(debug=True)
