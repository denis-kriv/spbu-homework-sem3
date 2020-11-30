package homeworks.homework7.task2.styles

import javafx.geometry.Pos
import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.mm

class MenuStyle : Stylesheet() {

    companion object {
        val mainBlock by cssclass()
        val choiceBlock by cssclass()

        private const val mainBlockSpacing = 5
        private const val choiceBlockSpacing = 1
    }

    init {
        mainBlock {
            spacing = mainBlockSpacing.mm
            alignment = Pos.CENTER
        }

        choiceBlock {
            spacing = choiceBlockSpacing.mm
            alignment = Pos.CENTER
        }
    }
}
