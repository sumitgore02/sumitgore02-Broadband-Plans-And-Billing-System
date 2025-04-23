package nvidia.in;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class HomePage extends JFrame {
    private JButton register, signin, adsignin;

    public HomePage() {
        setUpFrame();
        initializeTextFieldComponents();
        addComponent();
        setUpListeners();
		lookAndFeel();
    }

    public void setUpFrame() {
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        setContentPane(createBackgroundPanelImg());
    }

    private JPanel createBackgroundPanelImg() {
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

    public void addComponent() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);

        JLabel label = new JLabel("Welcome To Nvidia Fibernet");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.white);
        titlePanel.add(label);

        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(titlePanel);
        mainPanel.add(Box.createVerticalStrut(50));

        JPanel buttonPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 100));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            }
        };
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);

        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(signin);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(register);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(adsignin);

        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(50));

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(Box.createVerticalGlue());
        contentPane.add(mainPanel);
        contentPane.add(Box.createVerticalGlue());
    }

    private void initializeTextFieldComponents() {
        signin = createStyledButton("Exsiting-user", new Color(30, 144, 255));
        register = createStyledButton("New-Customer", new Color(220, 20, 60));
        adsignin = createStyledButton("Admin Sign-In", new Color(50, 205, 50));
    }

    public JButton createStyledButton(String buttonTitle, Color color) {
        JButton button = new JButton(buttonTitle);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(Color.white);
        button.setForeground(Color.black);

        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color.darker(), 3),
            BorderFactory.createEmptyBorder(12, 25, 12, 25)
        ));
        button.setBackground(color);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(color.brighter(), 3),
                        BorderFactory.createEmptyBorder(12, 25, 12, 25)
                    ));
            	button.setBackground(color.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(color.darker(), 3),
                        BorderFactory.createEmptyBorder(12, 25, 12, 25)
                    ));
            	button.setBackground(color);
            }
        });

        button.setFocusPainted(false);
        button.setBorderPainted(true);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(300, 50));
        button.setMaximumSize(new Dimension(300, 50));

        return button;
    }
    public void lookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("exception");
		}
	}

	public void handleSignIn() {

		int option = JOptionPane.showConfirmDialog(this, "Existing User", "Confirm", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) 
		{
			new SignIn();
			dispose();
		} 
		else 
		{
			JOptionPane.showMessageDialog(null, "Please Sign Up", "Alert", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void handleSignUp() {
		int option = JOptionPane.showConfirmDialog(this, "Are You New User", "Confirm", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) 
		{
			
			new RegisterationPage();
			dispose();
			
		} else {
			JOptionPane.showMessageDialog(null, "Please Sign in", "Alert", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void adminHandleSignIn() {
		int option = JOptionPane.showConfirmDialog(this, "Are You Admin ?", "Confirm", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (option == JOptionPane.YES_OPTION) {

			new AdminSignIn();
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Exit", "Alert", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void setUpListeners() {
		signin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleSignIn();
			}
		});

		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleSignUp();

			}
		});
		adsignin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminHandleSignIn();

			}
		});
	}

    public static void main(String[] args) {
        
    	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new HomePage();
			}
		});
    	
    }
}