public class Test2 {

    public static final String ANSI_RESET = "\u001B[0m";     // палітра для розподілу потоків
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static class RunMethod implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);   // у SOUT підставивмо імя обєкту з мейну та і казимо номер черації добавивши i
            }
        }

        public static void main(String[] args) {

            RunMethod subZero = new RunMethod();
            RunMethod scorpion = new RunMethod();

            Thread subZeroThread = new Thread(subZero, "SubZero" );
            Thread scorpionThread = new Thread(scorpion,"Scorpion");

            scorpionThread.start();
            subZeroThread.start();

        }
    }
}
