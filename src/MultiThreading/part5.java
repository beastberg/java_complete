package MultiThreading;

public class part5 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        part5 t1 = new part5();
        part5 t2 = new part5();

        t1.start();
        t2.start();
    }
}
