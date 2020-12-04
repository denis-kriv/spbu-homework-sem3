package homeworks.homework8.task1.offline.views

import homeworks.homework8.task1.GameModeChoiceMenu
import homeworks.homework8.task1.offline.controllers.TicTacToeController
import homeworks.homework8.task1.offline.models.Game
import homeworks.homework8.task1.offline.styles.GameStyle
import tornadofx.View
import tornadofx.addClass
import tornadofx.label
import tornadofx.vbox
import tornadofx.button
import tornadofx.hbox
import tornadofx.action

class OfflineGameView : View() {

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
            action { replaceWith<GameModeChoiceMenu>() }
        }
    }
}
