package com.example.android32.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android32.databinding.FragmentUserLoginBinding
import com.example.android32.mvp.model.entity.GithubUser
import com.example.android32.mvp.presenter.LoginPresenter
import com.example.android32.mvp.presenter.UsersPresenter
import com.example.android32.mvp.view.LoginView
import com.example.android32.ui.App
import com.example.android32.ui.BackClickListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserLoginFragment : MvpAppCompatFragment(), LoginView, BackClickListener {

    companion object {
        private const val USER_ARG = "user"
        fun newInstance(githubUser: GithubUser) = UserLoginFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, githubUser)
            }
        }
    }
    val presenter: LoginPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER_ARG) as GithubUser
        LoginPresenter(user, App.instance.router)
    }

    private var vb: FragmentUserLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )= FragmentUserLoginBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun setLogin(text: String){
        vb?.loginTv?.text = text
    }

    override fun backPressed(): Boolean =presenter.backPressed()
}