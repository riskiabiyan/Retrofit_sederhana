package com.riskiabiyan.retrofit_5190411359

import com.google.gson.annotations.SerializedName

data class CommentResponse (
    val postId: Int,
    val id: Int,
    val name : String,
    val email : String,
    val body: String
)
