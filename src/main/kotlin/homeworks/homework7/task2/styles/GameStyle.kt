package homeworks.homework7.task2.styles

import javafx.geometry.Pos
import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.mm

class GameStyle : Stylesheet() {

    companion object {
        val mainBlock by cssclass()
        val gameFieldBlock by cssclass()

        private const val mainBlockSpacing = 5
        private const val gameFieldBlockSpacing = 1
    }

    init {
        mainBlock {
            spacing = mainBlockSpacing.mm
            alignment = Pos.CENTER
        }

        gameFieldBlock {
            spacing = gameFieldBlockSpacing.mm
            alignment = Pos.CENTER
        }
    }
}
