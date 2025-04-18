package Programm;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {

	JFrame myWindow = new JFrame("Cautious-Doodle");
	JPanel chalkboard = new JPanel();

	GridBagLayout gLayout = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	JButton openBtn = new JButton("Open Images");
	JButton closeBtn = new JButton("Close");
	JButton nLinksBtn = new JButton("<<");
	JButton nRechtsBtn = new JButton(">>");

	JLabel lbl1 = new JLabel("Let's see your Images!");

	//Image Box
	static JLabel image_box = new JLabel();

	File[] selectedFiles;
	int currentImageIndex = 0;

	public void go(){

		//Layout
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(5,5,5,5);
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		gbc.ipady = 10;
		gbc.ipadx = 10;
		gbc.gridheight = 1;

		//Panel Definition
		chalkboard.setLayout(gLayout);
		chalkboard.setForeground(Color.orange);
		chalkboard.setBackground(Color.orange);

		//Button Location
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.NORTH;
		chalkboard.add(lbl1, gbc);

		//ButtonColor
		Color buttonColor = Color.yellow;
		nLinksBtn.setBackground(buttonColor);
		nRechtsBtn.setBackground(buttonColor);
		closeBtn.setBackground(buttonColor);
		openBtn.setBackground(buttonColor);

		//Open Button
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		chalkboard.add(openBtn, gbc);

		//Image
		image_box.setPreferredSize(new Dimension(500,700));
		image_box.setHorizontalAlignment(SwingConstants.CENTER);
		image_box.setVerticalAlignment(SwingConstants.CENTER);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 4;
		gbc.gridheight = 4;
		chalkboard.add(image_box, gbc);

		gbc.insets = new Insets(5,0,5,0);
		gbc.anchor = GridBagConstraints.CENTER;

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		chalkboard.add(nLinksBtn,gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		chalkboard.add(nRechtsBtn,gbc);

		//Close Button
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		chalkboard.add(closeBtn,gbc);

		//Window
		myWindow.add(chalkboard);
		myWindow.setSize(new Dimension(1000,1000));
		myWindow.setVisible(true);
		myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ActionListener imageOpener = e -> {
			//File Opener
			JFileChooser chooser = new JFileChooser("Choose an Image");
			//Filter
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files","jpg","png","tif","bmp","jpeg");
			chooser.addChoosableFileFilter(filter);
			chooser.setFileFilter(filter);

			//Chooser Set
			chooser.setDialogType(JFileChooser.CUSTOM_DIALOG);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setMultiSelectionEnabled(true);
			chooser.setFileHidingEnabled(false);

			chooser.setVisible(true);
			int result = chooser.showOpenDialog(null);

			if(result == JFileChooser.APPROVE_OPTION){
				// File imageFile = chooser.getSelectedFile(); one File
				selectedFiles = chooser.getSelectedFiles();
				currentImageIndex = 0;
				if(selectedFiles.length > 0){
					ImageOpener.showImage(selectedFiles[currentImageIndex]);
				}
			}

			chooser.setVisible(false);
		};
		openBtn.addActionListener(imageOpener);

		nLinksBtn.addActionListener(e -> {
			if ( selectedFiles != null && selectedFiles.length > 0) {
				currentImageIndex = (currentImageIndex - 1 + selectedFiles.length) % selectedFiles.length;
				ImageOpener.showImage(selectedFiles[currentImageIndex]);
			}
		});

		nRechtsBtn.addActionListener(e -> {
			if( selectedFiles != null && selectedFiles.length > 0 ){
				currentImageIndex = (currentImageIndex + 1) % selectedFiles.length;
				ImageOpener.showImage(selectedFiles[currentImageIndex]);
			}
		});
		closeBtn.addActionListener(e -> System.exit(0));
	}

}
