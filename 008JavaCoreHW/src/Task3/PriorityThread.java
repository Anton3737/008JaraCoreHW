package Task3;

public class PriorityThread implements Runnable {

    public static final String ANSI_RESET = "\u001B[0m";     // палітра для розподілу потоків
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    @Override
    public void run() {                     // пероприділили метод RUN
        for (int i = 0; i < 10; i++) {      // з циклом та ітерацією
            System.out.println(Thread.currentThread().getName() + " " + i);   // у SOUT підставивмо імя обєкту з мейну та і казимо номер черації добавивши i
        }
    }

    public static void main(String[] args) {

        PriorityThread MinPior = new PriorityThread();                   // створили 3 обєкти
        PriorityThread NormPrior = new PriorityThread();
        PriorityThread MaxPrior = new PriorityThread();

        Thread threadMin = new Thread(MinPior, ANSI_BLUE + "Minimal Priority" + ANSI_RESET);
        Thread threadNor = new Thread(NormPrior, ANSI_YELLOW + "Normal Priority" + ANSI_RESET);      // створили 3 потоки з параметром обєка та ім'ям , а також виділимо їх окремими кольорами
        Thread threadMax = new Thread(MaxPrior, ANSI_PURPLE + "Maximum Priority" + ANSI_RESET);

        threadMin.setPriority(Thread.MIN_PRIORITY);   // виставимо пріоритет потоку
        threadMin.start();                            // запустимо потік 

        threadNor.setPriority(Thread.NORM_PRIORITY);
        threadNor.start();

        threadMax.setPriority(Thread.MAX_PRIORITY);
        threadMax.start();
    }
}





