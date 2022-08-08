

public class Task2 {
    public static final String ANSI_RESET = "\u001B[0m";     // палітра для розподілу потоків
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void main(String[] args) {

        First first = new First();      // створюємо ексемпляр об'єкту для потоку first
        first.start();   // стартуємо потік

        Second second = new Second();   // створюємо ексемпляр об'єкту для потоку second
        second.start();   // стартуємо потік

        Main main = new Main();     // створюємо ексемпляр об'єкту для потоку main
        main.start();   // стартуємо потік
    }

    static class First extends Thread {      // створюємо клас для потоку і наслідуємо бібліотеку Потоків
        public void run() {   // створюємо метод RUN
            for (int i = 0; i < 10; i++) {   // формуємо ітерацію через цикл
                try {
                    long longStart = System.nanoTime();
                    Thread.sleep(3000);    // вказуємо час з яким потік буде призупинятись в своїй роботі
                    System.out.println(ANSI_BLUE + "Перший потік із інтервалом в 3 секунди " + ANSI_RESET);
                    long longFinish = System.nanoTime();
                    System.out.println(ANSI_BLUE + (longFinish - longStart) + " ms." + ANSI_RESET);  // виводимо час з яким відновлюється потік
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Потік First завершено");   // виводимо інформацію про завершення потоку
            System.out.println();
        }
    }

    static class Second extends Thread {   // створюємо клас для потоку і наслідуємо бібліотеку Потоків
        public void run() {     // створюємо метод RUN
            for (int i = 0; i < 10; i++) {   // формуємо ітерацію через цикл
                try {
                    long longStart = System.nanoTime();
                    Thread.sleep(1000);     // вказуємо час з яким потік буде призупинятись в своїй роботі
                    System.out.println(ANSI_YELLOW + "Друний потік із інтервалом в 1 секунди " + ANSI_RESET);
                    long longFinish = System.nanoTime();
                    System.out.println(ANSI_YELLOW + (longFinish - longStart) + " ms." + ANSI_RESET);    // виводимо час з яким відновлюється потік
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Потік Second завершено");   // виводимо інформацію про завершення потоку
            System.out.println();
        }
    }

    static class Main extends Thread {    // створюємо клас для потоку і наслідуємо бібліотеку Потоків
        public void run() {     // створюємо метод RUN
            for (int i = 0; i < 100; i++) {    // формуємо ітерацію через цикл
                try {
                    long longStart = System.nanoTime();                   // час затримки потоку не вказуємо
                    System.out.println(ANSI_PURPLE + "Потік MAIN без інтервалу" + ANSI_RESET);
                    long longFinish = System.nanoTime();
                    System.out.println(ANSI_PURPLE + (longFinish - longStart) + " ms." + ANSI_RESET);  // виводимо час з яким відновлюється потік
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Потік Main завершено");    // виводимо інформацію про завершення потоку
            System.out.println();
        }
    }
}
