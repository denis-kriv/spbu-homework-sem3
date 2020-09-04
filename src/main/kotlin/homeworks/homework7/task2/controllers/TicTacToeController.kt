package homeworks.homework7.task2.controllers

import homeworks.homework7.task2.handlers.PlayerMoveHandler
import homeworks.homework7.task2.handlers.StartGameHandler
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
