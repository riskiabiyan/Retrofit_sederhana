package com.riskiabiyan.retrofit_5190411359

import com.google.gson.annotations.SerializedName

class CreatePostResponse (
    val userId: String?,
            val id: Int,
            val title: String?,
            @SerializedName("body")
            val text: String?
    )