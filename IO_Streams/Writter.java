package IO_Streams;

import Map.TreeMap.AverageStudentGrade;
import Map.TreeMap.SubjectGrade;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Writter {

    public void writeFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades, String source) throws IOException {
        //try (FileWriter writer = new FileWriter(source)) {    // FileWriter must implements interface Closable
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {   // The same, but PrintWriter(or BufferWritter) writes files by rows; FileWriter - by bites
            for (AverageStudentGrade gradeKey : grades.keySet()) {
                writer.write("\n\n==============================\n");
                writer.write("Student: " + gradeKey.getName() + "\nAvarage grade: " + gradeKey.getAverGrade());
                for (SubjectGrade grade : grades.get(gradeKey)) {
                    writer.write("\nSubject: " + grade.getSubject() + " | " + grade.getGrade());
                }
            }
        }
    }

    public void writeObject(List<Student> students, String source) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(source)))) {
            for (Student student : students) {
                out.writeObject(student);
            }
            out.writeObject(new Student("", -1, null));
        } catch (IOException e) {
            System.out.println("File can not be opened. Program terminates.");
            e.printStackTrace();
        }
    }

    public void readWriteByte(String source) throws IOException {
        try (FileInputStream reader = new FileInputStream(source);
             FileOutputStream writer = new FileOutputStream("Grade_Book_Byte.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print(c);
                writer.write(c);
            }
        }
    }

    public void createBankAccount() throws FileNotFoundException {
        Formatter formatter = new Formatter("Bank_Account.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter clientID, client Name, client Surname, client Balance: ");
        int i = 0;
        while (i < 3) {  // how many accounts will be created at once
            try {
                formatter.format("%d, %s, %s, %.2f %n", scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextFloat());
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Input is incorrect. Please try again");
                scanner.nextLine();
            }
        }
        formatter.close();
    }

    public void nioWritter(String nameFile) throws IOException {
        Path path = Paths.get(nameFile);
        Charset coding = Charset.forName("UTF-8");
        try(BufferedWriter writer = Files.newBufferedWriter(path, coding)){
            writer.write("There are some characters in this string");
        }
    }

}
