package Task3;

public class Assistant implements Runnable {
    GroupJournal gJournal;

    public Assistant(GroupJournal gJournal){
        this.gJournal = gJournal;
    }

    public void setPoint(int point, int studNumb, int weekNumb){
        gJournal.setPoint(point, studNumb, weekNumb);
    }

    public void run() {
        for(int i=0; i<20; i++){
            int point = (int) (100 * Math.random());
            int weekNumb = (int) (4*Math.random());
            int studNumb = (int) (gJournal.getNumberOfStudents()* Math.random());
            setPoint(point, studNumb, weekNumb);
        }
    }
}
