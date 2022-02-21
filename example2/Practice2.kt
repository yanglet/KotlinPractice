package com.example.myapplication.example2

/**
 * Data Class
 * java의 dto 느낌인듯함
 * lombok의 @Data를 추가한듯한 느낌
 * toString(), hashCode(), equals(), copy() 등이 자동으로 만들어짐
 */

data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int )
class TicketNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int )

fun main(){
    val ticketA = Ticket("KoreanAir", "yanglet", "2022-02-21", 14)
    val ticketB = TicketNormal("KoreanAir", "yanglet", "2022-02-21", 14)

    println(ticketA)
    println(ticketB)
}