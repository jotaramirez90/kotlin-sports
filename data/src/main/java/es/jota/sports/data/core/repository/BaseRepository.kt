package es.jota.sports.data.core.repository

import es.jota.sports.data.core.platform.NetworkHandler
import es.jota.sports.domain.core.exception.FailureType
import es.jota.sports.domain.core.exception.FailureType.ServerError
import es.jota.sports.domain.core.functional.Either
import es.jota.sports.domain.core.functional.Either.Left
import retrofit2.Call

open class BaseRepository(private val networkHandler: NetworkHandler) {

    open fun <T, R> request(call: Call<T>, transform: (T) -> R): Either<FailureType, R> {
        return try {
            when (networkHandler.isConnected) {
                true -> {
                    val response = call.execute()
                    when (response.isSuccessful) {
                        true -> {
                            response.body()?.let {
                                Either.Right(transform(it))
                            } ?: Left(ServerError)
                        }
                        false -> Left(ServerError)
                    }
                }
                false, null -> Left(FailureType.NetworkConnection)
            }
        } catch (exception: Throwable) {
            Left(ServerError)
        }
    }
}