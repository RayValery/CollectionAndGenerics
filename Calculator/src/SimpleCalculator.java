import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        // 1. Create Panel
        JPanel windowContent = new JPanel();    // container

        // 2. Set a layout(шаблон) manager for this panel
        FlowLayout flowLayout = new FlowLayout();     // розміщює ЛОГІЧНО елементи
        windowContent.setLayout(flowLayout);          // відповідно до розміру екрану

        GridLayout gridLayout = new GridLayout(4,2);   // розміщює елементи
        windowContent.setLayout(gridLayout);                     // у вигляді таблиці

        // 3. Create controls in memory
        JLabel label1 = new JLabel("Number 1:");
        JTextField textField1 = new JTextField(10);
        JLabel label2 =new JLabel("Number 2:");
        JTextField textField2= new JTextField(10);
        JLabel label3 = new JLabel("Sum:");
        JTextField result = new JTextField(10);
        JButton go = new JButton("Add");

        // 4. Add controls to the panel
        windowContent.add(label1);
        windowContent.add(textField1);
        windowContent.add(label2);
        windowContent.add(textField2);
        windowContent.add(label3);
        windowContent.add(result);
        windowContent.add(go);

        // 5. Create the FRAME and add the panel to it
        JFrame frame = new JFrame("My first Graphic program");

        // 6. Add the panel to the container
        frame.setContentPane(windowContent);

        // 7. Set the size and make visible
        frame.setSize(400,100);
        frame.setVisible(true);

        frame.setResizable(false);  // resize prohibition
    }
}
