package br.com.ecowatt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ecowatt.models.user.UserSampleData
import br.com.ecowatt.ui.components.EcoWattTopBar
import br.com.ecowatt.ui.navigation.Screen.DeviceDetailsScreen
import br.com.ecowatt.ui.navigation.Screen.DeviceRegistrationScreen
import br.com.ecowatt.ui.navigation.Screen.DevicesListScreen
import br.com.ecowatt.ui.navigation.Screen.HomeScreen
import br.com.ecowatt.ui.navigation.Screen.SignInScreen
import br.com.ecowatt.ui.navigation.Screen.SignUpScreen
import br.com.ecowatt.ui.navigation.Screen.WelcomeScreen
import br.com.ecowatt.ui.screens.HomeScreen
import br.com.ecowatt.ui.screens.devices.DeviceDetailsScreen
import br.com.ecowatt.ui.screens.devices.DeviceRegistrationScreen
import br.com.ecowatt.ui.screens.devices.DevicesListScreen
import br.com.ecowatt.ui.screens.onboarding.SignInScreen
import br.com.ecowatt.ui.screens.onboarding.SignUpScreen
import br.com.ecowatt.ui.screens.onboarding.WelcomeScreen
import br.com.ecowatt.ui.theme.EcoWattTheme
import br.com.ecowatt.ui.viewmodel.AuthViewModel
import br.com.ecowatt.ui.viewmodel.DevicesViewModel

internal class MainActivity : ComponentActivity() {
    private val authViewModel by viewModels<AuthViewModel>()
    private val devicesViewModel by viewModels<DevicesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            EcoWattTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = WelcomeScreen.route
                ) {
                    composable(route = WelcomeScreen.route) {
                        Scaffold { innerPadding ->
                            WelcomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                onSignUp = { navController.navigate(SignUpScreen.route) },
                                onSignIn = { navController.navigate(SignInScreen.route) }
                            )
                        }
                    }

                    composable(route = SignUpScreen.route) {
                        Scaffold(topBar = {
                            EcoWattTopBar(
                                title = stringResource(R.string.screen_title_signup),
                                goBackFn = { navController.navigateUp() }
                            )
                        }) { innerPadding ->
                            SignUpScreen(
                                modifier = Modifier.padding(innerPadding),
                                onSubmit = {
                                    authViewModel.signUp(it, onSuccess = {
                                        runOnUiThread {
                                            navController.navigate(HomeScreen.route)
                                        }
                                    })
                                }
                            )
                        }
                    }

                    composable(route = SignInScreen.route) {
                        Scaffold(topBar = {
                            EcoWattTopBar(
                                title = stringResource(R.string.screen_title_signin),
                                goBackFn = { navController.navigateUp() }
                            )
                        }) { innerPadding ->
                            SignInScreen(
                                modifier = Modifier.padding(innerPadding),
                                onSubmit = {
                                    authViewModel.signIn(it, onSuccess = {
                                        runOnUiThread {
                                            navController.navigate(HomeScreen.route)
                                        }
                                    })
                                }
                            )
                        }
                    }

                    composable(route = HomeScreen.route) {
                        Scaffold { innerPadding ->
                            HomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                user = authViewModel.currentUser ?: UserSampleData.user,
                                onDevicesListClick = {
                                    navController.navigate(DevicesListScreen.route)
                                }
                            )
                        }
                    }

                    composable(route = DevicesListScreen.route) {
                        devicesViewModel.loadDevices()

                        Scaffold(topBar = { EcoWattTopBar(title = "Devices List") }) { innerPadding ->
                            DevicesListScreen(
                                modifier = Modifier.padding(innerPadding),
                                devicesList = devicesViewModel.devicesList,
                                onItemClick = {
                                    devicesViewModel.currentDevice.value = it
                                    navController.navigate(DeviceDetailsScreen.route)
                                },
                                onFabClick = { navController.navigate(DeviceRegistrationScreen.route) },
                                onRemove = { id -> devicesViewModel.removeDevice(id) }
                            )
                        }
                    }

                    composable(route = DeviceRegistrationScreen.route) {
                        Scaffold(topBar = {
                            EcoWattTopBar(
                                title = stringResource(R.string.screen_title_register_device),
                                goBackFn = { navController.navigateUp() }
                            )
                        }) { innerPadding ->
                            DeviceRegistrationScreen(
                                modifier = Modifier.padding(innerPadding),
                                onSubmit = {
                                    devicesViewModel.registerDevice(it, onRequestSuccess = {
                                        runOnUiThread { navController.navigateUp() }
                                    })
                                }
                            )
                        }
                    }

                    composable(route = DeviceDetailsScreen.route) {
                        Scaffold(topBar = {
                            EcoWattTopBar(
                                title = "Device Details",
                                goBackFn = { navController.navigateUp() }
                            )
                        }) { innerPadding ->
                            DeviceDetailsScreen(
                                modifier = Modifier.padding(innerPadding),
                                device = devicesViewModel.currentDevice.value
                            )
                        }
                    }
                }
            }
        }
    }
}
