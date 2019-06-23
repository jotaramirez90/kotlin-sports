package es.jota.sports.domain.repository

import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.functional.Either
import es.jota.sports.domain.models.SportModel

interface SportsRepository {

    suspend fun getSports(): Either<FailureType, List<SportModel>>
}