package Task3;

public class Lecturer implements Runnable {
    GroupJournal gJournal1;
    GroupJournal gJournal2;
    GroupJournal gJournal3;

    public Lecturer(GroupJournal gj1, GroupJournal gj2, GroupJournal gj3) {
        gJournal1 = gj1;
        gJournal2 = gj2;
        gJournal3 = gj3;
    }

    public void setPoint(int point, int studNumb, int weekNumb, int journalNumb){
        if(journalNumb == 1)
            gJournal1.setPoint(point, studNumb, weekNumb);
        else if(journalNumb == 2)
            gJournal2.setPoint(point, studNumb, weekNumb);
        else if(journalNumb == 3)
            gJournal3.setPoint(point, studNumb, weekNumb);
    }


    public void run() {

        for(int i=0; i<40; i++) {
            int point = (int) (100 * Math.random());
            int weekNumb = (int) (4*Math.random());
            int journalNumb = (int) (3*Math.random());
            if(journalNumb == 1){
                int studNumb = (int) (gJournal1.getNumberOfStudents()* Math.random());
                setPoint(point, studNumb, weekNumb, journalNumb);
            }
            if(journalNumb == 2){
                int studNumb = (int) (gJournal2.getNumberOfStudents()* Math.random());
                setPoint(point, studNumb, weekNumb, journalNumb);
            }
            if(journalNumb == 3){
                int studNumb = (int) (gJournal3.getNumberOfStudents()* Math.random());
                setPoint(point, studNumb, weekNumb, journalNumb);
            }

        }
    }
}
