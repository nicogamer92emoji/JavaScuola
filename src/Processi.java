public class Processi implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) 
            System.out.println("Thread " + i);
    }

    public static void main(String[] args) {
        Processi p = new Processi();

        Thread t = new Thread(p);
        t.start();
        for (int i = 0; i < 10; i++)
            System.out.println("Main " + i);
    }
}