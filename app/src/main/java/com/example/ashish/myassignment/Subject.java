package com.example.ashish.myassignment;

/**
 * Created by ashish on 3/14/18.
 */

public class Subject {

    String subjectId;
    String subjectName;
    String subjectDescription;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName, String subjectDescription) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectDescription = subjectDescription;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }
}
