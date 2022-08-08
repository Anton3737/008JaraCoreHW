public class test {


    public static void main(String[] args) {

        Thread potok = new Thread();
        potok.setPriority(10);
        potok.start();

        run();

    }
    public static void run() {
        for (int i = 0; i < 10; i++) {

            try {
                long longStart = System.nanoTime();
                Thread.sleep(1000);
                System.out.println("Такт вальсу " + i);
                long longFinish = System.nanoTime();
                System.out.println(longFinish-longStart + " Поворот");
                System.out.println();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}


