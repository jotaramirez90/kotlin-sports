package es.jota.sports.data.entity

import com.google.gson.annotations.SerializedName
import es.jota.sports.domain.models.SportModel
import es.jota.sports.domain.models.SportType
import es.jota.sports.domain.models.SportType.*

data class SportEntity(
    @SerializedName("title") val type: String?,
    @SerializedName("players") val players: List<PlayerEntity>?
) {

    companion object {
        fun transform(sportEntity: SportEntity) =
            SportModel(
                transformType(sportEntity.type),
                PlayerEntity.transform(sportEntity.players)
            )

        fun transform(sportList: List<SportEntity>?) =
            sportList?.map { transform(it) } ?: listOf()

        private fun transformType(type: String?): SportType =
            when (type) {
                FOOTBALL.value -> FOOTBALL
                TENNIS.value -> TENNIS
                GOLF.value -> GOLF
                FORMULA1.value -> FORMULA1
                else -> UNKNOWN
            }
    }
}