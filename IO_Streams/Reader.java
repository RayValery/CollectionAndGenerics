package IO_Streams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public void readFile(String source) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        String c;
        while ((c = reader.readLine()) != null) {
            System.out.println(c);
        }
    }

    public List<Student> readObjects(String source) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(source)))) {
            Boolean keepReading = true;
            while (keepReading) {
                Student student = (Student) in.readObject();
                if (!"".equals(student.getName())) {
                    students.add(student);
                } else keepReading = false;
            }
        } catch (IOException e) {
            System.out.println("Unable to open file " + source + "\nProgram terminates.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Invalid object type");
            e.printStackTrace();
        }
        return students;
    }

    public void nioFileReader(String source) throws IOException {
        Path path = Paths.get(source);
        Charset coding = Charset.forName("UTF-8");
        try(BufferedReader reader = Files.newBufferedReader(path, coding)){
            String l;
            while ((l=reader.readLine())!= null){
                System.out.println(l);
            }
        }
    }
}
