package com.example.android32.ui.navigation

import com.example.android32.mvp.navigation.IScreens
import com.example.android32.ui.fragment.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}