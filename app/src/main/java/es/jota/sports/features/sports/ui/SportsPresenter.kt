package es.jota.sports.features.sports.ui

import es.jota.sports.core.base.BasePresenter
import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.usecase.None
import es.jota.sports.domain.models.SportModel
import es.jota.sports.domain.usecases.GetSportsUseCase
import es.jota.sports.features.sports.ui.SportsContract.SportsPresenter
import es.jota.sports.features.sports.ui.SportsContract.SportsView
import es.jota.sports.features.sports.ui.viewmodels.SportsViewModel

class SportsPresenter(
    private val getSportsUseCase: GetSportsUseCase
) : BasePresenter<SportsView>(getSportsUseCase), SportsPresenter {

    override fun getSportList() {
        getSportsUseCase(
            { it.either(::handleError, ::handleSportListSuccess) },
            None
        )
    }

    override fun handleError(error: FailureType) {
        mView?.showError()
    }

    private fun handleSportListSuccess(sportList: List<SportModel>) {
        viewModelToUI(
            { SportsViewModel.transform(sportList) },
            { mView?.showSportList(it) }
        )
    }
}