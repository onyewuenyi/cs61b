public class SpeedTestDLList {
    public static void main(String[] args) {
        DLList<Integer> L = new DLList<>();
        int i = 0;
        while (i < 100000) {
            L.addLast(i);
            i = i + 1;
        }
    }
}

