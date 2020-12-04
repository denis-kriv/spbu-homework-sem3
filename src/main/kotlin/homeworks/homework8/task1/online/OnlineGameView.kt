package homeworks.homework8.task1.online

import homeworks.homework8.task1.GameModeChoiceMenu
import homeworks.homework8.task1.offline.models.Game
import homeworks.homework8.task1.offline.styles.GameStyle
import io.ktor.util.KtorExperimentalAPI
import tornadofx.View
import tornadofx.addClass
import tornadofx.label
import tornadofx.vbox
import tornadofx.button
import tornadofx.hbox
import tornadofx.action

class OnlineGameView : View() {

    companion object {
        private const val size = 3
    }

    private val controller: OnlineModeController by inject()

    @KtorExperimentalAPI
    override fun onDock() {
        controller.newGameHandling()
        super.onDock()
    }

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

                            action { controller.playerMoveHandling(id) }
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
