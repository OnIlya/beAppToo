package ru.netology


fun main() {
    val amountSeconds = 1400
    val oneMinute = 60
    val oneHour = oneMinute * 60
    val oneDay = oneHour * 24
    val amountMinutes = amountSeconds / oneMinute
    val amountHours = amountMinutes / oneMinute
    val result = agoToText(amountSeconds, amountMinutes, amountHours, oneMinute, oneHour, oneDay)
    println("Пользователь был $result")
}

fun agoToText(amountSeconds: Int, amountMinutes: Int, amountHours: Int,
              oneMinute: Int, oneHour: Int, oneDay: Int): String {
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

fun convertingMinutesToText(amountMinutes: Int, remainsTen: Int = amountMinutes % 10,
                            remainsHundred: Int = amountMinutes % 100): String {

    val convertingMinutesToText = when {
        (remainsTen == 1 && remainsHundred != 11) -> "минуту"
        (remainsTen in 2..4) -> "минуты"
        (remainsTen in 5..9 || remainsTen == 0 || remainsHundred in 11..20) -> "минут"
        else -> "ошибка"
        }

    return convertingMinutesToText
}

fun convertingHoursToText(amountHours: Int, remainsTen: Int = amountHours % 10,
                          remainsHundred: Int = amountHours % 100): String {

    val convertingHoursToText = when {
        (remainsTen == 1 && remainsHundred != 11) -> "час"
        (remainsTen in 2..4) -> "часа"
        (remainsTen in 5..9 || remainsTen == 0 || remainsHundred in 11..20) -> "часов"
        else -> "ошибка"
        }

    return convertingHoursToText
}

// Доработка: Сообразил с остатком от деления

