package com.example.android32.mvp.presenter

import com.example.android32.mvp.model.entity.GithubUser
import com.example.android32.mvp.view.LoginView
import com.example.android32.mvp.view.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class LoginPresenter(val user: GithubUser, val router: Router) :
    MvpPresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(user.login)
    }

    fun backPressed(): Boolean{
        router.exit()
        return true
    }
}