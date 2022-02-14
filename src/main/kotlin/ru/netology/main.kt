package ru.netology


fun main() {
    val amountSeconds = 10000
    val oneMinute = 60
    val oneHour = oneMinute * 60
    val oneDay = oneHour * 24
    val amountMinutes = amountSeconds / oneMinute
    val amountHours = amountMinutes / oneMinute
    val result = agoToText(amountSeconds, amountMinutes, amountHours, oneMinute, oneHour, oneDay)
    println("пользователь был $result")
}

fun agoToText(amountSeconds: Int, amountMinutes: Int, amountHours: Int, oneMinute: Int, oneHour: Int, oneDay: Int): String {
    val convertMinutes = convertingMinutesToText(amountMinutes)
    val convertHours = convertingHoursToText(amountHours)

    val agoToText = when(amountSeconds) {
        in 0..oneMinute -> "только что"
        in oneMinute + 1..oneHour -> "$amountMinutes $convertMinutes назад"
        in oneHour + 1..oneDay -> "$amountHours $convertHours назад"
        in oneDay + 1..oneDay * 2 -> "сегодня"
        in oneDay * 2 + 1..oneDay * 3 -> "вчера"
        else -> "давно"
    }
    return agoToText
}

fun convertingMinutesToText(amountMinutes: Int): String {

    val convertingMinutesToText = when(amountMinutes) {
       1, 21, 31, 41, 51 -> "минуту"
       in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
       in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> "минут"
       else -> "ошибка"
    }
    return convertingMinutesToText

}
fun convertingHoursToText(amountHours: Int): String {
    val convertingHoursToText = when(amountHours) {
        1, 21 -> "час"
        in 2..4, in 22..24 -> "часа"
        in 5..20 -> "часов"
        else -> "ошибка"
    }
    return convertingHoursToText
}


