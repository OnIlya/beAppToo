package ru.netology

const val oneMinute = 60
const val oneHour = 3600
const val oneDay = 86400

fun main() {
    val amountSeconds = 80000
    val result = agoToText(amountSeconds)
    println("Пользователь был $result")
}

fun agoToText(amountSeconds: Int): String {
    val amountMinutes = amountSeconds / oneMinute
    val amountHours = amountSeconds / oneHour
    val convertMinutes = convertingMinutesToText(amountSeconds)
    val convertHours = convertingHoursToText(amountSeconds)

    return when(amountSeconds) {
        in 0..oneMinute -> "только что"
        in oneMinute + 1..oneHour -> "$amountMinutes $convertMinutes назад"
        in oneHour + 1..oneDay -> "$amountHours $convertHours назад"
        in oneDay + 1..oneDay * 2 -> "сегодня"
        in oneDay * 2 + 1..oneDay * 3 -> "вчера"
        else -> "давно"
    }
}

fun convertingMinutesToText(amountSeconds: Int): String {
    val amountMinutes = amountSeconds / oneMinute
    val remainsMinutesTen: Int = amountMinutes % 10
    val remainsMinutesHundred: Int = amountMinutes % 100

    return when {
        (remainsMinutesTen == 1 && remainsMinutesHundred != 11) -> "минуту"
        (remainsMinutesTen in 2..4 && remainsMinutesHundred !in 11..14) -> "минуты"
        else -> "минут"
    }
}

fun convertingHoursToText(amountSeconds: Int): String {
    val amountHours = amountSeconds / oneHour
    val remainsHoursTen: Int = amountHours % 10
    val remainsHoursHundred: Int = amountHours % 100

    return when {
        (remainsHoursTen == 1 && remainsHoursHundred != 11) -> "час"
        (remainsHoursTen in 2..4 && remainsHoursHundred !in 11..14) -> "часа"
        else -> "часов"
    }
}

// Доработка: Сообразил с остатком от деления

