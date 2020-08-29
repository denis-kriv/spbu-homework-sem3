package homeworks.homework7.task2.models

object Game {
    var sign: Char = 'X'
    var difficulty: String = "Easy"
    var fields: Array<Array<Boolean>> = Array(3) { Array(3) { false } }
}