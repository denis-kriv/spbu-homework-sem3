package homeworks.homework7.task2.styles

import javafx.geometry.Pos
import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.mm

class MenuStyle : Stylesheet() {

    companion object {
        val mainBlock by cssclass()
        val choiceBlock by cssclass()
    }

    init {
        mainBlock {
            spacing = 5.mm
            alignment = Pos.CENTER
        }

        choiceBlock {
            spacing = 1.mm
            alignment = Pos.CENTER
        }
    }
}