package homeworks.homework7.task2.commands

import homeworks.homework7.task2.models.Game

class EndGameCommand {

    fun execute() {
        Game.fields = List(3) { List(3) { false } }
    }
}