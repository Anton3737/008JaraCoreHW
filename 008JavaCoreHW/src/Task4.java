public class Task4 {

    public static final String ANSI_RESET = "\u001B[0m";     // палітра для розподілу потоків
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    static class YallowThread extends Thread {
        @Override
        synchronized public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(ANSI_YELLOW + "Потік Жовтого кольору " + i + ANSI_RESET);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Потік Yallow завершено");   // виводимо інформацію про завершення потоку
        }
    }
    static class BlueThread extends Thread {
        @Override
        synchronized public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(ANSI_BLUE + "Потік Жовтого кольору " + i + ANSI_RESET);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Потік Blue завершено");   // виводимо інформацію про завершення потоку
        }

        public static void main(String[] args) {
            YallowThread yallowThread = new YallowThread();   // Створюємо потік через наслідування з бібліотеки
            yallowThread.start();     // Запускаємо потік

            BlueThread blueThread = new BlueThread();
            blueThread.start();
        }
    }
}
