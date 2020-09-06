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

private fun easyMove(buttons: List<Pair<Int, Int>>) {
    val index = Random.nextInt(0, buttons.size)

    val location = buttons[index]

    Game.updateButton(location, Game.botSign)
}

private fun moveContour(sign: String): Boolean {
    for (i in 0..2) {
        var location = Pair(0, 0)
        var quantityOfSigns = 0
        var quantityOfEmptyButtons = 0

        loop@ for (j in 0..2) {
            when (Game.buttons[i][j]) {
                sign -> quantityOfSigns++

                " " -> {
                    location = Pair(i, j)
                    quantityOfEmptyButtons++
                }

                else -> break@loop
            }
        }

        if (quantityOfEmptyButtons == 1 && quantityOfSigns == 2) {
            Game.updateButton(location, Game.botSign)
            return true
        }
    }

    return false
}

private fun moveVertical(sign: String): Boolean {
    for (i in 0..2) {
        var location = Pair(0, 0)
        var quantityOfSigns = 0
        var quantityOfEmptyButtons = 0

        loop@ for (j in 0..2) {
            when (Game.buttons[j][i]) {
                sign -> quantityOfSigns++

                " " -> {
                    location = Pair(j, i)
                    quantityOfEmptyButtons++
                }

                else -> break@loop
            }
        }

        if (quantityOfEmptyButtons == 1 && quantityOfSigns == 2) {
            Game.updateButton(location, Game.botSign)
            return true
        }
    }

    return false
}

private fun moveDiagonal(sign: String): Boolean {
    var location = Pair(0, 0)
    var quantityOfSigns = 0
    var quantityOfEmptyButtons = 0

    loop@ for (i in 0..2) {
        when (Game.buttons[i][i]) {
            sign -> quantityOfSigns++

            " " -> {
                location = Pair(i, i)
                quantityOfEmptyButtons++
            }

            else -> break@loop
        }
    }

    if (quantityOfEmptyButtons == 1 && quantityOfSigns == 2) {
        Game.updateButton(location, Game.botSign)
        return true
    }

    location = Pair(0, 0)
    quantityOfSigns = 0
    quantityOfEmptyButtons = 0

    loop@ for (i in 0..2) {
        when (Game.buttons[i][2 - i]) {
            Game.botSign -> quantityOfSigns++

            " " -> {
                location = Pair(i, 2 - i)
                quantityOfEmptyButtons++
            }

            else -> break@loop
        }
    }

    if (quantityOfEmptyButtons == 1 && quantityOfSigns == 2) {
        Game.updateButton(location, Game.botSign)
        return true
    }

    return false
}

private fun hardMove(buttons: List<Pair<Int, Int>>) {
    if (
        moveContour(Game.botSign) ||
        moveVertical(Game.botSign) ||
        moveDiagonal(Game.botSign) ||
        moveContour(Game.playerSign) ||
        moveVertical(Game.playerSign) ||
        moveDiagonal(Game.playerSign)
    ) return

    if (buttons.contains(Pair(1, 1))) Game.updateButton(Pair(1, 1), Game.botSign) else easyMove(buttons)
}

class Bot {

    fun move() {
        if (Game.difficulty == "Easy") easyMove(getEmptyButtons()) else hardMove(getEmptyButtons())

        Game.checkResult()
    }
}
