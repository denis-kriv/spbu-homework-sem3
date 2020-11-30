package homeworks.homework8.task1.online

import io.ktor.util.KtorExperimentalAPI
import tornadofx.Controller
import tornadofx.text

class OnlineModeController : Controller() {
    private val gameModel = GameModel
    var onlineMode = OnlineMode(this)

    private fun idToInt(buttonID: String): Pair<Int, Int> {
        val splitID = buttonID.split("-").map { it.toInt() }
        return Pair(splitID[0], splitID[1])
    }

    private fun updateButton(buttonID: String, isDisable: Boolean) {
        val button = find<OnlineGameView>().root.lookup("#$buttonID")
        val id = idToInt(buttonID)
        val currentSign = gameModel.board[id.first][id.second]
        button.text(currentSign.toString())
        button.isDisable = if (currentSign.toString().isBlank()) isDisable else true
        button.opacity = 1.0
    }

    fun updateAllButtons(isDisable: Boolean) {
        for (i in 0..2) {
            for (j in 0..2) {
                updateButton("$i-$j", isDisable)
            }
        }
    }

    fun endGameHandling(gameStatus: String) {
        gameModel.winner = gameStatus
        find<OnlineGameView>().replaceWith<WinnerScreen>()
    }

    fun opponentMoveHandling(move: String) {
        val id = idToInt(move)
        gameModel.board[id.first][id.second] = gameModel.opponentSign
        updateAllButtons(isDisable = false)
    }

    fun playerMoveHandling(buttonID: String) {
        val id = idToInt(buttonID)
        gameModel.board[id.first][id.second] = gameModel.playerSign
        updateButton(buttonID, true)

        updateAllButtons(true)
        this.onlineMode.sendMove(buttonID)
    }

    @KtorExperimentalAPI
    fun newGameHandling() {
        gameModel.winner = "Draw"

        for (i in 0..2) {
            for (j in 0..2) {
                gameModel.board[i][j] = ' '
            }
        }
        updateAllButtons(true)

        onlineMode = OnlineMode(this)
        onlineMode.start()
    }
}