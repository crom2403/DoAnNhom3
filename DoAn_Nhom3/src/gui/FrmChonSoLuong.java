package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmChonSoLuong extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textSoluong;
	private JButton btnSoLuong;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmChonSoLuong frame = new FrmChonSoLuong();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrmChonSoLuong(FrmBanHang banhang, int soLuongConLai,int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Số lượng:");
		lblNewLabel.setBounds(12, 38, 56, 16);
		contentPane.add(lblNewLabel);
		
		textSoluong = new JTextField();
		textSoluong.setBounds(87, 35, 223, 22);
		contentPane.add(textSoluong);
		textSoluong.setColumns(10);
		
		btnSoLuong = new JButton("Chọn");
		btnSoLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soluong = Integer.parseInt(textSoluong.getText());
				if(soluong <= soLuongConLai) {
//					banhang.setSoLuongChon(soluong);
					banhang.themVaoGioHang(index,soluong);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng còn lại!");
				}
//				try {
//					
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, "Số lượng phải là số!");
//				}
			}
		});
		btnSoLuong.setBounds(323, 34, 97, 25);
		contentPane.add(btnSoLuong);
	}
}
