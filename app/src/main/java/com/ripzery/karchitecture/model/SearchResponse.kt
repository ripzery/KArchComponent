package com.ripzery.karchitecture.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Euro on 7/20/2017 AD.
 */
data class User(
        @SerializedName("login") val login: String,
        @SerializedName("id") val id: Long,
        @SerializedName("url") val url: String,
        @SerializedName("html_url") val htmlUrl: String,
        @SerializedName("followers_url") val followersUrl: String,
        @SerializedName("following_url") val followingUrl: String,
        @SerializedName("starred_url") val starredUrl: String,
        @SerializedName("gists_url") val gistsUrl: String,
        @SerializedName("type") val type: String,
        @SerializedName("score") val score: Double
)

/**
 * Entire search result data class
 */
data class Result(
        val total_count: Int,
        val incomplete_results: Boolean,
        val items: List<User>)

data class Repository(
        val id: Int,
        val name: String,
        @SerializedName("full_name") val fullName: String,
        @SerializedName("stargazers_count") val stargazersCount: Int,
        @SerializedName("forks_count") val forksCount: Int,
        val url: String
)

data class RepoResult(
        val total_count: Int,
        val incomplete_results: Boolean,
        val items: List<Repository>
)