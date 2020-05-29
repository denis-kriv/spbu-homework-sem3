package tests.test2.task1

import java.lang.NullPointerException

fun <T> bubbleSort(array: Array<T>?, comparator: Comparator<T>): Array<T> {
    if (array.isNullOrEmpty()) throw NullPointerException("array is null")
    for (i in array.indices) {
        for (j in array.size - 1 downTo i) {
            if (comparator.compare(array[i], array[j]) == 1) {
                val flag = array[j - 1];
                array[j - 1] = array[j];
                array[j] = flag;
            }
        }
    }
    return array
}