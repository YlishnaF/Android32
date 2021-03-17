package com.example.android32.mvp.model

import com.example.android32.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import java.util.*

class GithubUsersRepo {
    private val users = listOf(

        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

//    fun getUsers(): List<GithubUser> {
//        return users
//    }
    fun getUsers() = Observable.just(users)
}

