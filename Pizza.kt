package com.example.pizzalib

import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        // do something
        val path = System.getProperty("user.dir") + "\\a_example.in"

        //readFileLineByLine(path)
        print("\n")
        //assignPizzaXtics(path)
        print("\n")

        val x = PizzaXtics(path)
        //x.visulizeMyPizza()
        x.visulizeMyPizza(path)

        //inToArray(path)
    }
}

fun readFileLineByLine(fileName: String) = File(fileName).forEachLine { println(it) }

fun assignPizzaXtics(fileName: String) {
    val lineList = File(fileName).readLines()
    val fLine = lineList[0].replace(" ", "")
    PizzaXtics.R = fLine.substring(0, 1).toInt()
    PizzaXtics.C = fLine.substring(1, 2).toInt()
    PizzaXtics.L = fLine.substring(2, 3).toInt()
    PizzaXtics.H = fLine.substring(3, 4).toInt()

    print("${PizzaXtics.R} rows, ${PizzaXtics.C} columns, min ${PizzaXtics.L} of each ingredient per slice, max ${PizzaXtics.H} cells per slice\n")
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String> = File(fileName).useLines {
    it.toList()
}

class PizzaXtics {
    companion object {
        var R: Int = 0
        var C: Int = 0
        var L: Int = 0
        var H: Int = 0
    }

    constructor(fileName: String) {
        assignPizzaXtics(fileName)
    }

    fun visulizeMyPizza() = visulizePizza(R, C)
    fun visulizeMyPizza(fileName: String){
        val lineList = File(fileName).readLines()
        val fLine = lineList[0].replace(" ", "")
        val rLine = lineList.subList(1,lineList.size)

        var pizza = arrayOf<Array<String>>()
        for (i in 0 until R) {
            var array = arrayOf<String>()
            for (j in 0 until C) {
                array += "X"
            }
            pizza += array
        }

        for (l in 0 until rLine.size){
            val row = rLine[l]

            for (j in 0 until C) {
                //print("row $l column $j \n")
                //print("row $row \n")
                pizza[l][j]  = row[j].toString()
            }
        }

        for (array in pizza) {
            for (value in array) {
                print("$value ")
            }
            println()
        }
    }
}

fun visulizePizza(R: Int, C: Int) = {
    var pizza = arrayOf<Array<String>>()

    for (i in 0..R) {
        var array = arrayOf<String>()
        for (j in 0 until C) {
            array += "X"
        }
        pizza += array
    }

    for (array in pizza) {
        for (value in array) {
            print("$value ")
        }
        println()
    }
}
