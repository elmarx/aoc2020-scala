package org.athmer.aoc2020.day1
import scala.io.Source

/**
 * find first tuple that sum up to 2020
 * @param input
 * @return
 */
def find2020Tuple(input: List[Int]): Option[(Int, Int)] = {
  // combination returns an iterator, so it's already lazy
  input.combinations(2).find { _.sum == 2020 }.collect {
    // "collect" the result into a tuple
    case a :: b :: Nil => (a, b)
  }
}

/**
 * find (first) triple that sums up to 2020… almost the same as find2020Tuple
 */
def find2020Triple(input: List[Int]): Option[(Int, Int, Int)] = {
  input.combinations(3).find { _.sum == 2020 }.collect {
    case a :: b :: c :: Nil => (a, b, c)
  }
}

@main def day1() = {
  val input = Source.fromResource("day1.txt").getLines.map(_.toInt).toList

  val (a1, b1) = find2020Tuple(input).get;
  val answer1 = a1 * b1

  val (a2, b2, c2) = find2020Triple(input).get;
  val answer2 = a2 * b2 * c2
  
  
  println(s"Answer Part 1: ${answer1}. (${a1} * ${b1} = ${answer1})")
  println(s"Answer Part 2: ${answer2}. (${a2} * ${b2} * ${c2} = ${answer2})")
}