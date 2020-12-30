package Utilities;

import java.util.Locale;
import java.util.Scanner;

public class IOManager {

  public static Scanner input = new Scanner(System.in);
  protected static Locale locale = new Locale("en", "UK");

  // @formatter:off
  private static String hline = "–––––––––––––––––––––––––––––––––––––––";
  // @formatter:on

  /**
   * Get input integer value from the terminal.
   * 
   * @return Integer value. Invalid value is Integer.MIN_VALUE
   */
  public static int ReadInt() {
    int value = Integer.MIN_VALUE;

    try {
      String raw = input.nextLine();
      value = Integer.valueOf(raw);
    } catch (Exception e) {
      error(
          "\n\u001b[31;1mError parsing input. It might not be an integer.\n\u001b[33;1mReturning MIN_VALUE\u001b[0m\n\n");
      return Integer.MIN_VALUE;
    }

    return value;
  }

  /**
   * Get the text input from the terminal
   * 
   * @return Input text
   */
  public static String ReadLine() {
    return input.nextLine();
  }

  /**
   * Get the floating value from the terminal
   * 
   * @return Double value. Invalid value is Double.MIN_VALUE
   */
  public static double ReadDouble() {
    double value = 0;

    try {
      String raw = input.nextLine();
      value = Double.valueOf(raw);
    } catch (Exception e) {
      error(
          "\n\u001b[31;1mError parsing input. It might not be a double.\n\u001b[33;1mReturning MIN_VALUE\u001b[0m\n\n");

      return Double.MIN_VALUE;
    }

    return value;
  }

  public static void HLine() {
    System.out.println(hline);
  }

  public static void printf(String format, Object... args) {
    System.out.printf(locale, format, args);
  }

  public static void error(String format, Object... args) {
    System.err.printf(format, args);
  }

  public static void Clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

}