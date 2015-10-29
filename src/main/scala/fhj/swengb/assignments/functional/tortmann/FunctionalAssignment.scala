package fhj.swengb.assignments.functional.tortmann


/**
  * This is the first assignment for swengb 2015.
  *
  */
case class FunctionalAssignment(lowerBound: Int = 1,
                                upperBound: Int = 1000,
                                factor: Int = 2) {
  require(lowerBound < upperBound)

  /** implement a SEQUENCE of Int (Seq[Int]), which start with lowerBound:Int and end with upperBound:Int */

  val xs: Seq[Int] = lowerBound until upperBound+1

  /** provide the sum of all elements defined in xs */

  val sumXs = xs.sum

  /** This sequence contains a list with the following elements:
    *
    * x(0)   = (upperbound) * factor
    * x(1)   = (upperbound - 1) * factor
    * x(2)   = (upperbound - 2) * factor
    *
    *
    *
    * x(998) = factor
    * x(999) = lowerbound
    *
    */
  val ys: Seq[Int] = xs.reverse.map(_*factor)

  /** this sequence contains pairs of xs and ys. the ys should be in reversed order */

  val zs: Seq[(Int, Int)] = xs zip ys.reverse

  /** Function should divide the second operand with the first */

  def f(ab: (Int, Int)): Int = ab._2 / ab._1

  /** apply function f defined above to all elements of zs, return the sequence */

  val result: Seq[Int] = zs.map(f)

}