package es.jota.sports.core.base

import android.app.Activity
import android.os.Bundle
import es.jota.sports.core.base.BaseContract.Presenter
import es.jota.sports.core.base.BaseContract.View
import es.jota.sports.core.di.base.ViewComponent
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<in V : View, P : Presenter<V>, out C : ViewComponent<V>> : Activity() {

    @Inject
    protected lateinit var mPresenter: P

    protected abstract fun bindComponent(): C

    protected abstract fun bindLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindComponent().inject(this as V)
        setContentView(layoutInflater.inflate(bindLayout(), null))
        mPresenter.attachView(this as V)
        mPresenter.create()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.resume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.destroy()
    }
}