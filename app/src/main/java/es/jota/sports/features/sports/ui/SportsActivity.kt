package es.jota.sports.features.sports.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import es.jota.sports.BaseApplication
import es.jota.sports.R
import es.jota.sports.core.base.BaseActivity
import es.jota.sports.common.RecyclerDividerItemDecoration
import es.jota.sports.features.sports.di.DaggerSportsComponent
import es.jota.sports.features.sports.di.SportsComponent
import es.jota.sports.features.sports.ui.SportsContract.SportsView
import es.jota.sports.features.sports.ui.viewmodels.SportsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class SportsActivity : BaseActivity<SportsActivity, SportsPresenter, SportsComponent>(), SportsView {

    private lateinit var adapter: SportsAdapter

    override fun bindComponent(): SportsComponent =
        DaggerSportsComponent.builder().baseComponent(BaseApplication.baseComponent).build()

    override fun bindLayout(): Int = R.layout.activity_main

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        rv_sports.layoutManager = LinearLayoutManager(this)
        rv_sports.addItemDecoration(RecyclerDividerItemDecoration(this))
        rv_sports.setHasFixedSize(true)
        adapter = SportsAdapter()
        rv_sports.adapter = adapter
        mPresenter.getSportList()
    }

    override fun showSportList(items: List<SportsViewModel>) {
        pb_loading.visibility = View.GONE
        adapter.updateData(items)
        rv_sports.visibility = View.VISIBLE
    }

    override fun showError() {
        pb_loading.visibility = View.GONE
        tv_error.visibility = View.VISIBLE
    }
}
