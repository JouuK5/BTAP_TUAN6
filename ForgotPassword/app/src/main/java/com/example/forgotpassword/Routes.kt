package com.example.forgotpassword

import kotlinx.serialization.Serializable
import androidx.compose.ui.graphics.Color

@Serializable data object Home
@Serializable data class Profile(val name:String, val email:String, val photoUrl:String?)
@Serializable data class Verify(val email:String)
@Serializable data class NewPass(val email:String, val code:String)
@Serializable data class Confirm(val email: String, val code: String, val password: String)
@Serializable data object TaskList

@Serializable data class TaskDetail(val id: Int)



