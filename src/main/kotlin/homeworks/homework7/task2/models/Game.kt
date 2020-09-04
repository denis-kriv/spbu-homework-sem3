package homeworks.homework7.task2.models

import homeworks.homework7.task2.views.GameView
import javafx.beans.property.SimpleObjectProperty
import tornadofx.find
import tornadofx.text

private fun checkDiagonal(): Boolean {
    var playerWin = true
    var botWin = true

    for (i in 0..2) {
        if (Game.buttons[i][i] != Game.playerSign) playerWin = false
        if (Game.buttons[i][i] != Game.botSign) botWin = false
    }

    if (playerWin || botWin) {
        Game.status.value = if (playerWin) "Player win" else "Bot win"
        return true
    }

    playerWin = true
    botWin = true

    for (i in 0..2) {
        if (Game.buttons[i][2 - i] != Game.playerSign) playerWin = false
        if (Game.buttons[i][2 - i] != Game.botSign) botWin = false
    }

    if (playerWin || botWin) {
        Game.status.value = if (playerWin) "Player win" else "Bot win"
        return true
    }

    return false
}

private fun checkVertical(): Boolean {
    for (i in 0..2) {
        var playerWin = true
        var botWin = true

        for (j in 0..2) {
            if (Game.buttons[j][i] != Game.playerSign) playerWin = false
            if (Game.buttons[j][i] != Game.botSign) botWin = false
        }

        if (playerWin || botWin) {
            Game.status.value = if (playerWin) "Player win" else "Bot win"
            return true
        }
    }

    return false
}

private fun checkContour(): Boolean {
    for (i in 0..2) {
        var playerWin = true
        var botWin = true

        for (j in 0..2) {
            if (Game.buttons[i][j] != Game.playerSign) playerWin = false
            if (Game.buttons[i][j] != Game.botSign) botWin = false
        }

        if (playerWin || botWin) {
            Game.status.value = if (playerWin) "Player win" else "Bot win"
            return true
        }
    }

    return false
}

private fun checkIfDraw(): Boolean {
    for (i in 0..2) {
        for (j in 0..2) {
            if (Game.buttons[j][i] == " ") {
                return false
            }
        }
    }

    Game.status.value = "Draw"

    return true
}

object Game {
    var playerSign: String = "X"
    var botSign: String = "0"
    var difficulty: String = "Easy"
    var status: SimpleObjectProperty<String> = SimpleObjectProperty("In Progress")
    var isEnd: Boolean = false
    var buttons: Array<Array<String>> = Array(3) { Array(3) { " " } }

    fun checkResult() {
        isEnd = checkDiagonal() || checkVertical() || checkContour() || checkIfDraw()
    }

    fun updateButton(location: Pair<Int, Int>, value: String) {
        buttons[location.first][location.second] = value

        val button = find<GameView>().root.lookup("#${location.first}-${location.second}")
        button.text(value)
    }
}