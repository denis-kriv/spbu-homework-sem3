package homeworks.homework7.task2.handlers

import homeworks.homework7.task2.models.Bot
import homeworks.homework7.task2.models.Game

class PlayerMoveHandler {

    fun handle(location: Pair<Int, Int>) {
        if (Game.buttons[location.first][location.second] != " " || Game.isEnd) return

        Game.updateButton(location, Game.playerSign)

        Game.checkResult()

        if (!Game.isEnd) {
            val bot = Bot()

            bot.move()
        }
    }
}
