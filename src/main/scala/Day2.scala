package org.athmer.aoc2020.day2

import scala.io.Source

case class InputLine(a: Int, b: Int, char: Char, password: String) {
  def isValidMinMax(acc: Int = 0, pw: String = password): Boolean = {
    val head = pw.headOption.map(_.toChar)
    
    head match {
      case None => a <= acc
      case Some(c) if c != char => isValidMinMax(acc, pw.tail)
      case Some(_) => {
        val count = acc + 1
        if(b < count) {
          false
        } else {
          isValidMinMax(count, pw.tail)
        }
      }
    }
  }
  
  def isValidPositions(): Boolean = {
    val charA = password.charAt(a - 1)
    val charB = password.charAt(b - 1)
    
    (charA == char) ^ (charB == char)
  }
}


object InputLine {
  val RE = """(\d+)-(\d+) (\w): (\w+)""".r
  def parse(input: String) : InputLine = {
    input match {
      case RE(a,b,char,password) => InputLine(a.toInt,b.toInt,char.charAt(0),password)
    }
  }
}

@main def day2() = {
  val input = Source.fromResource("day2.txt").getLines.map(InputLine.parse).toList
  
  val answer1 = input.count(_.isValidMinMax())
  val answer2 = input.count(_.isValidPositions())
  
  println(s"Answer Part 1: ${answer1}")
  println(s"Answer Part 2: ${answer2}")
}

