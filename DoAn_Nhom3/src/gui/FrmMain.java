package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.NhanVien;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class FrmMain extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JPanel panelContent;
	private JButton btnHome;
	private JButton btnBanHang;
	private JButton btnQuanLyHoaDon;
	private JButton btnQuanLyNhanVien;
	private JPanel panelHome;
	private JPanel panelBanHang;
	private JPanel panelQuanLyHoaHon;
	private JPanel panelQuanLyNhanVien;
	private JButton btnQuanLySanPham;
	private JPanel panelQuanLySanPham;
	private JLabel lblNewLabel;
	private JLabel lblNhanVienMain;

	/**
	 * Launch the application.
	 */
	NhanVien nvDN = new NhanVien();
	public void setNVDangNhap(NhanVien a) {
		nvDN = a;
	}
	
	public void hienthiMenu(boolean a, boolean b ,boolean c , boolean d,boolean e ) {
		panelHome.setVisible(a);
		panelBanHang.setVisible(b);
		panelQuanLyHoaHon.setVisible(c);
		panelQuanLyNhanVien.setVisible(d);
		panelQuanLySanPham.setVisible(e);
	}
	public void hienThiNVDangNhap(NhanVien a) {
		lblNhanVienMain.setText(a.getHoTen());
		setNVDangNhap(a);
	}
	public void setHomeFrm() {
		FrmHome frmhome = new FrmHome();
		frmhome.setLocation(25, 37);
		panelContent.add(frmhome);
		frmhome.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Nhân Viên:");
		lblNewLabel.setBounds(6, 6, 72, 16);
		frmhome.getContentPane().add(lblNewLabel);
		
		lblNhanVienMain = new JLabel("");
		lblNhanVienMain.setBounds(90, 6, 239, 16);
		frmhome.getContentPane().add(lblNhanVienMain);
		frmhome.setVisible(true);
		frmhome.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); // Ẩn nút đóng và phóng to thu nhỏ
	}
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmMain frame = new FrmMain();
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
	public FrmMain(NhanVien nvDangNhap) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 243, 743);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnHome = new JButton("Trang chủ");
		btnHome.setBackground(Color.WHITE);
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-home.png"));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienthiMenu(true,false,false,false,false);
				
				FrmHome frmhome = new FrmHome();
				panelContent.add(frmhome);
				frmhome.setVisible(true);
				frmhome.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); // Ẩn nút đóng và phóng to thu nhỏ
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHome.setBackground(new Color(138, 43, 226));
				btnHome.setForeground(Color.white);
				btnHome.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-home.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHome.setBackground(Color.white);
				btnHome.setForeground(new Color(138, 43, 226));
				btnHome.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-home.png"));
			}
		});
		btnHome.setForeground(new Color(138, 43, 226));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBounds(0, 4, 224, 53);
		panelMenu.add(btnHome);
		
		btnBanHang = new JButton("Bán Hàng");
		btnBanHang.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-banhang.png"));
		btnBanHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnBanHang.setBackground(Color.WHITE);
		btnBanHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBanHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienthiMenu(false, true, false, false,false);
				
				FrmBanHang frmBanHang = new FrmBanHang(nvDN);
				panelContent.removeAll();
				panelContent.add(frmBanHang);
				frmBanHang.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBanHang.setBackground(new Color(138, 43, 226));
				btnBanHang.setForeground(Color.white);
				btnBanHang.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-banhang.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBanHang.setBackground(Color.white);
				btnBanHang.setForeground(new Color(138, 43, 226));
				btnBanHang.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-banhang.png"));
			}
		});
		btnBanHang.setForeground(new Color(138, 43, 226));
		btnBanHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBanHang.setBounds(0, 66, 224, 53);
		panelMenu.add(btnBanHang);
		
		btnQuanLyHoaDon = new JButton("Hóa Đơn");
		btnQuanLyHoaDon.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-hoadon.png"));
		btnQuanLyHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyHoaDon.setBackground(Color.WHITE);
		btnQuanLyHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienthiMenu(false, false, true, false,false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnQuanLyHoaDon.setBackground(new Color(138, 43, 226));
				btnQuanLyHoaDon.setForeground(Color.white);
				btnQuanLyHoaDon.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-hoadon.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnQuanLyHoaDon.setBackground(Color.white);
				btnQuanLyHoaDon.setForeground(new Color(138, 43, 226));
				btnQuanLyHoaDon.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-hoadon.png"));
			}
		});
		btnQuanLyHoaDon.setForeground(new Color(138, 43, 226));
		btnQuanLyHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLyHoaDon.setBounds(0, 136, 224, 53);
		panelMenu.add(btnQuanLyHoaDon);
		
		btnQuanLyNhanVien = new JButton("Nhân Viên");
		btnQuanLyNhanVien.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-nhanvien.png"));
		btnQuanLyNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyNhanVien.setBackground(Color.WHITE);
		btnQuanLyNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLyNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienthiMenu(false, false, false, true,false);
				
				FrmNhanVien frmNhanVien = new FrmNhanVien();
				panelContent.removeAll();
				panelContent.add(frmNhanVien);
				frmNhanVien.setVisible(true);
				frmNhanVien.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); // Ẩn nút đóng và phóng to thu nhỏ
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnQuanLyNhanVien.setBackground(new Color(138, 43, 226));
				btnQuanLyNhanVien.setForeground(Color.white);
				btnQuanLyNhanVien.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-nhanvien.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnQuanLyNhanVien.setBackground(Color.white);
				btnQuanLyNhanVien.setForeground(new Color(138, 43, 226));
				btnQuanLyNhanVien.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-nhanvien.png"));
			}
		});
		btnQuanLyNhanVien.setForeground(new Color(138, 43, 226));
		btnQuanLyNhanVien.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLyNhanVien.setBounds(3, 202, 221, 53);
		panelMenu.add(btnQuanLyNhanVien);
		
		panelHome = new JPanel();
		panelHome.setBackground(new Color(138, 43, 226));
		panelHome.setBounds(236, 4, 5, 49);
		panelMenu.add(panelHome);
		
		panelBanHang = new JPanel();
		panelBanHang.setBackground(new Color(138, 43, 226));
		panelBanHang.setBounds(236, 66, 5, 53);
		panelMenu.add(panelBanHang);
		
		panelQuanLyHoaHon = new JPanel();
		panelQuanLyHoaHon.setBackground(new Color(138, 43, 226));
		panelQuanLyHoaHon.setBounds(236, 136, 5, 53);
		panelMenu.add(panelQuanLyHoaHon);
		
		panelQuanLyNhanVien = new JPanel();
		panelQuanLyNhanVien.setBackground(new Color(138, 43, 226));
		panelQuanLyNhanVien.setBounds(236, 202, 5, 53);
		panelMenu.add(panelQuanLyNhanVien);
		
		btnQuanLySanPham = new JButton("Sản Phẩm");
		btnQuanLySanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienthiMenu(false, false, false, false,true);
				
				FrmSanPham frmSanPham = new FrmSanPham();
				panelContent.removeAll();
				panelContent.add(frmSanPham);
				frmSanPham.setVisible(true);
				frmSanPham.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); // Ẩn nút đóng và phóng to thu nhỏ
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnQuanLySanPham.setBackground(new Color(138, 43, 226));
				btnQuanLySanPham.setForeground(Color.white);
				btnQuanLySanPham.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-nhanvien.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnQuanLySanPham.setBackground(Color.white);
				btnQuanLySanPham.setForeground(new Color(138, 43, 226));
				btnQuanLySanPham.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-nhanvien.png"));
			}
		});
		btnQuanLySanPham.setIcon(new ImageIcon("C:\\Users\\thanh\\eclipse-workspace\\DoAn_Nhom3\\images\\icon-nhanvien.png"));
		btnQuanLySanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLySanPham.setBackground(Color.WHITE);
		btnQuanLySanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuanLySanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnQuanLySanPham.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLySanPham.setForeground(new Color(138, 43, 226));
		btnQuanLySanPham.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLySanPham.setBackground(Color.WHITE);
		btnQuanLySanPham.setBounds(3, 267, 221, 53);
		panelMenu.add(btnQuanLySanPham);
		
		panelQuanLySanPham = new JPanel();
		panelQuanLySanPham.setBackground(new Color(138, 43, 226));
		panelQuanLySanPham.setBounds(236, 267, 5, 53);
		panelMenu.add(panelQuanLySanPham);
		
		panelContent = new JPanel();
		panelContent.setBounds(244, 0, 924, 743);
		contentPane.add(panelContent);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		
		//Code
		hienthiMenu(true, false, false, false,false);
		setHomeFrm();
		hienThiNVDangNhap(nvDangNhap);
		
		
	}
}
