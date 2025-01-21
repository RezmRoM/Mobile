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
    object Profile : Screen("profile")
    object Notifications : Screen("notifications")
    object SideMenu : Screen("side_menu")
    object EditProfile : Screen("edit_profile")
    object Orders : Screen("orders")
    object Details : Screen("details")
    
    companion object {
        fun fromRoute(route: String?): Screen {
            return when (route) {
                Splash.route -> Splash
                OnboardingFirst.route -> OnboardingFirst
                OnboardingSecond.route -> OnboardingSecond
                OnboardingThird.route -> OnboardingThird
                Login.route -> Login
                Registration.route -> Registration
                ForgotPassword.route -> ForgotPassword
                OtpVerification.route -> OtpVerification
                EmailSent.route -> EmailSent
                Home.route -> Home
                MyCart.route -> MyCart
                Cart.route -> Cart
                CartSuccess.route -> CartSuccess
                Popular.route -> Popular
                Favorite.route -> Favorite
                Search.route -> Search
                Profile.route -> Profile
                Notifications.route -> Notifications
                SideMenu.route -> SideMenu
                EditProfile.route -> EditProfile
                Orders.route -> Orders
                Details.route -> Details
                else -> Home
            }
        }
    }
}
