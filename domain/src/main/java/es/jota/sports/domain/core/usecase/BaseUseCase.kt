package es.jota.sports.domain.core.usecase

import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.functional.Either
import kotlinx.coroutines.*

abstract class BaseUseCase<out T, in Params> : UseCase where T : Any? {

    private var job: Deferred<Either<FailureType, T>>? = null

    abstract suspend fun run(params: Params): Either<FailureType, T>

    operator fun invoke(onResult: (Either<FailureType, T>) -> Unit, params: Params) {
        job = GlobalScope.async(Dispatchers.IO) { run(params) }
        GlobalScope.launch(Dispatchers.Main) { onResult.invoke(job!!.await()) }
    }

    override fun cancel() {
        job?.cancel()
    }
}