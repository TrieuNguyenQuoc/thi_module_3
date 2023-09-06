package model;

public class Classroom {
    private int class_id ;
    private String classroom;

    public int getId ( ) {
        return class_id;
    }

    public void setId (int id) {
        this.class_id = id;
    }

    public String getClassroom ( ) {
        return classroom;
    }

    public void setClassroom (String classroom) {
        this.classroom = classroom;
    }

    public Classroom (int id, String classroom) {
        this.class_id = id;
        this.classroom = classroom;
    }
}

