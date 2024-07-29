package com.digi.pizzaorderingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.digi.pizzaorderingapp.ui.screens.CheckoutScreen
import com.digi.pizzaorderingapp.ui.screens.PizzaSelectionScreen
import com.digi.pizzaorderingapp.ui.screens.ToppingSelectionScreen
import com.digi.pizzaorderingapp.ui.theme.PizzaOrderingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaOrderingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "pizza_selection") {
                        composable("pizza_selection") {
                            PizzaSelectionScreen(
                                modifier = Modifier.padding(innerPadding)
                            ) {
                                navController.navigate("topping_selection/$it") // it refers to selected Idx
                            }
                        }
//                      // add route argument
                        composable("topping_selection/{pizzaId}",
                            arguments = listOf(navArgument("pizzaId") {
                                type = NavType.IntType
                            })
                        ) {
                            ToppingSelectionScreen(
                                modifier = Modifier.padding(innerPadding),
                                pizzaId = it.arguments?.getInt("pizzaId") ?: 0
                            )
                        }
                        composable("checkout") {
                            CheckoutScreen(
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PizzaSelectionPreview() {
    PizzaSelectionScreen() {

    }
}

@Preview(showBackground = true)
@Composable
private fun ToppingSelectionPreview() {
    ToppingSelectionScreen(pizzaId = 0)
}

@Preview
@Composable
private fun CheckoutPreview() {
    CheckoutScreen()
}