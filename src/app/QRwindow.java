package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRwindow {
    JFrame frame = new JFrame();
    JLabel codeLabel = new JLabel();
    JPanel QRcodePanel = new JPanel();
    QRwindow(String QRcodePath) throws IOException {
        codeLabel.setIcon(new ImageIcon(QRcodePath));

        QRcodePanel.setBounds(0,0,200,200);
        QRcodePanel.add(codeLabel);

        frame.add(QRcodePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(215,230);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
