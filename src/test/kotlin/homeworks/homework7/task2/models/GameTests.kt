package homeworks.homework7.task2.models

import homeworks.homework8.task1.offline.models.Game
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GameTests {

    @Test
    fun `isEnd should be false when field is Empty`() {
        Game.checkResult()
        assertFalse(Game.isEnd)
    }

    @Test
    fun `isEnd should be false when no one is winner`() {
        Game.buttons = arrayOf(
            arrayOf("X", " ", "0"),
            arrayOf("X", "X", "0"),
            arrayOf("0", "X", " ")
        )

        Game.checkResult()
        assertFalse(Game.isEnd)
    }

    @Test
    fun `isEnd should be true when player win by contour`() {
        Game.buttons = arrayOf(
            arrayOf("X", "0", "0"),
            arrayOf("X", "X", "X"),
            arrayOf("0", "X", "0")
        )

        Game.checkResult()
        assertTrue(Game.isEnd)
    }

    @Test
    fun `isEnd should be true when player win by vertical`() {
        Game.buttons = arrayOf(
            arrayOf(" ", "X", "0"),
            arrayOf("X", "X", "0"),
            arrayOf("0", "X", " ")
        )

        Game.checkResult()
        assertTrue(Game.isEnd)
    }

    @Test
    fun `isEnd should be true when player win by diagonal`() {
        Game.buttons = arrayOf(
            arrayOf("X", "X", "0"),
            arrayOf("X", "0", "0"),
            arrayOf("0", "X", " ")
        )

        Game.checkResult()
        assertTrue(Game.isEnd)
    }

    @Test
    fun `isEnd should be true when game end with draw`() {
        Game.buttons = arrayOf(
            arrayOf("X", "0", "0"),
            arrayOf("X", "X", "0"),
            arrayOf("0", "X", "X")
        )

        Game.checkResult()
        assertTrue(Game.isEnd)
    }
}