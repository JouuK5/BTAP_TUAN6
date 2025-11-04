package com.example.forgotpassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.forgotpassword.ui.theme.ForgotPasswordTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgotPasswordTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Home) {
                        composable<Home> { HomeScreen(navController) }
                        composable<Profile> {
                            val args = it.toRoute<Profile>()
                            ProfileScreen(navController,args.name,args.email,args.photoUrl)
                        }

                        composable<TaskList> {
                            TaskScreen(navController)
                        }

                        composable<TaskDetail>{
                            val args = it.toRoute<TaskDetail>()
                            TaskDetailScreen(navController, args.id)
                        }
//                        composable<Verify> {
//                            val args = it.toRoute<Verify>()
//                            VerifyCodeScreen(navController,args.email)
//                        }
//                        composable<NewPass> {
//                            val args = it.toRoute<NewPass>()
//                            ResetPasswordScreen(navController,args.email, args.code) }
//                        composable<Confirm> {
//                            val args = it.toRoute<Confirm>()
//                            ConfirmScreen(navController, args.email, args.code, args.password) }
                    }
                }
            }
        }
    }
}

