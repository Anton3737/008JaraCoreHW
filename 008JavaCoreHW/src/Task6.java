public class Task6 {

    public static final String ANSI_RESET = "\u001B[0m";     // палітра для розподілу потоків
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) {     // Для релізації Клінча або Deadlock-а ствроюємо 2 монітора які в потальшому будать перезахоплюватись

        Object SubZero = new Object();
                                                // Через клас Обджект створили 2 монитора
        Object Scorpion = new Object();


        Thread SubZeroThread = new Thread(() -> {         // створюємо потік через лямду вираз де і вказуємо алгоритм 2х обєктів
            synchronized (SubZero) {
                for (int i = 0; i < 5; i++) {       // створюємо ітератор
                    try {
                        System.out.println(ANSI_BLUE + "SubZero fight " + i + ANSI_RESET);         // прописуємо SOUT для наглядності
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }                       // Заблокуйте рядки 24-25 для припинення кліняа так як Потік SubZeroThread вже не буде посилатись на потік ScorpionThread з монітором synchronized (Scorpion)
                synchronized (Scorpion) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "Потік завершено SubZero finish hin");     // прописуємо SOUT в разі виконання потоку
        },
                "Thread 1 - SubZeroThread  synchronized (SubZero) + synchronized (Scorpion)");

        Thread ScorpionThread = new Thread(() -> {
            synchronized (Scorpion) {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(ANSI_YELLOW + "Scorpion fight " + i + ANSI_RESET);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                synchronized (SubZero) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " Потік завершено Scorpion finish him");
        },
                "Thread 2 - ScorpionThread  synchronized (Scorpion) + synchronized (SubZero)");

        ScorpionThread.start();    // запускаємо потоки
        SubZeroThread.start();

    }
}
    
