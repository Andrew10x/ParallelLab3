package Task3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GroupJournal gJournal1 = new GroupJournal(5);
        GroupJournal gJournal2 = new GroupJournal(6);
        GroupJournal gJournal3 = new GroupJournal(7);

        Lecturer lecturer = new Lecturer(gJournal1, gJournal2, gJournal3);

        Assistant assistant1 = new Assistant(gJournal1);
        Assistant assistant2 = new Assistant(gJournal2);
        Assistant assistant3 = new Assistant(gJournal3);

        Thread lThread = new Thread(lecturer);
        Thread aThread1 = new Thread(assistant1);
        Thread aThread2 = new Thread(assistant2);
        Thread aThread3 = new Thread(assistant3);

        lThread.start();
        aThread1.start();
        aThread2.start();
        aThread3.start();

        lThread.join();
        aThread1.join();
        aThread2.join();
        aThread3.join();

        gJournal1.showJournal();
        gJournal2.showJournal();
        gJournal3.showJournal();
    }



}
