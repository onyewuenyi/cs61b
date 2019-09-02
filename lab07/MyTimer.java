public class MyTimer extends Timer {
    public MyTimer() {
        super();
    }

    public void wasteTime() {
        int count = 0;
        for (int i = 0; i < 1000000000; i++) {
            for (int j = 0; j < 1000000000; j++) {
                count += 1;
            }
        }
    }

    public static void main(String[] args) {
        MyTimer T = new MyTimer();

        T.start();
        T.wasteTime();
        System.out.println(T.stop());

        T.start();
        T.wasteTime();
        System.out.println(T.stop());


        T.start();
        T.wasteTime();
        System.out.println(T.stop());

        // return total elapsed time of the entire program: 3 calls to wasteTime
        System.out.println(T.elapsed());


    }

}
