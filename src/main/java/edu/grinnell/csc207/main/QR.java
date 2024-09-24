package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.DivideByZeroException;
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
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

    int a = IOUtils.readInt(pen, eyes, "Hi! I'm here to help you understand quadratic functions.\n\n" +
              "Please enter a (the coefficient of the squared term): ");
    int b = IOUtils.readInt(pen, eyes, "Please enter b (the coefficient of the linear term) : ");
    int c = IOUtils.readInt(pen, eyes, "Please enter c (the constant)                       : ");

    Quadratic quad = new Quadratic(a, b, c);
    double smallerRoot;
    try {
      smallerRoot = quad.smallerRoot();
    } catch (DivideByZeroException dbze) {
      pen.println("Cannot compute a result because the coefficient of the quadratic term is 0.");
      return;
    } catch (Exception e) {
      pen.printf("Sorry, I could not compute a root for %s.\n",
        quad.toString());
      return;
    } // try-catch

    pen.printf("The smaller root of %s is %f.\n\n", quad.toString(), smallerRoot);

    pen.printf("Experimentally, %s = %f.\n", quad.toString(smallerRoot), quad.evaluate(smallerRoot));

    try {
      eyes.close();
      pen.close();
    } catch (Exception e) {

    } // try-catch
  } // main(String[])

} // QR
