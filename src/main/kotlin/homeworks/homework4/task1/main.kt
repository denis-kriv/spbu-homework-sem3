package homeworks.homework4.task1

import java.lang.Character.isDigit

private fun readNumberOfAction(): Int {
    print("Hello: 1, 2, 3, 4, 5")

    val input = readLine() ?: throw NullPointerException("String is empty.")

    return if (input.all { isDigit(it) }) input.toInt() else throw ArithmeticException("String is not number.")
}

private fun action0(table: HashTable) {
    try {
        table.plus(readLine())
        println("Successful.")
    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: CloneNotSupportedException) {
        println(exception.message)
    }
}

private fun action1(table: HashTable) {
    try {
        table.minus(readLine())
        println("Successful.")
    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: NoSuchElementException) {
        println(exception.message)
    }
}

private fun action2(table: HashTable) {
    try {
        println(table.getIndex(readLine()))
    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: NoSuchElementException) {
        println(exception.message)
    }
}

private fun action3(table: HashTable) {
    val output = table.getStatistics()
}

private fun action4(table: HashTable) {
    try {
        table.plusFromFile(readLine())
        println("Successful.")
    }catch (exception: NullPointerException) {
        println(exception.message)
    }catch (exception: NoSuchFileException) {
        println(exception.message)
    }
}

private fun action5(table: HashTable) {
    try {
        table.chooseHashFunction(readLine())
        println("Successful.")
    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: ArithmeticException) {
        println(exception.message)
    }
}

fun main() {
    val table = HashTable()

    loop@ while (true) {
        var number = 0

        try {
            number = readNumberOfAction()
        } catch (exception: NullPointerException) {
            println(exception.message)
            continue
        } catch (exception: ArithmeticException) {
            println(exception.message)
            continue
        }

        when (number) {
            0 -> action0(table)
            1 -> action1(table)
            2 -> action2(table)
            3 -> action3(table)
            4 -> action4(table)
            5 -> action5(table)
            6 -> break@loop
            else -> println("Action with this number is not exist.")
        }
    }
}