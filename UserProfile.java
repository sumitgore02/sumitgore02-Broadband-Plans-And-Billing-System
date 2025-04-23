package nvidia.in;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserProfile extends JFrame
{
	private static Long mobileNumber;
	private JLabel userNameLabel,mobileNumberLabel,planType,planDuration;
	 	
	
	public UserProfile() {
        setUpFrame();
       
       
    }
	
	private void setUpFrame() {
	        setTitle("Sign-In");
	        setSize(1366, 768);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
	        setVisible(true);

	        setContentPane(createBackgroundPanelImg());
	    }
	
	 private JPanel createBackgroundPanelImg() 
	 {
	        return new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo.jpg"));
	                Image image = icon.getImage();
	                double pwidth = getWidth();
	                double pheight = getHeight();
	                double imageWidth = image.getWidth(this);
	                double imageHeight = image.getHeight(this);
	                double scaled = Math.max(pwidth / imageWidth, pheight / imageHeight);
	                int scaledWidth = (int) (imageWidth * scaled);
	                int scaledHeight = (int) (imageHeight * scaled);
	                int x = (int) ((pwidth - scaledWidth) / 2);
	                int y = (int) ((pheight - scaledHeight) / 2);
	                g.drawImage(image, x, y, scaledWidth, scaledHeight, this);
	                g.setColor(new Color(0, 0, 0, 150));
	                g.fillRect(0, 0, getWidth(), getHeight());
	            }
	        };
	    }
	 
	 
	 private void UserDetails()
	 {
		 
	 }
}