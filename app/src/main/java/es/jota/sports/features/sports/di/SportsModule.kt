package es.jota.sports.features.sports.di

import dagger.Module
import dagger.Provides
import es.jota.sports.data.core.platform.NetworkHandler
import es.jota.sports.data.repository.SportsRepositoryImpl
import es.jota.sports.data.source.remote.SportsRemote
import es.jota.sports.domain.repository.SportsRepository
import es.jota.sports.domain.usecases.GetSportsUseCase
import es.jota.sports.features.sports.ui.SportsPresenter
import retrofit2.Retrofit

@Module
class SportsModule {

    @Provides
    @SportsScope
    fun provideSportsRemote(retrofit: Retrofit): SportsRemote = SportsRemote(retrofit)

    @Provides
    @SportsScope
    fun provideSportsRepository(sportsRemote: SportsRemote, networkHandler: NetworkHandler): SportsRepository =
        SportsRepositoryImpl(sportsRemote, networkHandler)

    @Provides
    @SportsScope
    fun provideGetSportsUseCase(sportsRepository: SportsRepository): GetSportsUseCase =
        GetSportsUseCase(sportsRepository)

    @Provides
    @SportsScope
    fun provideSportsPresenter(
        getSportsUseCase: GetSportsUseCase
    ): SportsPresenter = SportsPresenter(getSportsUseCase)
}