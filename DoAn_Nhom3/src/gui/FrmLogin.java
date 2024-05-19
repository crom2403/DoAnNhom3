package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NhanVienDAO;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

import java.util.*;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnLogin;
	private JButton btnExit;
	private JTextField textUsername;
	private JTextField textPassword;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	
	NhanVienDAO nvDao = new NhanVienDAO();
	NhanVien nvDangNhap = new NhanVien();
	public NhanVien getNVDangNhap() {
		return nvDangNhap;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(43, 103, 136, 35);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(43, 167, 136, 25);
		contentPane.add(lblNewLabel_1);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String manv = textUsername.getText();
					String mk = textPassword.getText();
					NhanVien b = nvDao.findById(manv);
					if(b == null) {
						JOptionPane.showMessageDialog(null, "Mã nhân viên không đúng!");
					}else {
						if(b.getMatKhau().matches(mk)) {
							dispose();
							nvDangNhap = b;
							FrmMain frmMain = new FrmMain(b);
							frmMain.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Sai mật khẩu");
						}
					}
				} catch (Exception e2) {
					throw new Error(e2.getMessage());
				}
				
			}
		});
		btnLogin.setForeground(new Color(0, 0, 128));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setBounds(191, 259, 145, 35);
		contentPane.add(btnLogin);
		
		btnExit = new JButton("Thoát");
		btnExit.setForeground(new Color(0, 0, 128));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnExit.setBounds(390, 259, 136, 35);
		contentPane.add(btnExit);
		
		textUsername = new JTextField();
		textUsername.setBounds(191, 103, 335, 38);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(191, 162, 334, 38);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Đăng nhập");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_2.setBounds(214, 25, 220, 55);
		contentPane.add(lblNewLabel_2);
	}
}
