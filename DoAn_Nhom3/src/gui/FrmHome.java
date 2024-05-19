package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FrmHome extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHome frame = new FrmHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmHome() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		setMaximizable(true);
		setNormalBounds(new Rectangle(244, 0, 924, 743));
		setBounds(100, 100, 924, 742);
		

	}
}
