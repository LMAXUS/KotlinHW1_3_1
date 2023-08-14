fun minuts(secondAgo: Int): String{
    val minutAgo: Int = (secondAgo/60).toInt()
    return if(minutAgo != 11 && minutAgo%10 == 1) "$minutAgo минуту"
        else if(minutAgo !in 12..14 && minutAgo%10 in 2..4) "$minutAgo минуты"
        else "$minutAgo минут"
}
fun hours(secondAgo: Int): String{
    val hoursAgo: Int = (secondAgo/3600).toInt()
    return if(hoursAgo != 11 && hoursAgo%10 == 1) "$hoursAgo час"
        else if(hoursAgo !in 12..14 && hoursAgo%10 in 2..4) "$hoursAgo часа"
        else "$hoursAgo часов"
}
fun agoToText(user: String, secondAgo: Int): String{
    return when(secondAgo){
        in 1..60 -> "$user был(а) только что"
        in 61..60*60 -> "$user был(а) " + minuts(secondAgo) + " назад"
        in 60*60+1..24*60*60 -> "$user был(а) " + hours(secondAgo) + " назад"
        in 24*60*60+1..24*2*60*60 -> "$user был(а) вчера"
        in 24*2*60*60+1..24*3*60*60 -> "$user был(а) позавчера"
        else -> "$user был(а) давно"
    }
}
fun main() {
    println(agoToText("Коля", 1))
    for (i in 1..59) {
        println(agoToText("Коля", 61 * i))
    }
    for (i in 1..24) {
        println(agoToText("Коля", 3601 * i))
    }
    println(agoToText("Коля", 3601 * 48))
    println(agoToText("Коля", 3601 * 72))
}