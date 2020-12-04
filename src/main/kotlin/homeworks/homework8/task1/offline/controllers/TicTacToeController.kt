package homeworks.homework8.task1.offline.controllers

import homeworks.homework8.task1.offline.handlers.PlayerMoveHandler
import homeworks.homework8.task1.offline.handlers.StartGameHandler
import tornadofx.Controller

class TicTacToeController : Controller() {

    fun startGame(sign: String, difficulty: String) {
        val handler = StartGameHandler()

        handler.handle(sign, difficulty)
    }

    fun playerMove(location: Pair<Int, Int>) {
        val handler = PlayerMoveHandler()

        handler.handle(location)
    }
}
