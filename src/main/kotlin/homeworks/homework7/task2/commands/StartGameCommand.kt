package homeworks.homework7.task2.commands

import homeworks.homework7.task2.models.Game

class StartGameCommand {

    fun execute(sign: Char, difficulty: String) {
        Game.sign = sign
        Game.difficulty = difficulty
        Game.status = "In progress"
    }
}