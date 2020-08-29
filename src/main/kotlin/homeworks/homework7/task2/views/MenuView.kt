package homeworks.homework7.task2.views

import homeworks.homework7.task2.styles.MenuStyle
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import tornadofx.View
import tornadofx.vbox
import tornadofx.label
import tornadofx.addClass
import tornadofx.combobox
import tornadofx.button
import tornadofx.action

class MenuView : View("Menu") {

    private val difficultyLevelsList: ObservableList<String> = observableArrayList("Easy", "Hard")
    private val signsList: ObservableList<Char> = observableArrayList('X', '0')
    private val difficulty = SimpleObjectProperty<String>()
    private val sign = SimpleObjectProperty<Char>()

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

        //TODO: add action
        button("Play") {
            action {
                action { replaceWith<GameView>() }
            }
        }
    }
}