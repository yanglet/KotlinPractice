package com.example.myapplication.example2

/**
 * Companion Object
 * Java의 Static 느낌
 * 이름정의, 상속 가능
 */

class Book private constructor(val id : Int,val name : String){

    companion object BookFactory : IdProvider{
        val myBook = "new book"

        fun create() = Book(0, myBook)

        override fun getId(): Int {
            return 777
        }
    }
}

interface IdProvider{
    fun getId() : Int
}

fun main(){
    val book = Book.create()
    val bookId = Book.BookFactory.getId()

    println("${book.id} ${book.name}")
}