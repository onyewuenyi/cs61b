// output: a-b c-d
public class Jigsaw {
    // build the output with the blocks of logic. Look at the output and then
    // structure the blocks to print the this output
    // x - cond var
    // System.out.print prints the arg w/o a \n char
    // if construct uses x to express the conditional expression
    public static void main(String[] args) {
        // (5)
        int x = 3;


        // (4)
        if (x > 2) {
            System.out.print("a");
        }
        // a

        // (6)
        x = x - 1;
        System.out.print("-");
        // a-
        // x = 2

        // (2)
        if (x == 2) {
            System.out.print("b c");
        }

        // a-b c
        // (6)
        x = x - 1;
        System.out.print("-");

        // a-b c-
        // x = 1

        // (1)
        if (x == 1) {
            System.out.print("d");
            x = x - 1;
        }
        // x = 0
      }
}
