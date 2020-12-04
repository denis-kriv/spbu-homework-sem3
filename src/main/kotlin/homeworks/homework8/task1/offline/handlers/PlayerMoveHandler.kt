package homeworks.homework8.task1.offline.handlers

import homeworks.homework8.task1.offline.models.Bot
import homeworks.homework8.task1.offline.models.Game

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
