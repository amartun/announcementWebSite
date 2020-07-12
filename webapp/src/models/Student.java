package models;

public class Student {
    protected int id;
    protected String student_name;
    protected String student_class;
    protected String student_birthDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public void setStudent_birthDate(String student_birthDate) {
        this.student_birthDate = student_birthDate;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_class() {
        return student_class;
    }

    public String getStudent_birthDate() {
        return student_birthDate;
    }

    public String getStudentName() {
        return student_name;
    }

    public String getStudentClass() {
        return student_class;
    }

    public String getStudentBirthDate() {
        return student_birthDate;
    }

    public int getId() {
        return id;
    }
    public Student(int id, String name, String subject, String age, String higherEducat, int exp){

    }
    public Student(int id){
        this.id = id;
    }
    public Student(String student_name, String student_class, String student_birthDate) {
        this.student_name = student_name;
        this.student_class = student_class;
        this.student_birthDate = student_birthDate;
    }

    public Student(int id, String student_name, String student_class, String student_birthDate) {
        this.id = id;
        this.student_name = student_name;
        this.student_class = student_class;
        this.student_birthDate = student_birthDate;
    }

    public String doHomeWork() {
        return "The student is doing home work...";
    }

    @Override
    public String toString() {
        return "models.Student " +
                ", student_name = " + student_name +
                ", student_class = " + student_class +
                ", student_birthDate = " + student_birthDate;
    }
}
