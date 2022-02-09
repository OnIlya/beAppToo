package ru.netology

fun main() {
    val time = 1000
    val minute = time / 60
    val hours = (time / 60) / 60
    val result = agoToText(time, minute, hours)
    println("пользователь был $result")
}

fun agoToText(time: Int, minute: Int = time / 60, hours: Int = (time / 60) / 60): String {
    val convertMinutes = textBeAppTooConvertMinutes(time, minute)
    val convertHours = textBeAppTooConvertHours(time, hours)

    val agoToText = when(time) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "$minute $convertMinutes назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "$hours $convertHours назад"
        in 24 * 60 * 60 + 1..(24 * 60 * 60) * 2 -> "сегодня"
        in ((24 * 60 * 60) * 2) + 1..(24 * 60 * 60) * 3 -> "вчера"
        else -> "давно"
    }
    return agoToText
}

fun textBeAppTooConvertMinutes(time: Int, minute: Int = time / 60): String {

    val textBeAppTooConvertMinutes = when(minute) {
       1, 21, 31, 41, 51 -> "минуту"
       in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
       in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> "минут"
       else -> "ошибка"
    }
    return textBeAppTooConvertMinutes

}
fun textBeAppTooConvertHours(time: Int, hours: Int = (time / 60) / 60): String {
    val textBeAppTooConvertHours = when(hours) {
        1, 21 -> "час"
        in 2..4, in 22..24 -> "часа"
        in 5..20 -> "часов"
        else -> "ошибка"
    }
    return textBeAppTooConvertHours
}


