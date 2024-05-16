package com.example.morningmvvm.ui.theme.screens.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.Ebby.budgetcars.Navigation.ROUTE_ACCOUNT
import com.Ebby.budgetcars.Navigation.ROUTE_HOME
import com.Ebby.budgetcars.R



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {






//    Box(
//        modifier = Modifier
//
//            .fillMaxSize(),
//
//
//
//    ) {
//
//
//
//
//
//      Image(painter = painterResource(id = R.drawable.logo1), contentDescription ="" ,
//       modifier = Modifier
//               .fillMaxSize(),
//            contentScale = ContentScale.Crop)
//    }



    Scaffold (
        modifier = Modifier
            .fillMaxSize(),


        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUTE_HOME){
                        popUpTo(ROUTE_HOME){inclusive = true}
                    } }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription ="",
                            tint = Color.Black
                        )

                    }
                },
                title = {

                }, actions = {
                    Spacer(modifier = Modifier.width(5.dp))
                    IconButton(onClick = { navController.navigate(ROUTE_ACCOUNT){popUpTo(ROUTE_HOME){inclusive= true} } }) {
                        Icon(imageVector =Icons.Filled.AccountCircle , contentDescription = "",
                            tint = Color.Black

                        )

                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.DarkGray)
            )


        },
        content = {
            Box(
                modifier = Modifier

                    .fillMaxSize()
                    .background(color = Color.Black)


            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.logo1), contentDescription = "",
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
            }

        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(painter = painterResource(id = R.drawable.rental), contentDescription ="" )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .background(Color.Black),



        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom


    ){
        Card(
            colors = CardDefaults.cardColors(Color(0xff6c6e8e)),


            modifier = Modifier
                .height(450.dp)
                .width(400.dp),
            shape = CutCornerShape(20.dp)




        ) {
            Row {

            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                colors = CardDefaults.cardColors(Color(0xff6c6e8e)),
            ) {
                Spacer(modifier = Modifier.height(100.dp))


                Row {

                    Text(text = "Need an affordable ride??",
                        fontSize = 30.sp)
                    Spacer(modifier = Modifier.height(65.dp))
                    Image(painter = painterResource(id = R.drawable.rental), contentDescription ="")

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Card (
                colors = CardDefaults.cardColors(Color(0xff6c6e8e)),
            ){
                Row {
                    Spacer(modifier = Modifier.width(80.dp))
                    ButtonOpenWebPage(url = "https://www.rentalcars.com/en/city/ke/nairobi/", buttonText ="CLICK HERE" )


                }
            }
        }
    }
}

@Composable
fun ButtonOpenWebPage(url: String, buttonText: String) {
    val context = LocalContext.current
    val openUrlLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }

    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        },
        modifier = Modifier
            .height(100.dp)
            .width(200.dp)

    ) {
        Text(text = "Click Here",
            fontSize = 30.sp)
    }
}








@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun PreviewLight(){
    HomeScreen(rememberNavController())

}