package net.dericbourg.gtfs.core

import org.scalatest.{Matchers, WordSpec}

class NonNegIntTest extends WordSpec with Matchers {
  "NonNegInt.apply" should {
    "throw IllegalArgumentException" when {
      "provided a negative number" in {
        Seq(-1, -10, -542).foreach { i: Int =>
          val exception = intercept[IllegalArgumentException] {
            NonNegInt(i)
          }
          exception.getMessage should be("requirement failed: NonNegInt forbids negative integer values")
        }
      }
    }
    "accept positive integers" in {
      Seq(0, 1, 2, 10, 1001).foreach { i: Int =>
        NonNegInt(i)
      }
    }
  }
  "Scala's Int" should {
    "be implicitly converted to NonNegInt" in {
      def whatever(nni: NonNegInt) = nni

      Seq(0, 1, 2, 10, 1001).foreach { i: Int =>
        whatever(i)
      }
    }
    "be implicitly converted from NonNegInt" in {
      def whatever(i: Int) = i

      Seq(0, 1, 2, 10, 1001).map(NonNegInt.apply).foreach { nni: NonNegInt =>
        whatever(nni)
      }
    }
    "be explicitly converted from NonNegInt" in {
      def whatever(i: Int) = i

      Seq(0, 1, 2, 10, 1001).map(NonNegInt.apply).foreach { nni: NonNegInt =>
        whatever(nni.toInt)
      }
    }
  }
}
