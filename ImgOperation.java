package Project;
import javax.swing.JButton;
import javax.swing.JFileChooser;
//import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImgOperation {
	
	public static void operate(int key) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		//file input stream reader
		try {
			FileInputStream fis = new FileInputStream(file);
			
			byte[] data = new byte[fis.available()];
			fis.read(data);
			int i=0;
			
			for(byte b:data) {
				System.out.println(b);// It print byte number of selected image
				data[i] = (byte)(b^key); // Using XOR function to encrypt
				i++;
			}
			
			FileOutputStream fos = new  FileOutputStream(file);
			fos.write(data);;
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		System.out.println("This is testing");
		
		JFrame f = new JFrame();
		f.setTitle("Image Operation");
		f.setSize(400,600);
		f.setLocationRelativeTo(null); // So that Frame open in center
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // So that window close easily and smoothly
		
		//Font Text 
		Font font = new Font("Roboto",Font.BOLD, 20);
		
		
		//Creating Button
		JButton button = new JButton();
		button.setText("OPEN IMAGE");
		button.setFont(font);
		
		//creating text field
		JTextField textField = new JTextField(10);
		textField.setFont(font);
		
		// layout
		f.setLayout(new FlowLayout());
		f.add(button);
		f.add(textField);
		
		//Function call for 
		// "e -> {......}" its called lambda function
		button.addActionListener(e -> {
			System.out.println("Button click");
			String Text = textField.getText();
			int temp = Integer.parseInt(Text);
			operate(temp);
		});//something that we click
		
		f.setVisible(true);
		
	}
}
