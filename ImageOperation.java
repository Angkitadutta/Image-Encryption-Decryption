import javax.swing.JFrame; 
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;




public class ImageOperation{

    public static void operate(int key){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();

        //To read data from file
        try 
        {
            FileInputStream fis = new FileInputStream(file);
            
            //To read
            byte []data = new byte[fis.available()];
            fis.read(data);
            int byteIndex = 0;
            for(byte newByte:data)
            {
                System.out.println(newByte);
                data[byteIndex] = (byte)(newByte^key);
                byteIndex++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        System.out.println("this is just for demo");

        JFrame f = new JFrame();
        f.setTitle("Image Operation");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto",Font.BOLD,25);

        //Creating button
        JButton button = new JButton();
        button.setText("Open Image");
        button.setFont(font);

        
        //Creating text field
        JTextField textField = new JTextField(10);
        textField.setFont(font);

        //Add Listener to buttons
        button.addActionListener(e->{
            System.out.println("Button Clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());

        //Set button
        f.add(button);
        f.add(textField);

        f.setVisible(true);
    }
}