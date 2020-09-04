package homeworks.homework7.task2.views

import homeworks.homework7.task2.controllers.TicTacToeController
import homeworks.homework7.task2.models.Game
import homeworks.homework7.task2.styles.GameStyle
import tornadofx.*

class GameView : View() {

    private val controller: TicTacToeController by inject()

    override val root = vbox {
        addClass(GameStyle.mainBlock)

        label(Game.status)

        vbox {
            addClass(GameStyle.gameFieldBlock)

            Array(3) { i ->
                hbox {
                    addClass(GameStyle.gameFieldBlock)

                    Array(3) { j ->
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