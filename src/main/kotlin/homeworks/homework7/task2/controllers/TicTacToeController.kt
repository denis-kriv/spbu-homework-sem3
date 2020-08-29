package homeworks.homework7.task2.controllers

import homeworks.homework7.task2.commands.EndGameCommand
import homeworks.homework7.task2.commands.GetStatusCommand
import homeworks.homework7.task2.commands.HandlePlayerMoveCommand
import homeworks.homework7.task2.commands.StartGameCommand
import tornadofx.Controller

class TicTacToeController : Controller() {

    fun startGame(sign: Char, difficulty: String) {
        val command = StartGameCommand()

        command.execute(sign, difficulty)
    }

    fun endGame() {
        val command = EndGameCommand()

        command.execute()
    }

    fun handlePlayerMove(buttonLocation: Pair<Int, Int>): Boolean {
        val command = HandlePlayerMoveCommand()

        return command.execute(buttonLocation)
    }

    fun getStatus(): String {
        val command = GetStatusCommand()

        return command.execute()
    }
}
