package Task3;


public class GroupJournal {
    int numberOfStudents;
    final int[][] studentMarks;

    public GroupJournal(int numberOfStudents){
        this.numberOfStudents = numberOfStudents;
        studentMarks = new int[numberOfStudents][4];
    }

    public void setPoint(int point, int studNumb, int weekNumb) {
        synchronized (studentMarks[studNumb]){
            studentMarks[studNumb][weekNumb] = point;
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void showJournal() {
        for(int i=0; i<numberOfStudents; i++){
            for(int j=0; j<4; j++){
                System.out.print(studentMarks[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("============================");
    }
}

