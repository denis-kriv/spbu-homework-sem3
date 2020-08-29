package homeworks.homework7.task2.styles

import javafx.geometry.Pos
import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.mm

class GameStyle : Stylesheet() {

    companion object {
        val mainBlock by cssclass()
        val gameFieldBlock by cssclass()
    }

    init {
        mainBlock {
            spacing = 5.mm
            alignment = Pos.CENTER
        }

        gameFieldBlock {
            spacing = 1.mm
            alignment = Pos.CENTER
        }
    }
}