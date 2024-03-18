package com.example.catsanddogs

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object LoginScreen : Screens("login_screen")
    object RegistrationOption : Screens("registration_option")
    object RegistrationVetScreen : Screens("registration_vet_screen")
    object RegistrationUserScreen : Screens("registration_user_screen")
    object HomeScreen : Screens("home_screen")
    object FosterScreen : Screens("foster_screen")
    object VetListScreen : Screens("vet_list_Screen")
    object CureScreen : Screens("cure_screen")
    object AboutUsScreen : Screens("about_us_screen")


}