package homeworks.homework7.task2.models

import kotlin.random.Random

private fun getEmptyButtons(): List<Pair<Int, Int>> {
    val buttons = mutableListOf<Pair<Int, Int>>()

    for (i in 0..2) {
        for (j in 0..2) {
            if (Game.buttons[i][j] == " ") buttons.add(Pair(i, j))
        }
    }

    return buttons
}

private fun easyMove() {
    val buttons = getEmptyButtons()

    val index = Random.nextInt(0, buttons.size)

    val location = buttons[index]

    Game.updateButton(location, Game.botSign)
}

private fun hardMove() {
    //TODO: Hard move
}

class Bot {

    fun move() {
        if (Game.difficulty == "Easy") easyMove() else hardMove()

        Game.checkResult()
    }
}
