package es.jota.sports.domain.usecases

import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.functional.Either
import es.jota.sports.domain.core.usecase.BaseUseCase
import es.jota.sports.domain.core.usecase.None
import es.jota.sports.domain.models.SportModel
import es.jota.sports.domain.repository.SportsRepository

class GetSportsUseCase(
    private val sportsRepository: SportsRepository
) : BaseUseCase<List<SportModel>, None>() {

    override suspend fun run(params: None): Either<FailureType, List<SportModel>> =
        sportsRepository.getSports()
}