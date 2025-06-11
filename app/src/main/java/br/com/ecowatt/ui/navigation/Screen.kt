package br.com.ecowatt.ui.navigation

sealed class Screen(val route: String) {
    object WelcomeScreen : Screen("welcome_screen")
    object SignUpScreen : Screen("signup_screen")
    object SignInScreen : Screen("signin_screen")
    object HomeScreen : Screen("home_screen")
    object DevicesListScreen : Screen("devices_list_screen")
    object DeviceRegistrationScreen : Screen("device_registration_screen")
    object DeviceDetailsScreen : Screen("device_details_screen")
}