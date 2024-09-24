package edu.grinnell.csc207;

import edu.grinnell.csc207.util.Quadratic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests of the Quadratic class.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class TestQuadratic {
  /**
   * Quadratic expressions with only the a coefficient.
   */
  @Test
  public void testRootsOnlyA() {
    assertEquals(0, (new Quadratic(4, 0, 0)).smallerRoot(), 0.001,
        "The smaller root of 4x^2 is 0");
    assertEquals(0, (new Quadratic(4, 0, 0)).largerRoot(), 0.001,
        "The larger root of 4x^2 is 0");
  } // testRootsOnlyA()

  /**
   * Quadratic expressions with only the a and b coefficients.
   */
  @Test
  public void testRootsNoC() {
    assertEquals(0, (new Quadratic(1, -3, 0)).smallerRoot(), 0.001,
        "The smaller root of x^2 - 3x is 0");
  } // testRootsNoC()

  /**
   * Test full quadratic expressions.
   */
  @Test
  public void testRootsAllCoeff() {
    Quadratic q2and5 = new Quadratic(1, 3, -10);
    assertEquals(2.0, q2and5.largerRoot(), "(x-2)(x+5) larger root is 2");
    assertEquals(-5.0, q2and5.smallerRoot(), "(x-2)(x+5) smaller root is -5");

    Quadratic qFractional = new Quadratic(6, 1, -12);
    assertEquals(-3.0/2.0, qFractional.smallerRoot(), "qFractional smallerRoot is -3/2");
    assertEquals(4.0/3.0, qFractional.largerRoot(), "qFractional largerRoot is 4/3");
  }

} // class TestQuadratic
