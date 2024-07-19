package app;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class UI implements ActionListener {
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JLabel titleLabel = new JLabel();
    JButton button = new JButton();

    UI() throws IOException {
        button.setBounds(170,200,150,50);
        button.setText("Generate");
        button.setFont(new Font("Arial",Font.BOLD,15));
        button.addActionListener(this);

        titleLabel.setText("QR code generator");
        titleLabel.setFont(new Font("Arial",Font.BOLD,35));
        titleLabel.setBounds(15,0,500,100);

        textField.setBounds(70,100,350,50);
        textField.setFont(new Font("Arial",Font.PLAIN,20));

        frame.add(button);
        frame.add(titleLabel);
        frame.add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,350);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            String data = textField.getText();
            frame.dispose();
            try {
                generateQR(data);
                String QRcodePath = "C:/Users/adamn/IdeaProjects/QRCodeGenApp/src/QRcode.jpg";
                QRwindow qRwindow = new QRwindow(QRcodePath);
            } catch (WriterException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void generateQR(String url) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE,200,200);

        MatrixToImageWriter.writeToPath(matrix,"jpg", Paths.get("/Users/adamn/IdeaProjects/QRCodeGenApp/src/QRcode.jpg"));
    }
}
