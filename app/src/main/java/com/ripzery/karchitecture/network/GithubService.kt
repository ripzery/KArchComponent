package com.ripzery.karchitecture.network

import com.ripzery.karchitecture.model.RepoResult
import com.ripzery.karchitecture.model.Result
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Euro on 7/20/2017 AD.
 */
interface GithubService {
    @GET("search/users")
    fun search(@Query("q") query: String, @Query("page") page: Int, @Query("per_page") perPage: Int) : Observable<Result>

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String, @Query("sort") sort: String = "stars", @Query("order") desc: String = "desc") : Observable<RepoResult>
}