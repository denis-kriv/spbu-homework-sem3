package homeworks.homework8.task1

import homeworks.homework8.task1.offline.views.MenuView
import homeworks.homework8.task1.online.MultiplayerMenu
import homeworks.homework8.task1.online.GameModel
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.combobox
import tornadofx.label
import tornadofx.vbox

class GameModeChoiceMenu : View() {
    private val gameModeList: ObservableList<String> =
        FXCollections.observableArrayList("Single-player", "Multiplayer")
    private val selectedGameMode = SimpleStringProperty()

    override val root = vbox {
        label("Game mode:")

        combobox(selectedGameMode, gameModeList) {
            selectionModel.selectFirst()
        }

        button("Next") {
            action {
                GameModel.gameMode = selectedGameMode.value
                when (selectedGameMode.value) {
                    "Single-player" -> replaceWith<MenuView>()
                    else -> replaceWith<MultiplayerMenu>()
                }
            }
        }
    }
}