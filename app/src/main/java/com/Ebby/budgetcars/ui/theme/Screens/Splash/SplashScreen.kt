package com.Ebby.budgetcars.ui.theme.Screens.Splash
import com.Ebby.budgetcars.Navigation.ROUTE_HOME
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.Ebby.budgetcars.Navigation.ROUTE_LOGIN
import com.Ebby.budgetcars.Navigation.ROUTE_SIGNUP
import com.Ebby.budgetcars.R
import kotlinx.coroutines.delay


@Composable
fun splash(navController: NavHostController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }


    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate(ROUTE_LOGIN)
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.rental),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}

@Preview
@Composable
private fun Slashprev() {
    splash(navController = rememberNavController())
}
