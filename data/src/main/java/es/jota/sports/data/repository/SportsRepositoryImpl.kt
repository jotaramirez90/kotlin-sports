package es.jota.sports.data.repository

import es.jota.sports.data.core.platform.NetworkHandler
import es.jota.sports.data.core.repository.BaseRepository
import es.jota.sports.data.entity.SportEntity
import es.jota.sports.data.source.remote.SportsRemote
import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.functional.Either
import es.jota.sports.domain.models.SportModel
import es.jota.sports.domain.repository.SportsRepository

class SportsRepositoryImpl(
    private val sportsRemote: SportsRemote,
    networkHandler: NetworkHandler
) : SportsRepository, BaseRepository(networkHandler) {

    override suspend fun getSports(): Either<FailureType, List<SportModel>> =
        request(sportsRemote.getSports()) {
            SportEntity.transform(it)
        }
}