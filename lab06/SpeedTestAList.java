public class SpeedTestAList {
    public static void main(String[] args) {
        int N = 100000;
        MyAList L = new MyAList();
        int i = 0;
        while (i < N) {
            L.addLast(i);
            i = i + 1;
        }
    }
}
