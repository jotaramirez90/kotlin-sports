package es.jota.sports.core.di.base

import es.jota.sports.core.base.BaseContract

interface ViewComponent<in T : BaseContract.View> {

    fun inject(view: T)
}