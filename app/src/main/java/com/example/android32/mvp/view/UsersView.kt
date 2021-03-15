package com.example.android32.mvp.view

import com.example.android32.mvp.model.GithubUsersRepo
import com.example.android32.mvp.presenter.UsersPresenter
import com.github.terrakok.cicerone.Router
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UsersView : MvpView {
    fun init()
    fun updateList()
}