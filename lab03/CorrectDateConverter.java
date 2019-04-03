import java.io.*;

public class CorrectDateConverter {
    /**
     * Given a day number in 2017, an integer between 1 and 365, as a
     * command-line argument, prints the date in month/day format.
     *
     *     java DateConverter 365
     *
     * should print 12/31
     *
     * 1. TDD: come up with a small but comprehenvisve set of test for the code - DONE
     * before we write the code
     * 2. Missing two assignemnt statements at start, end, or both of the loop - WIP
     * 3. Run test cases
     * 4. Introspection:
     * did all test cases pass; how woudl your test cases not
     * be comprehensive: all your test pass but here is still some type of
     * input that will not work the way you expect
     output:
     ~/D/c/c/c/lab03 ❯❯❯ java CorrectDateConverter 334
    11/30
    ~/D/c/c/c/lab03 ❯❯❯ java CorrectDateConverter 335
    12/1
    ~/D/c/c/c/lab03 ❯❯❯ java CorrectDateConverter 336
    12/2
     */
    public static void main(String[] args) {
        // get and test input from user
        int dayOfYear = 0;
        try {
            dayOfYear = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // test dayOfYear input range
        if (dayOfYear < 1 || dayOfYear > 365) {
          System.out.println("Invalid input " + dayOfYear + ": input must be natural numnber in the range 1-365");
          return;
        }

        int month, dateInMonth, daysInMonth;
        month = 1;
        daysInMonth = 31;
        while (dayOfYear > daysInMonth) {
            // TODO: Here is one place to put assignment statements.

            // computation on iteration i
            dayOfYear -= daysInMonth;

            // update iteration i state: month, daysInMonth
            month++;
            if (month == 2) {
                daysInMonth = 28;
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                daysInMonth = 30;
            }
            else {
                daysInMonth = 31;
            }
          // TODO: Here is another possible place to put assignment statements.

        }
        dateInMonth = dayOfYear;
        System.out.println(month + "/" + dateInMonth);
    }
}
