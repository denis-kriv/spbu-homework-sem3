import homeworks.homework6.task1.asyncQuickSort
import homeworks.homework6.task1.simpleQuickSort
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class SortTests {

    @Test
    fun simpleQuickSortShouldWorksCorrect() {
        val array = Array(100) { if (it % 2 == 0) it else 100 - it }

        val expected = Array(100) { it }
        simpleQuickSort(array, 0, array.lastIndex)

        assertArrayEquals(expected, array)
    }

    @Test
    fun asyncQuickSortShouldWorksCorrect() {
        val array = Array(100) { if (it % 2 == 0) it else 100 - it }

        val expected = Array(100) { it }
        runBlocking {
            launch {
                asyncQuickSort(array, 0, array.lastIndex)
            }
        }

        assertArrayEquals(expected, array)
    }
}
