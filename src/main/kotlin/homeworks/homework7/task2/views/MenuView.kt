package homeworks.homework7.task2.views

import homeworks.homework7.task2.controllers.TicTacToeController
import homeworks.homework7.task2.styles.MenuStyle
import javafx.beans.property.SimpleObjectProperty
import tornadofx.View
import tornadofx.vbox
import tornadofx.label
import tornadofx.addClass
import tornadofx.combobox
import tornadofx.button
import tornadofx.action

class MenuView : View("Menu") {

    private val signsList: List<String> = listOf("X", "0")
    private val difficultyLevelsList: List<String> = listOf("Easy", "Hard")
    private val sign = SimpleObjectProperty<String>()
    private val difficulty = SimpleObjectProperty<String>()
    private val controller: TicTacToeController by inject()

    override val root = vbox {
        addClass(MenuStyle.mainBlock)

        vbox {
            addClass(MenuStyle.choiceBlock)

            label("Select sign")

            combobox(sign, signsList) { selectionModel.selectFirst() }
        }

        vbox {
            addClass(MenuStyle.choiceBlock)

            label("Select difficulty")

            combobox(difficulty, difficultyLevelsList) { selectionModel.selectFirst() }
        }

        button("Play") {
            action {
                controller.startGame(sign.value, difficulty.value)

                replaceWith<GameView>()
            }
        }
    }
}