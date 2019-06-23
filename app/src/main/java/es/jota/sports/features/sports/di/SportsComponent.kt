package es.jota.sports.features.sports.di

import dagger.Component
import es.jota.sports.core.di.base.BaseComponent
import es.jota.sports.core.di.base.ViewComponent
import es.jota.sports.features.sports.ui.SportsActivity

@SportsScope
@Component(dependencies = [(BaseComponent::class)], modules = [(SportsModule::class)])
interface SportsComponent : ViewComponent<SportsActivity>