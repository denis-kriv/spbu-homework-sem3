package homeworks.homework7.task2.handlers

import homeworks.homework7.task2.models.Bot
import homeworks.homework7.task2.models.Game

class StartGameHandler {

    fun handle(sign: String, difficulty: String) {
        Game.playerSign = sign
        Game.botSign = if (sign == "X") "0" else "X"
        Game.difficulty = difficulty
        Game.status.value = "In Progress"
        Game.isEnd = false

        for (i in 0..2) {
            for (j in 0..2) {
                Game.updateButton(Pair(i, j), " ")
            }
        }

        if (sign == "0") {
            val bot = Bot()

            bot.move()
        }
    }
}
