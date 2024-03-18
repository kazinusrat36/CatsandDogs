package com.example.catsanddogs

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val imageId= arrayOf(
        R.drawable.male_doc,
        R.drawable.femaledoc,
        R.drawable.male_doc,
        R.drawable.femaledoc,
        R.drawable.male_doc
    )
    val names = arrayOf(
        "Dr. Md. Mosharaf Hossain",
        "Dr. Ruksana Ahmed",
        "Dr. Abdullah-Al-Aziz",
        "Dr. Muslima Rahman",
        "Dr. Tasmir Rayan"
    )
    val degrees = arrayOf(
        "DVM, Phd (JAPAN) MS",
        "DVM, MS",
        "DVM",
        "DVM",
        "DVM"
    )
    val work = arrayOf(
        "Sher-e-Bangla Agricultural University",
        "Bakergonj Upazila Livestock Office & Veterinary Hospital",
        "Veterinary Teaching Hospital, BAU",
        "Titlark Petwell Center",
        "Pet Point Gazipur"
    )
    val contact = arrayOf(
        "Contact: 017XXXXXXXX\nEmail: mosharafhos@gmail.com",
        "Contact: 017XXXXXXXX\nEmail: ruksanaahmed@gmail.com",
        "Contact: 018XXXXXXXX\nEmail: abdullaziz@gmail.com",
        "Contact: 019XXXXXXXX\nEmail: muslimar@gmail.com",
        "Contact: 017XXXXXXXX\nEmail: rayantasmir@gmail.com"
    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route){
        composable(route = Screens.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screens.LoginScreen.route){
                LoginScreen(navController = navController)
        }
        composable(route = Screens.RegistrationOption.route){
            RegistrationOption(navController = navController)
        }
        composable(route = Screens.AboutUsScreen.route){
            AboutUsScreen()
        }
        composable(route = Screens.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route = Screens.FosterScreen.route){
            FosterScreen(navController = navController)
        }
        composable(route = Screens.RegistrationUserScreen.route){
            RegistrationUserScreen(navController = navController)
        }
        composable(route = Screens.RegistrationVetScreen.route){
            RegistrationVetScreen(navController = navController)
        }
        composable(route = Screens.CureScreen.route){
            CureScreen(navController = navController)
        }
        composable(route = Screens.PatientFormScreen.route){
            PatientFormScreen()
        }
        composable(route = Screens.VetListScreen.route){
            VetListScreen(imageId,names,degrees, navController)
        }

        composable(route = "vet_details/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )
        ){
                index->
            VetDetails(
                photos = imageId,
                names = names,
                degrees = degrees,
                work = work,
                contact = contact,
                navController = navController,
                itemIndex = index.arguments?.getInt("index")
            )
        }
    }
}