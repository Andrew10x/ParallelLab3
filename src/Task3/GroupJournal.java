package Task3;


public class GroupJournal {
    int numberOfStudents;
    int weeks = 4;
    final Cell[][] studentMarks;

    public GroupJournal(int numberOfStudents){
        this.numberOfStudents = numberOfStudents;
        studentMarks = new Cell[numberOfStudents][weeks];
        for(int i=0; i<numberOfStudents; i++){
            for(int j=0; j<weeks; j++){
                studentMarks[i][j] = new Cell();
            }
        }
    }

    public void setPoint(int point, int studNumb, int weekNumb) {
        synchronized (studentMarks[studNumb][weekNumb]){
            studentMarks[studNumb][weekNumb].setMark(point);
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void showJournal() {
        for(int i=0; i<numberOfStudents; i++){
            for(int j=0; j<weeks; j++){
                System.out.print(studentMarks[i][j].getMark()+ " ");
            }
            System.out.println();
        }
        System.out.println("============================");
    }
}

