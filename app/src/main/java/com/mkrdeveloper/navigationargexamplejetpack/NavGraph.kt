package com.mkrdeveloper.navigationargexamplejetpack

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ){
        composable(route = "Home"){
            HomeScreen(navController)
        }
        composable(
            route = "Details?name={name}&age={age}",
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
                    //defaultValue= "user"
                    nullable = true
                },
                navArgument(name = "age"){
                    type = NavType.IntType
                    defaultValue= 0
                }
            )
        ){ backstackEntry ->
            DetailsScreen(
                myName = backstackEntry.arguments?.getString("name") ,
                myAge = backstackEntry.arguments?.getInt("age")
            )
        }
    }
}