package com.riskiabiyan.retrofit_5190411359


import retrofit2.Call
import retrofit2.http.*

interface Api {
//    @GET("posts")
//    fun getPosts(
//        @Query("userId") userId: Int,
//        @Query("id") id: Int): Call<ArrayList<PostResponse>>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: Int) : Call<Void>


    @FormUrlEncoded
    @PUT("posts/{id}")
    fun putPost(
        @Path("id") id:Int,
        @Field("userId") userId: Int,
        @Field("id") idField: Int,
        @Field("title") title: String?,
        @Field("body") text: String? //null pointer data bisa kosong
    ): Call<PostResponse>

    @FormUrlEncoded
    @PATCH("posts/{id}")
    fun patchPost(
        @Path("id") id:Int,
        @Field("userId") userId: Int,
        @Field("id") idField: Int,
        @Field("title") title: String?,
        @Field("body") text: String? //null pointer data bisa kosong
    ): Call<PostResponse>

//    Tampikan dengan QueryMap
    @GET("posts")
    fun getPosts(
        @QueryMap parameters: HashMap<String, String>
    ): Call<ArrayList<PostResponse>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int) : Call<ArrayList<CommentResponse>>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") text: String
        ): Call<CreatePostResponse>
}