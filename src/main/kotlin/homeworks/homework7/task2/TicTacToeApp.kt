package homeworks.homework7.task2

import homeworks.homework7.task2.styles.GameStyle
import homeworks.homework7.task2.styles.MenuStyle
import homeworks.homework7.task2.views.MenuView
import tornadofx.App
import tornadofx.launch

class TicTacToeApp : App(MenuView::class, MenuStyle::class, GameStyle::class)

fun main() {
    launch<TicTacToeApp>()
}
