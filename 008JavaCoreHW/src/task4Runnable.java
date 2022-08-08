public class task4Runnable {
    public static final String ANSI_RESET = "\u001B[0m";     // палітра для розподілу потоків
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static class SinchronizeClass implements Runnable {

        @Override
        public void run() {
            synchronized (this) {   // СИНХРОНІЗУЄМО ЧЕРЕЗ synchronized БЛОК
                for (int i = 0; i < 10; i++) {      // з циклом та ітерацією
                    System.out.println(Thread.currentThread().getName() + " " + i);   // у SOUT підставивмо імя обєкту з мейну та і казимо номер черації добавивши i
                }
            }
        }
    }

    public static void main(String[] args) {

        SinchronizeClass yallowThread = new SinchronizeClass();  // Створюємо новий обєкт
        SinchronizeClass blueThreat = new SinchronizeClass();

        Thread threadYallow = new Thread(yallowThread, ANSI_YELLOW + " Жовтий потічок" + ANSI_RESET);    // Створюємо потік
        Thread threadBlue = new Thread(blueThreat, ANSI_BLUE + " Синій потічок" + ANSI_RESET);

        threadYallow.start();    // Запускаємо потік
        threadBlue.start();
    }
}
