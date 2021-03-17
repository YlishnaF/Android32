package com.example.android32.mvp.model

import com.example.android32.mvp.model.entity.GithubUser
import io.reactivex.rxjava3.core.Observable


class GithubUsersRepo {
    private val users = listOf(

        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers() = Observable.just(users)
}

