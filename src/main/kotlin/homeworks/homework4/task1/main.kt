package homeworks.homework4.task1

import java.lang.Character.isDigit

private fun readNumberOfAction(): Int {
    println("Press:")
    println("0: for add an element in table.")
    println("1: for remove an element from table.")
    println("2: for find out an index of element.")
    println("3: for get statistics of table.")
    println("4: for add elements from file.")
    println("5: for choose hash function.")
    println("6: for stop program.")

    val input = readLine() ?: throw NullPointerException("String is empty.")

    return if (input.all { isDigit(it) }) input.toInt() else throw ArithmeticException("String is not number.")
}

private fun action0(table: HashTable) {
    try {
        println("Enter an element value.")

        table.plus(readLine())

        println("Successful.")

    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: CloneNotSupportedException) {
        println(exception.message)
    } finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun action1(table: HashTable) {
    try {
        println("Enter an element value.")

        table.minus(readLine())

        println("Successful.")

    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: NoSuchElementException) {
        println(exception.message)
    }finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun action2(table: HashTable) {
    try {
        println("Enter an element value.")

        println(table.getIndex(readLine()))

    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: NoSuchElementException) {
        println(exception.message)
    }finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun action3(table: HashTable) {
    val output = table.getStatistics()

    println("Size: ${output[0]}")
    println("Conflicts: ${output[1]}")
    println("Max length in line: ${output[2]}")
    println("Load factor: ${output[3]}")

    println("Press any key to continue.")
    readLine()
}

private fun action4(table: HashTable) {
    try {
        println("Enter a file path.")

        table.plusFromFile(readLine())

        println("Successful.")

    }catch (exception: NullPointerException) {
        println(exception.message)
    }catch (exception: NoSuchFileException) {
        println(exception.message)
    }finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun action5(table: HashTable) {
    try {
        println("Enter an element value.")

        table.chooseHashFunction(readLine())

        println("Successful.")

    } catch (exception: NullPointerException) {
        println(exception.message)
    } catch (exception: ArithmeticException) {
        println(exception.message)
    }finally {
        println("Press any key to continue.")
        readLine()
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
            println("Press any key to continue.")
            readLine()
            continue
        } catch (exception: ArithmeticException) {
            println(exception.message)
            println("Press any key to continue.")
            readLine()
            continue
        }

        when (number) {
            0 -> action0(table)
            1 -> action1(table)
            2 -> action2(table)
            3 -> action3(table)
            4 -> action4(table)
            5 -> action5(table)
            6 -> {
                println("Program is stopped.")
                break@loop
            }
            else -> {
                println("Action with this number is not exist.")

                println("Press any key to continue.")
                readLine()
            }
        }
    }
}