package fhj.swengb.assignments.functional.tortmann


/**
  * This is the first assignment for swengb 2015.
  *
  */
case class FunctionalAssignment(lowerBound: Int = 1,
                                upperBound: Int = 1000,
                                factor: Int = 2) {
  require(lowerBound < upperBound)

  /********************************************************************************************************************/
  /** implement a SEQUENCE of integers (Seq[Int]), which start with lowerBound:Int and end with upperBound:Int */

  val xs: Seq[Int] = lowerBound until upperBound+1

  /********************************************************************************************************************/
  /** provide the sum of all elements defined in xs
    * using the builtin function sum to sum up all elements of a list, sequence etc. from head to tail
    */

  val sumXs = xs.sum

  /********************************************************************************************************************/
  /** This sequence contains a list with the following elements:
    *
    * x(0)   = (upperBound) * factor
    * x(1)   = (upperBound - 1) * factor
    * x(2)   = (upperBound - 2) * factor
    *
    *
    *
    * x(998) = factor
    * x(999) = lowerBound
    *
    * new sequence ys starts with the upperBound and ends with the lowerBounds
    * - it is there for the same as sequence xs but in reverse order
    * 1) reversing xs
    * 2) multiply the elements of the new sequence xs reversed with factor -> map
    */

  val ys: Seq[Int] = xs.reverse.map(_*factor)

  /********************************************************************************************************************/
  /** this sequence contains pairs of xs and ys. the ys should be in reversed order */

  /** zip method
    * Returns a list formed from this list and another iterable collection by combining
    * corresponding elements in pairs. If one of the two collections is longer than the
    * other, its remaining elements are ignored.
    *
    * i used the zip method to build the pairs and like in val ys use the reverse function
    * to reverse the order of ys
    */

  val zs: Seq[(Int, Int)] = xs zip ys.reverse

  /********************************************************************************************************************/
  /** Function should divide the second operand with the first */

  def f(ab: (Int, Int)): Int = ab._2 / ab._1
  /********************************************************************************************************************/
  /** apply function f defined above to all elements of zs, return the sequence */

  val result: Seq[Int] = zs.map(f)

}