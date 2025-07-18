package MultiThreading;

class Pen{
    public synchronized void writePenPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to use paper " + paper);
        paper.finishWriting();
    }
    
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paper {
    public synchronized void writePaperPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper " + " and trying to use pen " + pen);
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

class Task1 implements Runnable{
    private Pen pen;
    private Paper paper;
    
    public Task1(Pen pen,Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    @Override
    public void run(){
        pen.writePenPaper(paper);
    }
}

class Task2 implements Runnable{
    private Pen pen;
    private Paper paper;
    
    public Task2(Pen pen,Paper paper){
        this.pen = pen;
        this.paper = paper;
    }
    
    @Override
    public void run(){
        synchronized (pen){
            paper.writePaperPen(pen);
        }
    }

}
public class part12_deadlock {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread(new Task1(pen,paper),"Thread-1");
        Thread thread2 = new Thread(new Task2(pen,paper),"Thread-2");

        thread1.start();
        thread2.start();

    }
}
