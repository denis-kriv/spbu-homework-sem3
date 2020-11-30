package homeworks.homework7.task2.views

import homeworks.homework7.task2.controllers.TicTacToeController
import homeworks.homework7.task2.models.Game
import homeworks.homework7.task2.styles.GameStyle
import tornadofx.View
import tornadofx.addClass
import tornadofx.label
import tornadofx.vbox
import tornadofx.button
import tornadofx.hbox
import tornadofx.action

class GameView : View() {

    companion object {
        private const val size = 3
    }

    private val controller: TicTacToeController by inject()

    override val root = vbox {
        addClass(GameStyle.mainBlock)

        label(Game.status)

        vbox {
            addClass(GameStyle.gameFieldBlock)

            Array(size) { i ->
                hbox {
                    addClass(GameStyle.gameFieldBlock)

                    Array(size) { j ->
                        button {
                            id = "$i-$j"

                            action { controller.playerMove(Pair(i, j)) }
                        }
                    }
                }
            }
        }

        button("Menu") {
            action {
                replaceWith<MenuView>()
            }
        }
    }
}
