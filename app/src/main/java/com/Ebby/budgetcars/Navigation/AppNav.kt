    package com.Ebby.budgetcars.Navigation
    import AboutScreen
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.Ebby.budgetcars.ui.theme.Screens.Login.Login
    import com.Ebby.budgetcars.ui.theme.Screens.Signup.SignupScreen
    import com.Ebby.budgetcars.ui.theme.Screens.Splash.splash
    import com.example.morningmvvm.ui.theme.screens.home.HomeScreen


    @Composable
    fun AppNav(modifier: Modifier=Modifier,navController: NavHostController= rememberNavController(),
               startDestination: String= ROUTE_SPLASH){
        NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
            composable(ROUTE_LOGIN){
                Login(navController)
            }
            composable(ROUTE_HOME){
                HomeScreen(navController = navController)
            }
            composable(ROUTE_SPLASH){
                splash(navController)
            }
            composable(ROUTE_SIGNUP){
                SignupScreen(navController = navController) {
                    
                }
            }
            composable(ROUTE_ACCOUNT) {
                AboutScreen(navController)
            }

        }
    }
