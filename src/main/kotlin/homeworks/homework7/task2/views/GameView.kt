package homeworks.homework7.task2.views

import homeworks.homework7.task2.styles.GameStyle
import tornadofx.View
import tornadofx.vbox
import tornadofx.label
import tornadofx.addClass
import tornadofx.hbox
import tornadofx.button
import tornadofx.action
import tornadofx.plusAssign

class GameView : View() {

    override val root = vbox {
        addClass(GameStyle.mainBlock)

        label("Status")

        vbox {
            addClass(GameStyle.gameFieldBlock)

            for (i in 0..2) {
                this += hbox {
                    addClass(GameStyle.gameFieldBlock)

                    for (j in 0..2) {
                        this += button {
                            //TODO: add action
                            action { }
                        }
                    }
                }
            }
        }

        button("Menu") {
            action { replaceWith<MenuView>() }
        }
    }
}