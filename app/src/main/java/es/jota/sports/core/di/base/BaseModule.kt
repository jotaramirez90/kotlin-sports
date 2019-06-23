package es.jota.sports.core.di.base

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import es.jota.sports.BaseApplication
import javax.inject.Singleton

@Module
class BaseModule(private val app: BaseApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app
}