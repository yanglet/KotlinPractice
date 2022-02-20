package com.example.myapplication

/**
 * kotlin은 클래스명이랑 파일명이 일치하지않아도 오류가 나지않음
 * 한 파일에 여러개를 넣을수있음
 */
class Human{

    val name = "yanglet"

    fun eatingCake(){
        println("yummmyyy")
    }
}

/**
 * 생성자는 constructor()키워드를 이용해서 만듦 -> 생략가능
 * 필드선언을 파라미터에 넣어주어도 됨 -> 필드에 선언한것과 같음
 * default 값을 주면 파라미터가 없는 생성자도 같이 만들어줌
 */
open class HumanWithConstructor constructor(val name : String = "Anonymous"){
    //val name = name

    //부생성자 -> 주생성자의 위임을 받아야함 this(name) 필요
    //자바의 오버로딩
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age}years old")
    }

    init {
        println("내가 태어났땅")
    }

    open fun eatingCake(){
        println("yummmyyy")
    }
}

/**
 * open으로 해주어야 상속가능
 * 상속은 한 클래스만 가능
 * open으로 해주어야 오버라이드도 가능
 */
class Korean : HumanWithConstructor(){
    override fun eatingCake(){
        println("난 맛없어")
    }
}

fun main(){
    val human = Human()
    val human1 = HumanWithConstructor("yanglet")
    val human2 = HumanWithConstructor("yanglet", 23)
    val human3 = HumanWithConstructor()
    val korean = Korean()

    human.eatingCake()

    println("name is ${human.name}")
}