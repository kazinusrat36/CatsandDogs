package com.example.catsanddogs

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("splash_screen")
    data object LoginScreen : Screens("login_screen")
    data object RegistrationOption : Screens("registration_option")
    data object RegistrationVetScreen : Screens("registration_vet_screen")
    data object RegistrationUserScreen : Screens("registration_user_screen")
    data object HomeScreen : Screens("home_screen")
    data object FosterScreen : Screens("foster_screen")
    data object VetListScreen : Screens("vet_list_Screen")
    data object CureScreen : Screens("cure_screen")
    data object AboutUsScreen : Screens("about_us_screen")
    data object PatientFormScreen : Screens("patient_form_screen")


}