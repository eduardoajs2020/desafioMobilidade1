package com.example.desafiomobilidade

import org.w3c.dom.Comment

interface ApiService1 {
    @GET("/posts")
    suspend fun <Post> getPosts(): List<Post>

    @GET("/posts/{id}")
    suspend fun <Post> getPostById(@Path("id") id: Int): Post

    @GET("/posts/{id}/comments")
    suspend fun getCommentsByPostId(@Path("id") id: Int): List<Comment>

    @POST("/posts")
    suspend fun <Post> createPost(@Body post: Post): Post

    @PUT("/posts/{id}")
    suspend fun updatePostById(@Path("id") id: Int, @Body post: Post): Post

    @PATCH("/posts/{id}")
    suspend fun patchPostById(@Path("id") id: Int, @Body post: Post): Post


}

annotation class DELETE(val value: String)

annotation class PATCH(val value: String)

annotation class PUT(val value: String)

class Post

annotation class Body

annotation class Path(val value: String)

annotation class POST(val value: String)

annotation class GET(val value: String)
