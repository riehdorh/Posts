package io.posts.network

import io.posts.dto.GetPost
import io.posts.dto.ResponseSetPost
import io.posts.dto.SetPost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {
    @GET("posts")
    fun getPost() : Call<GetPost>

    @POST("posts")
    fun setPost(@Body post: SetPost) : Call<ResponseSetPost>
}