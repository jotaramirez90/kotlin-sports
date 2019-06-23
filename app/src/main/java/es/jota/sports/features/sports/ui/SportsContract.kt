package es.jota.sports.features.sports.ui

import es.jota.sports.core.base.BaseContract
import es.jota.sports.features.sports.ui.viewmodels.SportsViewModel

interface SportsContract {

    interface SportsView : BaseContract.View {

        fun showSportList(items: List<SportsViewModel>)

        fun showError()
    }

    interface SportsPresenter : BaseContract.Presenter<SportsView> {

        fun getSportList()
    }
}