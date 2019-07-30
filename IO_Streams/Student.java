package IO_Streams;

import Map.TreeMap.SubjectGrade;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {
    private String name;
    private float avarageGrade;
    private Set<SubjectGrade> grades;

    public Student(String name, float avarageGrade, Set<SubjectGrade> grades) {
        this.name = name;
        this.avarageGrade = avarageGrade;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public float getAvarageGrade() {
        return avarageGrade;
    }

    public Set<SubjectGrade> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "\nStudent: " +
                name + '\n' +
                "Avarage Grade: " + avarageGrade +
                "\n" + grades;
    }
}
