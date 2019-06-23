package es.jota.sports.domain.core.exception

sealed class FailureType {
    object NetworkConnection : FailureType()
    data class LocalError(val message: String) : FailureType()
    data class RemoteError(val message: String) : FailureType()
}