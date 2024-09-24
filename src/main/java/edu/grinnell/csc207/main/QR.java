package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.IOUtils;
import edu.grinnell.csc207.util.Quadratic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Interactively compute quadratic roots.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class QR {
  /**
   * Do all the work.
   *
   * @param args
   *   Command-line arguments (ignored).
   *
   * @throws Exception
   *   If something goes wrong with the I/O or elsewhere.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

    int a = IOUtils.readInt(pen, eyes, "Hi! I'm here to help you understand quadratic functions.\n\n" +
              "Please enter a (the coefficient of the squared term): ");
    int b = IOUtils.readInt(pen, eyes, "Please enter b (the coefficient of the linear term) : ");
    int c = IOUtils.readInt(pen, eyes, "Please enter c (the constant)                       : ");

    Quadratic quad = new Quadratic(a, b, c);
    double smallerRoot = quad.smallerRoot();

    pen.printf("The smaller root of %dx^2 + %dx + %d is %f.\n\n", a, b, c, smallerRoot);

    pen.printf("Experimentally, %d*%f^2 + %d*%f + %d = %f.\n", a, smallerRoot, b, smallerRoot, c, quad.evaluate(smallerRoot));

    eyes.close();
    pen.close();
  } // main(String[])

} // QR
