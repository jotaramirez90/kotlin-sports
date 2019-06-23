package es.jota.sports.domain.core.usecase

import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.functional.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseUseCase<out T, in Params> : UseCase where T : Any? {

    private var job: Job? = null

    abstract suspend fun run(params: Params): Either<FailureType, T>

    operator fun invoke(onResult: (Either<FailureType, T>) -> Unit, params: Params) {
        job = GlobalScope.launch(context = Dispatchers.Main) { onResult(run(params)) }
    }

    override fun cancel() {
        job?.cancel()
    }
}