package com.jayalaga.advancemobiletask.presentation.screen.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.jayalaga.advancemobiletask.navigation.Screen
import com.jayalaga.advancemobiletask.presentation.screen.component.ExitButton
import com.jayalaga.advancemobiletask.presentation.screen.favorite.FavoriteScreen
import com.jayalaga.advancemobiletask.presentation.screen.profile.component.ImagePickerGallery
import com.jayalaga.advancemobiletask.utils.Constant.CLIENT

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    scrollState: ScrollState = rememberScrollState()
){
    var isSignedOut by remember { mutableStateOf(false) }

    if (isSignedOut){
        LaunchedEffect(Unit) {
            navController.navigate(Screen.Login.route){
                popUpTo(Screen.Schedule.route){
                    inclusive = true
                }
            }
        }
    } else {
        ProfileContent(
            navController = navController,
            onLogoutClick = {
                val googleLogin =
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .requestIdToken(CLIENT)
                        .build()

                @Suppress("DEPRECATION")
                val googleClient = GoogleSignIn.getClient(context, googleLogin)
                googleClient.signOut().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        FirebaseAuth.getInstance().signOut()
                        isSignedOut = true
                    } else {
                        Toast.makeText(
                            context,
                            "Logout Gagal",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        )
    }
}

@Composable
fun ProfileContent(
    navController: NavController,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold (
        modifier = modifier
    ){contentPadding ->
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(contentPadding)
        ){
            item{
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        ExitButton(
                            onLogoutClick = onLogoutClick,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(40.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = "Profile",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        ImagePickerGallery()
                    }
                }
            }
        }
    }
//    Scaffold (
//        modifier = modifier
//    ){contentPadding ->
//        Box (
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(24.dp)
//        ){
//            Column (
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxSize()
//            ){
//                LazyColumn (
//                    verticalArrangement = Arrangement.spacedBy(8.dp),
//                    modifier = Modifier.padding(contentPadding)
//                ){
//                    item{
//                        ExitButton(
//                            onLogoutClick = onLogoutClick,
//                            modifier = Modifier.padding(horizontal = 16.dp)
//                        )
//                    }
//                }
//                Spacer(modifier = Modifier.height(40.dp))
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Profile",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp
//                )
//                Spacer(modifier = Modifier.height(10.dp))
//                ImagePickerGallery()
//            }
//        }
//    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview(){
    ProfileScreen(navController = rememberNavController())
}