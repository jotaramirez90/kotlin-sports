package es.jota.sports.data.entity

import com.google.gson.annotations.SerializedName
import es.jota.sports.domain.models.PlayerModel

data class PlayerEntity(
    @SerializedName("name") val name: String?,
    @SerializedName("surname") val surname: String?,
    @SerializedName("image") val image: String?
) {

    companion object {
        fun transform(playerEntity: PlayerEntity) =
            PlayerModel(
                playerEntity.name ?: DEFAULT_STRING,
                playerEntity.surname ?: DEFAULT_STRING,
                playerEntity.image
            )

        fun transform(playerList: List<PlayerEntity>?) =
            playerList?.map { transform(it) } ?: listOf()
    }
}