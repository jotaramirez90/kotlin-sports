package es.jota.sports

import android.app.Application
import es.jota.sports.core.di.base.BaseComponent
import es.jota.sports.core.di.base.BaseModule
import es.jota.sports.core.di.base.DaggerBaseComponent

class BaseApplication : Application() {

    companion object {
        lateinit var baseComponent: BaseComponent
    }

    override fun onCreate() {
        super.onCreate()
        this.initializeInjector()
    }

    private fun initializeInjector() {
        baseComponent = DaggerBaseComponent.builder()
            .baseModule(BaseModule(this))
            .build()
    }
}