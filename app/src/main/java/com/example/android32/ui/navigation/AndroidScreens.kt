package com.example.android32.ui.navigation

import com.example.android32.mvp.model.entity.GithubUser
import com.example.android32.mvp.navigation.IScreens
import com.example.android32.ui.fragment.UserLoginFragment
import com.example.android32.ui.fragment.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(githubUser: GithubUser) = FragmentScreen {UserLoginFragment.newInstance(githubUser)}
}