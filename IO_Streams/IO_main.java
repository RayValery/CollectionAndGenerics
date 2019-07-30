package IO_Streams;

import Map.TreeMap.*;

import java.io.*;
import java.util.*;

public class IO_main {

    private static final String source = "Grade_Book.txt";
    private static final String binaryFileName = "Objects.bin";
    private static final String name = "nioFile.txt";

    public static void main(String[] args) throws IOException {
        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        Writter writter = new Writter();
        Reader reader = new Reader();
        //writter.writeFile(grades, source);
        // reader.readFile(source);
        // writter.readWriteByte(source);

        //writter.createBankAccount();

        //processGrades(grades, writter, binaryFileName);
        //printList(reader, binaryFileName);

        FileUtils fileUtils = new FileUtils();
        //fileUtils.printIOFileDetail(source);
        //System.out.println("\n================================\n");
        //fileUtils.printIOFileDetail("./");

        writter.nioWritter(name);
        reader.nioFileReader(name);
    }

    private static void printList(Reader reader, String source) {
        List<Student> list = reader.readObjects(source);
        for (Student a : list) {
            System.out.println(a.toString());
        }
    }

    private static void processGrades(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writter writter, String source) {
        List<Student> students = new ArrayList<>();
        for (AverageStudentGrade gradeKey : grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAverGrade(), grades.get(gradeKey)));
        }
        writter.writeObject(students, source);
    }


}
