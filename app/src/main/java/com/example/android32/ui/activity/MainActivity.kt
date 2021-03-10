package com.example.android32.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android32.R
import com.example.android32.databinding.ActivityMainBinding
import com.example.android32.mvp.presenter.MainPresenter
import com.example.android32.mvp.view.MainView
import com.example.android32.ui.App
import com.example.android32.ui.BackClickListener
import com.example.android32.ui.adapter.UsersRVAdapter
import com.example.android32.ui.navigation.AndroidScreens
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, AndroidScreens())
    }

    private var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackClickListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }

}