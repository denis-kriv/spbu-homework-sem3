package homeworks.homework7.task2.models

object Game {
    var sign: Char = 'X'
    var difficulty: String = "Easy"
    var status: String = "In progress"
    var fields: List<List<Boolean>> = List(3) { List(3) { false } }
}