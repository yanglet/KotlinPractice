package com.example.myapplication

/**
 * Expression vs Statement
 * Expression -> 어떠한 연산을 통해 값을 반환
 * Statment -> 단순 명령어 느낌
 */

fun main(){
    nullCheck()
}

fun helloWorld(){
    println("helloWorld")
}

/**
 * var -> 재할당가능
 * val -> 재할당 불가능
 */
fun hi(){
    val a : Int = 10
    var b : Int = 9

    var name : String = "yanglet"
    var lastName = "yang"
    println("My name is ${name + lastName}")
}

fun manNum(a : Int, b : Int) : Int{
    if(a > b){
        return a
    }else return b
}
fun manNum2(a : Int, b : Int) : Int = if(a>b) a else b

fun checkNum(score : Int){
    when(score) { // switch문
        0 -> println("대박0")
        1 -> println("대박1")
        2,3 -> println("대박2or3")
    }
    var b = when(score){ //return으로 쓸경우 else 필수(당연한것)
        1 -> 1
        2 -> 2
        else -> 3
    }
    when(score){
        in 90..100 -> println("와우")
        in 10..80 -> println("zzz")
    }
}
/**
 * Array and List
 *
 * Array -> Mutable
 *
 * List 1. List (읽기전용)
 *      2. MutableList (읽기쓰기가능, 변경가능)
 */
fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3.4f)
    val list2 = listOf(1,"d",3.4f)

    array[0] = 3

    val arrayList = arrayListOf<Int>()
    arrayList.add(12)
    arrayList.add(23)

}

fun forAndWhile(){
    val students = arrayListOf("joyce", "james", "yanglet", "good")

    for (name in students){
        println("${name}")
    }
    for ((index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }

    var sum1 = 0
    var sum2 = 0
    var sum3 = 0
    var sum4 = 0

    for (i in 1..10){
        sum1 += i
    }
    for (i in 1..10 step 2){ //1 3 5 7 9
        sum2 += i
    }
    for (i in 10 downTo 1){ //10..1
        sum3 += i
    }
    for (i in 1 until 100){ //1~99
        sum4 += i
    }
    println("${sum1}")
    println("${sum2}")
    println("${sum3}")
    println("${sum4}")
}

/**
 * Nullable / NonNull
 * 타입 + ? 으로 String?처럼 Nullable타입으로 선언가능
 */
fun nullCheck(){
    var name = "joyce"
    var nullName : String? = null;
    var nameInUppercase = name.toUpperCase()
    //?. -> null이면 실행 아니면 실행x 타임리프랑 비슷한게 많은것같음
    var nullNameInUpperCase = nullName?.toUpperCase()

    // ?: -> default 값을 주고 싶을때 (엘비스 연산자)
    val lastName : String? = null;
    val fullName = name + " " + (lastName?: "No lastName")
    println("fullName = ${fullName}")

}

// !! -> null이 아님을 보증해준다라는 의미 -> 쓰지않는것이 좋은듯함 확실하지않으면
fun ignoreNulls(str : String?){
    val mNotNull : String = str!! //!!으로 null이 아님을 보증했기때문에 mNotNull?. 으로 쓸필요없음
    val upper = mNotNull.toUpperCase()

    val email : String? = "joycehong@nana.vom"
    email?.let {
        println("email = ${email}")
    }
}