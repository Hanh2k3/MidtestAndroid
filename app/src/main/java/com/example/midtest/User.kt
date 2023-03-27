package com.example.midtest

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("completed")
    var completed: Boolean
) {

}