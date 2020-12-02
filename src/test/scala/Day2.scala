package org.athmer.aoc2020.day2

import org.junit.Test
import org.junit.Assert._

class Day2 {

  @Test def parse() = {
    assertEquals(InputLine.parse("1-3 a: abcde"), InputLine(1, 3, 'a', "abcde"))
    assertEquals(InputLine.parse("1-3 b: cdefg"), InputLine(1, 3, 'b', "cdefg"))
    assertEquals(InputLine.parse("2-9 c: ccccccccc"), InputLine(2, 9, 'c', "ccccccccc"))
  }
  
  @Test def isValidMinMax() = {
    assert(InputLine(1, 3, 'a', "abcde").isValidMinMax())
    assert(!InputLine(1, 3, 'b', "cdefg").isValidMinMax())
    assert(InputLine(2, 9, 'c', "ccccccccc").isValidMinMax())
  }
  
  @Test def isValidPositions() = {
    assert(InputLine(1, 3, 'a', "abcde").isValidPositions())
    assert(!InputLine(1, 3, 'b', "cdefg").isValidPositions())
    assert(!InputLine(2, 9, 'c', "ccccccccc").isValidPositions())
  }
}
