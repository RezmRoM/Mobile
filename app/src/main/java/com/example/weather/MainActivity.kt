package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather.navigation.Screen
import com.example.weather.screens.*
import com.example.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Splash.route
                    ) {
                        composable(Screen.Splash.route) {
                            SplashScreen(
                                onTimeout = {
                                    navController.navigate(Screen.OnboardingFirst.route)
                                }
                            )
                        }

                        composable(Screen.OnboardingFirst.route) {
                            OnboardingFirstScreen(
                                onNextClick = {
                                    navController.navigate(Screen.OnboardingSecond.route)
                                }
                            )
                        }

                        composable(Screen.OnboardingSecond.route) {
                            OnboardingSecondScreen(
                                onNextClick = {
                                    navController.navigate(Screen.OnboardingThird.route)
                                }
                            )
                        }

                        composable(Screen.OnboardingThird.route) {
                            OnboardingThirdScreen(
                                onNextClick = {
                                    navController.navigate(Screen.Login.route)
                                }
                            )
                        }

                        composable(Screen.Login.route) {
                            AuthorizationScreen(
                                onBackClick = { navController.navigateUp() },
                                onForgotPasswordClick = { navController.navigate(Screen.ForgotPassword.route) },
                                onRegisterClick = { navController.navigate(Screen.Registration.route) },
                                onLoginClick = { navController.navigate(Screen.Home.route) }
                            )
                        }

                        composable(Screen.Registration.route) {
                            RegistrationScreen(
                                onBackClick = { navController.navigateUp() },
                                onLoginClick = { navController.navigate(Screen.Login.route) },
                                onRegisterClick = { navController.navigate(Screen.Cart.route) }
                            )
                        }

                        composable(Screen.ForgotPassword.route) {
                            ForgotPasswordScreen(
                                onBackClick = {
                                    navController.navigateUp()
                                },
                                onSubmitClick = {
                                    navController.navigate(Screen.OtpVerification.route)
                                }
                            )
                        }

                        composable(Screen.OtpVerification.route) {
                            OtpVerificationScreen(
                                onBackClick = { navController.navigateUp() },
                                onVerifyClick = { navController.navigate(Screen.Cart.route) {
                                    popUpTo(Screen.Login.route)
                                }},
                                onResendClick = { /* Показать диалог повторной отправки */ }
                            )
                        }

                        composable(Screen.Cart.route) {
                            CartScreen(
                                onBackClick = { navController.navigateUp() },
                                onConfirmClick = { navController.navigate(Screen.CartSuccess.route) },
                                onMapClick = { /* Обработка нажатия на карту */ }
                            )
                        }

                        composable(Screen.Home.route) {
                            HomeScreen(
                                onCartClick = { navController.navigate(Screen.MyCart.route) },
                                onAllClick = { navController.navigate(Screen.Popular.route) },
                                onHomeClick = { },
                                onFavoriteClick = { navController.navigate(Screen.Favorite.route) },
                                onNotificationClick = { },
                                onProfileClick = { },
                                onSearchClick = { navController.navigate(Screen.Search.route) }
                            )
                        }

                        composable(Screen.Popular.route) {
                            PopularScreen(
                                onBackClick = { navController.popBackStack() }
                            )
                        }

                        composable(Screen.Favorite.route) {
                            FavoriteScreen(
                                onBackClick = { navController.popBackStack() }
                            )
                        }

                        composable(Screen.Search.route) {
                            SearchScreen(
                                onBackClick = { navController.popBackStack() }
                            )
                        }

                        composable(Screen.MyCart.route) {
                            MyCartScreen(
                                onBackClick = { navController.popBackStack() },
                                onCheckoutClick = { navController.navigate(Screen.Cart.route) }
                            )
                        }
                    }
                }
            }
        }
    }
}