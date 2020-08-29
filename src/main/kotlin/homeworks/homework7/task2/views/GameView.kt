package homeworks.homework7.task2.views

import homeworks.homework7.task2.controllers.TicTacToeController
import homeworks.homework7.task2.models.Game
import homeworks.homework7.task2.styles.GameStyle
import javafx.scene.control.Button
import tornadofx.View
import tornadofx.vbox
import tornadofx.label
import tornadofx.addClass
import tornadofx.hbox
import tornadofx.button
import tornadofx.action


class GameView : View() {

    private val controller: TicTacToeController by inject()
    private var buttons: MutableList<Button> = mutableListOf()

    override val root = vbox {
        addClass(GameStyle.mainBlock)

        val status = label("Status")

        vbox {
            addClass(GameStyle.gameFieldBlock)

            var index = Pair(0, 0)

            List(3) {
                hbox {
                    addClass(GameStyle.gameFieldBlock)

                    List(3) {
                        val item = button("  ") {
                            action {
                                if (controller.handlePlayerMove(index)) {
                                    this.text = Game.sign.toString()

                                    status.text = controller.getStatus()
                                }
                            }
                        }

                        buttons.add(item)

                        index = Pair(index.first + 1, index.second)
                    }
                }

                index = Pair(index.first, index.second + 1)
            }
        }

        button("Menu") {
            action {
                buttons.forEach { it.text = "  " }

                controller.endGame()

                replaceWith<MenuView>()
            }
        }
    }
}