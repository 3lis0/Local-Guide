# Import Pandas
import pandas as pd

#Import TfIdfVectorizer from scikit-learn
from sklearn.feature_extraction.text import TfidfVectorizer

# Import linear_kernel
from sklearn.metrics.pairwise import linear_kernel

# Load useres Metadata
metadata = pd.read_csv('D:/courses/AI/dataset/Guides_subset.csv', low_memory=False)

#Define a TF-IDF Vectorizer Object. Remove all english stop words such as 'the', 'a'
tfidf = TfidfVectorizer(stop_words='english')

#Replace NaN with an empty string
metadata['Interests'] = metadata['Interests'].fillna('')

#Construct the required TF-IDF matrix by fitting and transforming the data
tfidf_matrix = tfidf.fit_transform(metadata['Interests'])

# Create a CountVectorizer object
vectorizer = TfidfVectorizer(max_features=10000)

# Fit the vectorizer to the text data
vectorizer.fit(metadata['Interests'])

# Get feature names (40 in this case)
Interests = vectorizer.get_feature_names_out()[:40]

# Compute the cosine similarity matrix
cosine_sim = linear_kernel(tfidf_matrix, tfidf_matrix)

#Construct a reverse map of indices and useres id
indices = pd.Series(metadata.index, index=metadata['UserID']).drop_duplicates()

# Function that takes in user id  as input and outputs most similar useres
def get_recommendations(title, cosine_sim=cosine_sim):
    # Get the index of the user that matches the id
    idx = indices[title]

    # Get the pairwsie similarity scores of all useres with that user
    sim_scores = list(enumerate(cosine_sim[idx]))

    # Sort the useres based on the similarity scores
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)

    # Get the scores of the 10 most similar useres
    sim_scores = sim_scores[1:10]

    # Get the movie indices
    guide_indices = [i[0] for i in sim_scores]

    # Return the top 10 most similar useres
    return metadata['Name'].iloc[guide_indices]

get_recommendations(88967)