package homeworks.homework4.task1

import homeworks.homework4.task1.enums.Actions
import java.lang.IllegalArgumentException

private fun readNumberOfAction(): Actions {
    println("Enter:")
    println("Plus: for add an element in table.")
    println("Minus: for remove an element from table.")
    println("GetIndex: for find out an index of element.")
    println("GetStatistics: for get statistics of table.")
    println("PlusFromFile: for add elements from file.")
    println("ChooseHashFunction: for choose hash function.")
    println("Stop: for stop program.")

    val input = readLine() ?: throw KotlinNullPointerException("String is empty.")

     try {
         return Actions.valueOf(input)
     } catch (ex: IllegalArgumentException) {
         throw IllegalArgumentException("String is not correct.")
     }
}

private fun handleInputData(): Actions? {
    var value: Actions? = null

    try {
        value = readNumberOfAction()
    } catch (ex: KotlinNullPointerException) {
        println(ex.message)
        println("Press any key to continue.")
        readLine()
    } catch (ex: IllegalArgumentException) {
        println(ex.message)
        println("Press any key to continue.")
        readLine()
    }

    return value
}

private fun actionPlus(table: HashTable) {
    try {
        println("Enter an element value.")

        table.plus(readLine())

        println("Successful.")
    } catch (ex: KotlinNullPointerException) {
        println(ex.message)
    } catch (ex: CloneNotSupportedException) {
        println(ex.message)
    } finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun actionMinus(table: HashTable) {
    try {
        println("Enter an element value.")

        table.minus(readLine())

        println("Successful.")
    } catch (ex: KotlinNullPointerException) {
        println(ex.message)
    } catch (ex: NoSuchElementException) {
        println(ex.message)
    } finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun actionGetIndex(table: HashTable) {
    try {
        println("Enter an element value.")

        println(table.getIndex(readLine()))
    } catch (ex: KotlinNullPointerException) {
        println(ex.message)
    } catch (ex: NoSuchElementException) {
        println(ex.message)
    } finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun actionGetStatistics(table: HashTable) {
    val statistics = table.getStatistics()

    println("Size: ${statistics.size}")
    println("Conflicts: ${statistics.conflicts}")
    println("Max length in line: ${statistics.maxLength}")
    println("Load factor: ${statistics.loadFactor}")

    println("Press any key to continue.")
    readLine()
}

private fun actionPlusFromFile(table: HashTable) {
    try {
        println("Enter a file path.")

        table.plusFromFile(readLine())

        println("Successful.")
    } catch (ex: KotlinNullPointerException) {
        println(ex.message)
    } catch (ex: NoSuchFileException) {
        println(ex.message)
    } finally {
        println("Press any key to continue.")
        readLine()
    }
}

private fun actionChooseHashFunction(table: HashTable) {
    try {
        println("Enter a deg for hash function:")
        println("Enter a deg for hash function.")

        table.chooseHashFunction(readLine())

        println("Successful.")
    } catch (ex: KotlinNullPointerException) {
        println(ex.message)
    } catch (ex: IllegalArgumentException) {
        println(ex.message)
    } finally {
        println("Press any key to continue.")
        readLine()
    }
}

fun main() {
    val table = HashTable()
    var isStopped = false

    while (!isStopped) {
        val input = handleInputData() ?: continue

        when (input) {
            Actions.Plus -> actionPlus(table)
            Actions.Minus -> actionMinus(table)
            Actions.GetIndex -> actionGetIndex(table)
            Actions.GetStatistics -> actionGetStatistics(table)
            Actions.PlusFromFile -> actionPlusFromFile(table)
            Actions.ChooseHashFunction -> actionChooseHashFunction(table)
            Actions.Stop -> {
                println("Program is stopped.")
                isStopped = true
            }
        }
    }
}
