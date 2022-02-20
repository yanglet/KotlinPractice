package com.example.myapplication.example2

/**
 * 1. Lamda
 * 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
 *  1) 메소드의 파리미터로 넘겨줄 수 있다. fun maxBy(a : Int)
 *  2) return 값으로 사용할 수 있다.
 *
 *  람다의 기본 정의
 *  val||var lamdaName : Type = {argumentList -> codeBody}
 *
 *  내가 이해한것
 *  val||var lamdaName : Type -> 람다식의 return Type = { 위와동일 }
 *  or
 *  val||var lamdaName = {변수명 : Type, 변수명 : Type, ... -> codeBody} //여기서 코드바디의 리턴타입이 유추가 되어 안쓰는듯함 써야될 경우도있을듯??
 */

val sqaure : (Int) -> (Int) = {number -> number*number}

val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age}"
}

/**
 * 확장함수
 * 내가 이해한것
 * ㄴ 밑의 예제로 보면 String 이라는 클래스의 함수로 추가하는 듯함 (사용자 정의 라이브러리 함수를 만드는 느낌)
 * val 변수 : String = "Yanglet"
 * 일때
 * 변수.확장함수  이런식으로 가능
 */

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String{
    //파라미터가 하나 일 때 it으로 받아올수있음
    val introduceMySelf : String.(Int) -> String = {"I am ${this} and ${it} years old"}
    return name.introduceMySelf(age)
}

/**
 * 람다의 반환 (Return)
 */
val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "error"
    }
}

/**
 * 람다를 표현하는 여러 방법
 */

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.234)
}

/**
 * button.setOnClickListener(object : View.OnClickListener {
 *      override fun onClick(p0 : View?) {
 *          //to do..
 *      }
 * })
 */
//1. Kotlin interface가 아닌 Java interace이어야 함
//2. 이 인터페이스는 딱 하나의 메소드만 가져야 함
//위와 아래가 동일
/**
 * button.setOnClickListener{
 *      //to do ..
 * }
 */

fun main(){
    println(sqaure(12))
    println(nameAge("yanglet", 25))
    val a = "yanglet said"
    println(a.pizzaIsGreat())
    println(extendString("yanglet", 25))
    println(calculateGrade(94))
    val lamda = {number : Double ->
        number == 4.3213
    }
    println(invokeLamda(lamda))
    println(invokeLamda({it > 3.22}))
    //마지막 파라미터가 람다일때 {}이렇게
    println(invokeLamda{it > 3.22})
}