package es.jota.sports.features.sports.ui.viewmodels

import es.jota.sports.domain.models.PlayerModel
import es.jota.sports.domain.models.SportModel
import es.jota.sports.domain.models.SportType

sealed class SportsViewModel {

    companion object {
        fun transform(sportList: List<SportModel>): List<SportsViewModel> {
            val items = mutableListOf<SportsViewModel>()
            sportList.map {
                items.add(transformSport(it.type))
                items.addAll(transformPlayerList(it.players))
            }
            return items.toList()
        }

        private fun transformSport(type: SportType) =
            SportHeaderViewModel(type.value)

        private fun tranformPlayer(player: PlayerModel) =
            SportPlayerViewModel(player.name, player.surname, player.image)

        private fun transformPlayerList(playerList: List<PlayerModel>) =
            playerList.map { tranformPlayer(it) }
    }

    class SportHeaderViewModel(val title: String) : SportsViewModel()

    class SportPlayerViewModel(val name: String, val surname: String, val image: String?) : SportsViewModel()
}