package ru.netology

const val oneMinute = 60
const val oneHour = 3600
const val oneDay = 86400

fun main() {
    val amountSeconds = 500
    val result = agoToText(amountSeconds)
    println("Пользователь был $result")
}

fun agoToText(amountSeconds: Int): String {

    return when(amountSeconds) {
        in 0..oneMinute -> "только что"
        in oneMinute + 1..oneHour -> {
            val amountMinutes = amountSeconds / oneMinute
            val convertMinutes = convertingMinutesToText(amountMinutes)
            "$amountMinutes $convertMinutes назад"
        }
        in oneHour + 1..oneDay -> {
            val amountHours = amountSeconds / oneHour
            val convertHours = convertingHoursToText(amountHours)
            "$amountHours $convertHours назад"
        }
        in oneDay + 1..oneDay * 2 -> "сегодня"
        in oneDay * 2 + 1..oneDay * 3 -> "вчера"
        else -> "давно"
    }
}

fun convertingMinutesToText(amountMinutes: Int): String {
    val remainsMinutesTen: Int = amountMinutes % 10
    val remainsMinutesHundred: Int = amountMinutes % 100

    return when {
        (remainsMinutesTen == 1 && remainsMinutesHundred != 11) -> "минуту"
        (remainsMinutesTen in 2..4 && remainsMinutesHundred !in 11..14) -> "минуты"
        else -> "минут"
    }
}

fun convertingHoursToText(amountHours: Int): String {
    val remainsHoursTen: Int = amountHours % 10
    val remainsHoursHundred: Int = amountHours % 100

    return when {
        (remainsHoursTen == 1 && remainsHoursHundred != 11) -> "час"
        (remainsHoursTen in 2..4 && remainsHoursHundred !in 11..14) -> "часа"
        else -> "часов"
    }
}


