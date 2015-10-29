package fhj.swengb.assignments.functional.tortmann

import org.junit.Assert._
import org.junit.{Ignore, Test}

import scala.language.postfixOps

class FunctionalAssignmentTest {

  val lowerBound = 1
  val upperBound = 10000
  val factor = 3

  val assignment0 = FunctionalAssignment(lowerBound, upperBound, factor)

  /**
   * this test shows that your Assignment1 contains an attribute
   * (either val, var or def) which returns a collection containing
   * 100 elements.
   */
  @Test def provideCollectionWith1000Elements(): Unit = {
    assertEquals(upperBound - lowerBound + 1, assignment0.xs.size)
  }

  /**
   * Test shows that elements are smaller or equal than 1000
   */
  @Test def smaller1000(): Unit = {
    assertTrue(assignment0.xs.forall(_ <= upperBound))
  }

  /**
   * Test shows that all elements are greater than 0.
   */
  @Test def greaterEqual0(): Unit = {
    assertTrue(assignment0.xs.forall(_ >= lowerBound))
  }

  /**
   * Test shows that ys is implemented correctly
   */
  @Test def showCorrectMultiplication(): Unit = {
    assertEquals(0, (assignment0.xs zip assignment0.ys.reverse.map(_ / factor)) map { case (a, b) => a - b } sum)
  }

  /**
   * Test shows that the sum of the given seq is correct
   */
  @Test def showCorrectSumImplementation(): Unit = {
    assertEquals((lowerBound + upperBound) * upperBound / 2, assignment0.sumXs)
  }

  @Test def testIfDefinitionOfZsIsCorrect(): Unit = {
    assertTrue(assignment0.zs.forall { case ((a, b)) => a * factor == b })
  }

  @Test def testResult(): Unit = {
    assertTrue(assignment0.result.forall(_ == factor))
  }


}
