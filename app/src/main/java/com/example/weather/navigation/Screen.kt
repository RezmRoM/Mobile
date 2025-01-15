package com.example.weather.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object OnboardingFirst : Screen("onboarding_first")
    object OnboardingSecond : Screen("onboarding_second")
    object OnboardingThird : Screen("onboarding_third")
    object Login : Screen("login")
    object Registration : Screen("registration")
    object ForgotPassword : Screen("forgot_password")
    object OtpVerification : Screen("otp_verification")
    object EmailSent : Screen("email_sent")
    object Home : Screen("home")
    object MyCart : Screen("my_cart")
    object Cart : Screen("cart")
    object CartSuccess : Screen("cart_success")
    object Popular : Screen("popular")
    object Favorite : Screen("favorite")
    object Search : Screen("search")
}
