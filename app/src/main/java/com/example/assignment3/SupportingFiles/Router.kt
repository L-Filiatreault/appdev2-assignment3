package com.example.assignment3.SupportingFiles
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment3.LocalNavController
import com.example.assignment3.Screens.DetailsScreen
import com.example.assignment3.Screens.InformationScreen
import com.example.assignment3.Screens.ListScreen
import com.example.assignment3.Screens.MainScreen


/**
 * Routes provides a way of defining routes between screens, which lends an easy way to understand
 * which screen is being navigated to. As well it makes it easy to handle a limited amount of subclasses
 * and that prevents further bugs appearing.
 * Note: I retrieved this particular bit of code from our class notes
 */
sealed class Routes(val route:String)
{
    //Allows to navigate to the Main screen to input user data
    object Main: Routes("MainScreenRoute")

    //Allows to navigate to the Information screen
    object Information: Routes("InformationScreenRoute")

    //Allows to navigate to the Details screen, the function 'go' retrieves the value 'indexNumber' to be used to access an item from the pokemonGymList
    object Details: Routes("DetailsScreenRoute/{indexNumber}"){
        fun go(indexNumber: String) = "DetailsScreenRoute/$indexNumber"
    }

    //Allows to navigate to the ListScreen to see all the inputs
    object ListScreen: Routes("ListScreenRoute")
}

/**
 * The function Router helps navigate between screens when the user selects a destination on the top or bottom navigation
 * bars, or when they input information from Main and go to Details, or want to see more information on Details from an item
 * selected inside the List screen.
 * This is the first function called when starting the app so the navigation routes are built and the screens can be accessed properly.
 * @param modifier This is the modifier to display the composables in a decorated way in the other screens, comes from the MainActivity.
 * Note: I retrieved this particular bit of code from our class notes
 */
@Composable
fun Router(modifier: Modifier) {
    val navController= LocalNavController.current //This will ensure the current selected screens are navigated to properly

    //This NavHost takes in the provider of navController so as to access the different screens properly
    NavHost(navController = navController, startDestination = "MainScreenRoute") {

        //Accessing the Main screen
        composable(Routes.Main.route)
        {
            MainScreen(modifier)
        }

        //Navigating to the Details, retrieving the array index value of the item to be shown on Details screen
        composable(Routes.Details.route)
        {
            val indexNumber2 = it.arguments?.getString("indexNumber") !! //Must be a string value for the indexNumber otherwise the route will not work properly

            DetailsScreen(
                indexNumber2,
                modifier
            )
        }

        //Allowing the Route to call the InformationScreen composable to render
        composable(Routes.Information.route)
        {
            InformationScreen(modifier)
        }

        //Allowing the Route to call the List screen composable to render
        composable(Routes.ListScreen.route)
        {
            ListScreen(modifier)
        }

    }
}