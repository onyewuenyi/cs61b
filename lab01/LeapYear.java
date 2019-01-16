/**
 * Class that determines whether or not a year is a leap year.
 * @author Charles A. Onyewuenyi
 */


 /**
 * Return True if year is a LeapYear
 * @source CS 61BL Lab 1
 */
public class LeapYear {
    public static boolean isLeapYear(int year) {
      // spec:
      // A leap year is either:

      // divisible by 400 or
      boolean divisible400 = (year % 400) == 0;

      // divisible by 4
      boolean divisible4 = (year % 4) == 0;
      //  not divisible by 100
      boolean notDivisible100 = (year % 100) != 0;

      // divisible by 4 and not by 100.
      boolean divis4AndNotDivis100 = divisible4 && notDivisible100;

      return (divisible400 || divis4AndNotDivis100);
    }

    /** Calls isLeapYear to print correct statement. */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java LeapYear 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}
