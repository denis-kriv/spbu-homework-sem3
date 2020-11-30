package homeworks.homework4.task2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class TreeTests {

    @Test
    fun treeInitShouldThrowsKotlinNullPointerExceptionWhenPathIsEmpty() {
        assertThrows<KotlinNullPointerException> { Tree("") }
    }

    @Test
    fun treeInitShouldThrowsKotlinNullPointerExceptionWhenPathIsBlank() {
        assertThrows<KotlinNullPointerException> { Tree("   ") }
    }

    @Test
    fun treeInitShouldThrowsNoSuchFileExceptionWhenFileDoesNotExist() {
        assertThrows<NoSuchFileException> { Tree("NotExistingFile") }
    }

    @Test
    fun treeInitShouldThrowsIllegalArgumentExceptionWhenStringIsIncorrect() {
        val path = "src/test/kotlin/homeworks/homework4/task2/data/fileWithIncorrectData.txt"

        assertThrows<IllegalArgumentException> { Tree(path) }
    }

    @Test
    fun treeInitShouldSuccessfullyCreateTreeWhenStringIsCorrect() {
        val path = "src/test/kotlin/homeworks/homework4/task2/data/fileWithCorrectData.txt"

        assertDoesNotThrow { Tree(path) }
    }
}
