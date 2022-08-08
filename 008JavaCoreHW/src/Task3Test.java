public class Task3Test implements Runnable {

    public static void main(String[] args) {
        Task3Test MinPior = new Task3Test();
        Task3Test NormPrior = new Task3Test();
        Task3Test MaxPrior = new Task3Test();

        Thread threadMin = new Thread(MinPior, "Minimal Priority");
        Thread threadNor = new Thread(NormPrior, "Normal Priority");
        Thread threadMax = new Thread(MaxPrior, "Maximum Priority");

        threadMin.setPriority(Thread.MIN_PRIORITY);
        threadMin.start();

        threadNor.setPriority(Thread.NORM_PRIORITY);
        threadNor.start();

        threadMax.setPriority(Thread.MAX_PRIORITY);
        threadMax.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}



