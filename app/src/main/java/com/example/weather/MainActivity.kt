package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Splash.route
                    ) {
                        composable(Screen.Splash.route) {
                            SplashScreen(
                                onTimeout = {
                                    navController.navigate(Screen.OnboardingFirst.route) {
                                        popUpTo(Screen.Splash.route) { inclusive = true }
                                    }
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
                                    navController.navigate(Screen.Login.route) {
                                        popUpTo(Screen.OnboardingFirst.route) { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable(Screen.Login.route) {
                            AuthorizationScreen(
                                onBackClick = { navController.navigateUp() },
                                onForgotPasswordClick = { navController.navigate(Screen.ForgotPassword.route) },
                                onRegisterClick = { navController.navigate(Screen.Registration.route) },
                                onLoginClick = { 
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.Login.route) { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable(Screen.Registration.route) {
                            RegistrationScreen(
                                onBackClick = { navController.navigateUp() },
                                onLoginClick = { navController.navigate(Screen.Login.route) },
                                onRegisterClick = { 
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.Registration.route) { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable(Screen.ForgotPassword.route) {
                            ForgotPasswordScreen(
                                onBackClick = { navController.navigateUp() },
                                onSubmitClick = {
                                    navController.navigate(Screen.OtpVerification.route)
                                }
                            )
                        }

                        composable(Screen.OtpVerification.route) {
                            OtpVerificationScreen(
                                onBackClick = { navController.navigateUp() },
                                onVerifyClick = { 
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(Screen.ForgotPassword.route) { inclusive = true }
                                    }
                                },
                                onResendClick = { }
                            )
                        }

                        composable(Screen.Cart.route) {
                            CartScreen(
                                onBackClick = { navController.navigateUp() },
                                onConfirmClick = { navController.navigate(Screen.CartSuccess.route) },
                                onMapClick = { }
                            )
                        }

                        composable(Screen.Home.route) {
                            HomeScreen(
                                onCartClick = {
                                    navController.navigate(Screen.MyCart.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onAllClick = {
                                    navController.navigate(Screen.Popular.route)
                                },
                                onHomeClick = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onFavoriteClick = {
                                    navController.navigate(Screen.Favorite.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNotificationClick = {
                                    navController.navigate(Screen.Notifications.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onProfileClick = {
                                    navController.navigate(Screen.Profile.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onSearchClick = {
                                    navController.navigate(Screen.Search.route)
                                },
                                onMenuClick = {
                                    navController.navigate(Screen.SideMenu.route)
                                },
                                navController = navController
                            )
                        }

                        composable(Screen.SideMenu.route) {
                            SideMenuScreen(
                                onProfileClick = { navController.navigate(Screen.Profile.route) },
                                onCartClick = { navController.navigate(Screen.MyCart.route) },
                                onFavoriteClick = { navController.navigate(Screen.Favorite.route) },
                                onOrdersClick = { navController.navigate(Screen.Orders.route) },
                                onNotificationsClick = { navController.navigate(Screen.Notifications.route) },
                                onSettingsClick = { /* TODO: Implement settings navigation */ },
                                onLogoutClick = { /* TODO: Implement logout */ }
                            )
                        }

                        composable(Screen.Popular.route) {
                            PopularScreen(
                                onBackClick = { navController.navigateUp() },
                                navController = navController
                            )
                        }

                        composable(Screen.Favorite.route) {
                            FavoriteScreen(
                                onBackClick = { navController.navigateUp() },
                                navController = navController
                            )
                        }

                        composable(Screen.Search.route) {
                            SearchScreen(
                                onBackClick = { navController.navigateUp() },
                                navController = navController
                            )
                        }

                        composable(Screen.MyCart.route) {
                            MyCartScreen(
                                onBackClick = { navController.navigateUp() },
                                onCheckoutClick = { navController.navigate(Screen.Cart.route) }
                            )
                        }

                        composable(Screen.Profile.route) {
                            ProfileScreen(
                                onMenuClick = { navController.navigate(Screen.SideMenu.route) },
                                onEditClick = { navController.navigate(Screen.EditProfile.route) },
                                onOrdersClick = { navController.navigate(Screen.Orders.route) },
                                onHomeClick = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onFavoriteClick = {
                                    navController.navigate(Screen.Favorite.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onCartClick = {
                                    navController.navigate(Screen.MyCart.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNotificationClick = {
                                    navController.navigate(Screen.Notifications.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onProfileClick = {
                                    navController.navigate(Screen.Profile.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }

                        composable(Screen.EditProfile.route) {
                            EditProfileScreen(
                                onSaveClick = { navController.navigateUp() },
                                onHomeClick = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onFavoriteClick = {
                                    navController.navigate(Screen.Favorite.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onCartClick = {
                                    navController.navigate(Screen.MyCart.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNotificationClick = {
                                    navController.navigate(Screen.Notifications.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onProfileClick = {
                                    navController.navigate(Screen.Profile.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }

                        composable(Screen.Notifications.route) {
                            NotificationScreen(
                                onMenuClick = { navController.navigate(Screen.SideMenu.route) },
                                onHomeClick = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onFavoriteClick = {
                                    navController.navigate(Screen.Favorite.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onCartClick = {
                                    navController.navigate(Screen.MyCart.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNotificationClick = {
                                    navController.navigate(Screen.Notifications.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onProfileClick = {
                                    navController.navigate(Screen.Profile.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }

                        composable(Screen.Orders.route) {
                            OrdersScreen(
                                onBackClick = { navController.navigateUp() },
                                onHomeClick = {
                                    navController.navigate(Screen.Home.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onFavoriteClick = {
                                    navController.navigate(Screen.Favorite.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onCartClick = {
                                    navController.navigate(Screen.MyCart.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onNotificationClick = {
                                    navController.navigate(Screen.Notifications.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                onProfileClick = {
                                    navController.navigate(Screen.Profile.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }

                        composable(Screen.Details.route) {
                            DetailsScreen(
                                onBackClick = { navController.navigateUp() },
                                onCartClick = { navController.navigate(Screen.Cart.route) },
                                onAddToCartClick = { navController.navigate(Screen.Cart.route) }
                            )
                        }
                    }
                }
            }
        }
    }
}