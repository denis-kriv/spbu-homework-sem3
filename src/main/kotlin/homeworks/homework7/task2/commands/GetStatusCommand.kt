package homeworks.homework7.task2.commands

import homeworks.homework7.task2.models.Game

class GetStatusCommand {

    fun execute(): String {
        return Game.status
    }
}