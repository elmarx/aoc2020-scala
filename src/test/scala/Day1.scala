package org.athmer.aoc2020.day1

import org.junit.Test
import org.junit.Assert._


class Day1 {
  val SAMPLE_INPUT = List(1721, 979, 366, 299, 675, 1456)
  
  @Test def tuple(): Unit = {
    val actual = find2020Tuple(SAMPLE_INPUT)
    
    assertEquals(actual, Some(1721, 299))
  }
  
  @Test def triple(): Unit = {
    val actual = find2020Triple(SAMPLE_INPUT)

    assertEquals(actual, Some(979, 366, 675))
  }
}