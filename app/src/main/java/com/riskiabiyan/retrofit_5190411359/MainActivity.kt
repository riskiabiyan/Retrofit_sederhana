package com.riskiabiyan.retrofit_5190411359

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<PostResponse>()
    private val listComment = ArrayList<CommentResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        showPost()
//        createPost()
//        showComment()
//        updatePost
        deletePost()
    }

    private fun deletePost() {
        RetrofitClient.instance.deletePost(
            1
        ).enqueue(object : Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                tvResponseCode.text = t.message
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                tvResponseCode.text = response.code().toString()
            }

        })
    }

    private fun updatePost() {
        RetrofitClient.instance.putPost(
            5,
        4,
            5,
            null,
            "text"
        ).enqueue(object : Callback<PostResponse>{
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                tvResponseCode.text = t.message
            }

            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {

                val responseText = "Response code: ${response.code()}\n" +
                        "title: ${response.body()?.title}\n" +
                        "body: ${response.body()?.text}\n" +
                        "userId: ${response.body()?.userId}\n" +
                        "id: ${response.body()?.id}"
                tvResponseCode.text = responseText
            }

        })
    }

    private fun showComment() {
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getComments(1).enqueue(object : Callback<ArrayList<CommentResponse>>{
            override fun onFailure(call: Call<ArrayList<CommentResponse>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<CommentResponse>>,
                response: Response<ArrayList<CommentResponse>>
            ) {
                tvResponseCode.text = response.code().toString()
                response.body()?.let { listComment.addAll(it) }
                val adapter = CommentAdapter(listComment)
                rvPost.adapter = adapter
            }

        })

    }

    private fun createPost() {
        RetrofitClient.instance.createPost(
            29,
            "Retrofit Tutorial",
            "Retrofit tutorial for beginner"
        ).enqueue(object : Callback<CreatePostResponse>{
            override fun onFailure(call: Call<CreatePostResponse>, t: Throwable) {
                tvResponseCode.text = t.message
            }

            override fun onResponse(
                call: Call<CreatePostResponse>,
                response: Response<CreatePostResponse>
            ) {
                val responseText = "Response code: ${response.code()}\n" +
                        "title: ${response.body()?.title}\n" +
                        "body: ${response.body()?.text}\n" +
                        "userId: ${response.body()?.userId}\n" +
                        "id: ${response.body()?.id}"
                tvResponseCode.text = responseText
            }

        })
    }

    private fun showPost() {
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        val parameters = HashMap<String, String>()
        parameters["userId"] = "4"
        parameters["id"] = "32"

        RetrofitClient.instance.getPosts(parameters).enqueue(object: Callback<ArrayList<PostResponse>>{
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val responseCode = response.code().toString()
                tvResponseCode.text = responseCode
                response.body()?.let { list.addAll(it)}
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }

        })
    }
}
