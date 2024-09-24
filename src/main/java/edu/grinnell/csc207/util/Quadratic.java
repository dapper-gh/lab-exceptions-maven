package edu.grinnell.csc207.util;

/**
 * Quadratic expressions (of the form ax^2 + bx + c).
 *
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 * @author YOUR NAME HERE
 */
public class Quadratic {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The coefficient of the x^2 component.
   */
  double a;

  /**
   * The coefficient of the x component.
   */
  double b;

  /**
   * The constant.
   */
  double c;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new quadratic.
   *
   * @param squared
   *   The coefficient of the squared term.
   * @param linear
   *   The coefficient of the linear term.
   * @param constant
   *   The constant.
   */
  public Quadratic(double squared, double linear, double constant) {
    this.a = squared;
    this.b = linear;
    this.c = constant;
  } // Quadratic(double, double, double)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Convert to a string.
   *
   * @return the function as a string
   */
  public String toString() {
    return String.format("%fx^2 + %fx + %f", a, b, c);
  } // toString()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Build a string that shows the expression with a particular value.
   *
   * @param val
   *   The value we incorporate in the expression.
   *
   * @return the expression as a string
   */
  public String toString(double val) {
    return String.format("%f*%f^2 + %f*%f + %f", a, val, b, val, c);
  } // toString(double)

  /**
   * Evaluate the quadratic on a value.
   *
   * @param x
   *   The value on which to evaluate the quadratic.
   *
   * @return the value
   */
  public double evaluate(double x) {
    return this.a * x * x + this.b * x + this.c;
  } // evaluate(double)

  /**
   * Find the smaller of the two roots.
   *
   * @return the smaller of the two roots (or the only root, if there
   *   is only one).
   */
  public double smallerRoot() throws Exception {
    if (a == 0) {
      throw new DivideByZeroException("Cannot divide by 0.");
    } // if (a == 0)

   

    double det = this.b * this.b - 4 * this.a * this.c;
    if (det < 0) {
      throw new Exception("Cannot compute imaginary quadratic roots.");
    } // if (det < 0)

    return (-this.b - Math.sqrt(det)) / (2 * this.a);

  } // smallerRoot

  /**
   * Find the larger of the two roots.
   *
   * @return the larger of the two roots (or the only root, if there
   *   is only one).
   */
  public double largerRoot() {
    double detSqrt = Math.sqrt(this.b * this.b - 4 * this.a * this.c);
    return (-this.b + detSqrt) / (2 * this.a);
  } // largerRoot
} // class Quadratic
