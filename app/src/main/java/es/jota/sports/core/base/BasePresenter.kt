package es.jota.sports.core.base

import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.usecase.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BasePresenter<T : BaseContract.View>(
    private vararg val useCaseList: UseCase
) : BaseContract.Presenter<T> {

    protected var mView: T? = null

    override fun attachView(view: T) {
        mView = view
    }

    override fun destroy() {
        for (useCase in useCaseList) {
            useCase.cancel()
        }
        mView = null
    }

    protected fun <T> viewModelToUI(input: () -> T, output: (T) -> Unit) {
        val transformJob = GlobalScope.async(Dispatchers.Default) { input() }
        GlobalScope.launch(Dispatchers.Main) { output(transformJob.await()) }
    }

    protected open fun handleError(error: FailureType) {
    }
}