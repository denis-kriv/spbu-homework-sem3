package testWorks.test1.taks1

import java.lang.Integer.max
import javax.swing.text.html.HTML.Tag.BASE




class longNumber(var value: MutableList<Int>) {

    fun plus(number: longNumber) {
        val newLength = max(value.size, number.value.size)
        val value1 = value
        val value2 = number.value
        while (value1.size < newLength) value1.plus(0)
        while (value2.size < newLength) value2.plus(0)

        for (i in 0 until newLength) {
            value1[i] += value2[i]
        }

        for (i in 0 until newLength) {
            if (value1[i] >= 999) {
                value1[i] -= 999
                value1[i + 1]++
            }
        }

        value = value1
    }

    fun minus(number: longNumber) {
        val value1 = value
        val value2 = number.value
        val newLength = max(value1.size, value2.size)
        while (value1.size < newLength) value1.plus(0)
        while (value2.size < newLength) value2.plus(0)

        for (i in 0 until newLength) {
            value1[i] - value2[i]
        }

        for (i in 0 until newLength - 1) {
            if (value1[i] < 0) {
                value1[i] += 999
                value1[i + 1]--
            }
        }

        value = value1
    }

    fun multiplication(number: longNumber) {
        val value1 = value
        val value2 = number.value
        val newLength = max(value1.size, value2.size)
        while (value1.size < newLength) value1.plus(0)
        while (value2.size < newLength) value2.plus(0)

        for (i in 0 until newLength) {
            for (j in 0 until newLength) {
                value1[i + j] += value[i] * value2[j]
            }
        }

        for (i in 0 until newLength - 1) {
            value1[i + 1] += value1[i] / 999
            value1[i] %= 999
        }

        value = value1
    }
}