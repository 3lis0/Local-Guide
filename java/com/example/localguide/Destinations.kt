package com.example.localguide

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route = "Home"
}

object SearchBarPage : Destinations {
    override val route = "SearchBarPage"
}

object TourDetails : Destinations {
    const val argOrderNo = "OrderNo"
    override val route = "TourDetails"
}

object GuidesDetails : Destinations {
    const val argOrderNo = "OrderNo"
    override val route = "GuidesDetails"
}

object GuideHomeScreen : Destinations {
    override val route = "GuideHome"
}

object NewTourInput : Destinations {
    override val route = "NewTourInput"
}

object NotificationScreen : Destinations {
    override val route = "NotificationScreen"
}

object ProfileScreen : Destinations {
    override val route = "ProfileScreen"
}

object InboxScreen : Destinations {
    override val route = "InboxScreen"
}

object SearchScreen : Destinations {
    override val route = "SearchScreen"
}

object LoginScreen : Destinations {
    override val route = "LoginScreen"
}

object SigninScreen : Destinations {
    override val route = "SigninScreen"
}

object GuideQScreen : Destinations {
    override val route = "GuideQScreen"
}

object InformationScreen : Destinations {
    override val route = "InformationScreen"
}

object TouristQScreen : Destinations {
    override val route = "TouristQScreen"
}

object UserInterests : Destinations {
    override val route = "UserInterests"
}


