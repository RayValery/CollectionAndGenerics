package Map.TreeMap;

public class AverageStudentGrade implements Comparable {
    private final String name;
    private final float averGrade;

    public AverageStudentGrade(String name, float averGrade) {
        this.name = name;
        this.averGrade = averGrade;
    }

    public String getName() {
        return name;
    }

    public float getAverGrade() {
        return averGrade;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof AverageStudentGrade)) {
            throw new UnsupportedOperationException();
        } else if (this.getAverGrade() < ((AverageStudentGrade) o).getAverGrade()) {
            return -1;
        } else if (this.getAverGrade() > ((AverageStudentGrade) o).getAverGrade()) {
            return 1;
        } else return (this.getName().compareTo(((AverageStudentGrade) o).getName()));

    }

    @Override
    public String toString() {
        return "\nName: " + name + "\n" +
                "Avarage grade: " + averGrade;
    }
}
