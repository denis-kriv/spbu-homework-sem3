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

private fun playerWinBlockContour(): Boolean {
    for (i in 0..2) {
        var location = Pair(0, 0)
        var quantityOfPlayerSigns = 0
        var quantityOfEmptyButtons = 0

        loop@ for (j in 0..2) {
            when (Game.buttons[i][j]) {
                Game.playerSign -> quantityOfPlayerSigns++

                " " -> {
                    location = Pair(i, j)
                    quantityOfEmptyButtons++
                }

                else -> break@loop
            }
        }

        if (quantityOfEmptyButtons == 1 && quantityOfPlayerSigns == 2) {
            Game.updateButton(location, Game.botSign)
            return true
        }
    }

    return false
}

private fun playerWinBlockVertical(): Boolean {
    for (i in 0..2) {
        var location = Pair(0, 0)
        var quantityOfPlayerSigns = 0
        var quantityOfEmptyButtons = 0

        loop@ for (j in 0..2) {
            when (Game.buttons[j][i]) {
                Game.playerSign -> quantityOfPlayerSigns++

                " " -> {
                    location = Pair(j, i)
                    quantityOfEmptyButtons++
                }

                else -> break@loop
            }
        }

        if (quantityOfEmptyButtons == 1 && quantityOfPlayerSigns == 2) {
            Game.updateButton(location, Game.botSign)
            return true
        }
    }

    return false
}

private fun playerWinBlockDiagonal(): Boolean {
    var location = Pair(0, 0)
    var quantityOfPlayerSigns = 0
    var quantityOfEmptyButtons = 0

    loop@ for (i in 0..2) {
        when (Game.buttons[i][i]) {
            Game.playerSign -> quantityOfPlayerSigns++

            " " -> {
                location = Pair(i, i)
                quantityOfEmptyButtons++
            }

            else -> break@loop
        }
    }

    if (quantityOfEmptyButtons == 1 && quantityOfPlayerSigns == 2) {
        Game.updateButton(location, Game.botSign)
        return true
    }

    location = Pair(0, 0)
    quantityOfPlayerSigns = 0
    quantityOfEmptyButtons = 0

    loop@ for (i in 0..2) {
        when (Game.buttons[i][2 - i]) {
            Game.playerSign -> quantityOfPlayerSigns++

            " " -> {
                location = Pair(i, 2 - i)
                quantityOfEmptyButtons++
            }

            else -> break@loop
        }
    }

    if (quantityOfEmptyButtons == 1 && quantityOfPlayerSigns == 2) {
        Game.updateButton(location, Game.botSign)
        return true
    }

    return false
}

private fun playerWinBlock(): Boolean {
    return playerWinBlockContour() || playerWinBlockVertical() || playerWinBlockDiagonal()
}

private fun botWinMoveContour(): Boolean {
    for (i in 0..2) {
        var location = Pair(0, 0)
        var quantityOfBotSigns = 0
        var quantityOfEmptyButtons = 0

        loop@ for (j in 0..2) {
            when (Game.buttons[i][j]) {
                Game.botSign -> quantityOfBotSigns++

                " " -> {
                    location = Pair(i, j)
                    quantityOfEmptyButtons++
                }

                else -> break@loop
            }
        }

        if (quantityOfEmptyButtons == 1 && quantityOfBotSigns == 2) {
            Game.updateButton(location, Game.botSign)
            return true
        }
    }

    return false
}

private fun botWinMoveVertical(): Boolean {
    for (i in 0..2) {
        var location = Pair(0, 0)
        var quantityOfBotSigns = 0
        var quantityOfEmptyButtons = 0

        loop@ for (j in 0..2) {
            when (Game.buttons[j][i]) {
                Game.botSign -> quantityOfBotSigns++

                " " -> {
                    location = Pair(j, i)
                    quantityOfEmptyButtons++
                }

                else -> break@loop
            }
        }

        if (quantityOfEmptyButtons == 1 && quantityOfBotSigns == 2) {
            Game.updateButton(location, Game.botSign)
            return true
        }
    }

    return false
}

private fun botWinMoveDiagonal(): Boolean {
    var location = Pair(0, 0)
    var quantityOfBotSigns = 0
    var quantityOfEmptyButtons = 0

    loop@ for (i in 0..2) {
        when (Game.buttons[i][i]) {
            Game.botSign -> quantityOfBotSigns++

            " " -> {
                location = Pair(i, i)
                quantityOfEmptyButtons++
            }

            else -> break@loop
        }
    }

    if (quantityOfEmptyButtons == 1 && quantityOfBotSigns == 2) {
        Game.updateButton(location, Game.botSign)
        return true
    }

    location = Pair(0, 0)
    quantityOfBotSigns = 0
    quantityOfEmptyButtons = 0

    loop@ for (i in 0..2) {
        when (Game.buttons[i][2 - i]) {
            Game.botSign -> quantityOfBotSigns++

            " " -> {
                location = Pair(i, 2 - i)
                quantityOfEmptyButtons++
            }

            else -> break@loop
        }
    }

    if (quantityOfEmptyButtons == 1 && quantityOfBotSigns == 2) {
        Game.updateButton(location, Game.botSign)
        return true
    }

    return false
}

private fun botWinMove(): Boolean {
    return botWinMoveContour() || botWinMoveVertical() || botWinMoveDiagonal()
}

private fun hardMove(buttons: List<Pair<Int, Int>>) {
    if (botWinMove() || playerWinBlock()) return

    if (buttons.contains(Pair(1, 1))) Game.updateButton(Pair(1, 1), Game.botSign) else easyMove(buttons)
}

class Bot {

    fun move() {
        if (Game.difficulty == "Easy") easyMove(getEmptyButtons()) else hardMove(getEmptyButtons())

        Game.checkResult()
    }
}
