package homeworks.homework8.task1

import homeworks.homework8.task1.offline.styles.GameStyle
import homeworks.homework8.task1.offline.styles.MenuStyle
import tornadofx.App
import tornadofx.launch

class TicTacToeApp : App(GameModeChoiceMenu::class, MenuStyle::class, GameStyle::class)

fun main() {
    launch<TicTacToeApp>()
}
