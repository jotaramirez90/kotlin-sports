package es.jota.sports.domain.models

data class SportModel(
    val type: SportType,
    val players: List<PlayerModel>
)