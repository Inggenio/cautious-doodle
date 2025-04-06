package Programm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageOpener {
	public static void showImage(File imageFile){
		try{
			BufferedImage image = ImageIO.read(imageFile);
			Image tmp = image.getScaledInstance(600,-1,Image.SCALE_SMOOTH);
			BufferedImage img = new BufferedImage(tmp.getWidth(null),
					tmp.getHeight(null),
					BufferedImage.TYPE_INT_ARGB);
			img.getGraphics().drawImage(tmp,0,0,null);
			GUI.image_box.setIcon(new ImageIcon(img));

		} catch (Exception c){
			JOptionPane.showMessageDialog(null, "ERROR\n" + c);
		}
	}
}
