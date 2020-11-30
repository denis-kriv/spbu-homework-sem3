package homeworks.homework8.task1.online

import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.View
import tornadofx.action
import tornadofx.button
import tornadofx.combobox
import tornadofx.label
import tornadofx.vbox

class MultiplayerMenu : View() {
    private val playerSignList: ObservableList<Char> = FXCollections.observableArrayList('X', '0')
    private val selectedSign = SimpleObjectProperty<Char>()

    override val root = vbox {
        label("Your sign:")

        combobox(selectedSign, playerSignList) {
            selectionModel.selectFirst()
        }

        button("Play") {
            action {
                GameModel.playerSign = selectedSign.value
                replaceWith<OnlineGameView>()
            }
        }
    }
}