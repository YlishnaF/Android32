package com.example.android32.mvp.navigation

import com.example.android32.mvp.model.entity.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(githubUser: GithubUser) : Screen
}