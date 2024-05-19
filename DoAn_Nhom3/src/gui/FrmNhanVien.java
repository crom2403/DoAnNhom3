package gui;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import model.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmNhanVien extends JInternalFrame {
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField textMaNV;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textTenNV;
	private JTextField textMatKhau;
	private JTextField textDiaChi;
	private JLabel lblNewLabel_6;
	private JTextField textSDT;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_9;
	private JTextField textNgaySinh;
	private JComboBox cboVaiTro;
	private JRadioButton rdbNam;
	private JRadioButton rdbNu;
	private final ButtonGroup buttonGroupGioiTinh = new ButtonGroup();
	private final ButtonGroup buttonGroupTrangThai = new ButtonGroup();
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JPanel panel_1;
	private JLabel lblLc;
	private JLabel lblNewLabel_11;
	private JComboBox cboLocGioiTinh;
	private JLabel lblNewLabel_12;
	private JComboBox cboLocVaiTro;
	private JLabel lblTmKim;
	private JPanel panel_2;
	private JTextField textTimKiem;
	private JScrollPane scrollPane;
	private JTable tableNhanVien;

	/**
	 * Launch the application.
	 */
	
	DefaultTableModel modelNv = new DefaultTableModel();
	List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
	NhanVienDAO nvDao = new NhanVienDAO();
	DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>();
	
	
	public void loadData() {
		modelNv.setRowCount(0);
		listNhanVien = nvDao.findAll();
		for(NhanVien a : listNhanVien) {
			Object[] ob = {a.getManv(),a.getHoTen(),a.getMatKhau(),a.getGioiTinh(),a.getNgaySinh(),a.getSdt(),a.getDiaChi(),a.getVaiTro()};
			modelNv.addRow(ob);
		}
	}
	public void themData() {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			NhanVien b = new NhanVien();
			b.setManv(textMaNV.getText());
			b.setHoTen(textTenNV.getText());
			b.setMatKhau(textMatKhau.getText());
			if(rdbNam.isSelected()) {
				b.setGioiTinh("Nam");
			}else {
				b.setGioiTinh("Nữ");
			}
			Date ngaysinh = sf.parse(textNgaySinh.getText());
			b.setNgaySinh(ngaysinh);
			b.setSdt(textSDT.getText());
			b.setDiaChi(textDiaChi.getText());
			b.setVaiTro(cboVaiTro.getSelectedItem()+"");
			JOptionPane.showMessageDialog(null,b);
			if(nvDao.them(b)) {
				modelNv.setRowCount(0);
				loadData();
			}else {
				JOptionPane.showMessageDialog(null,"Them that bai");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Nhap ngay khong dung");
		}
	}
	
	public void SuaData() {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			NhanVien b = new NhanVien();
			b.setManv(textMaNV.getText());
			b.setHoTen(textTenNV.getText());
			b.setMatKhau(textMatKhau.getText());
			if(rdbNam.isSelected()) {
				b.setGioiTinh("Nam");
			}else {
				b.setGioiTinh("Nữ");
			}
			Date ngaysinh = sf.parse(textNgaySinh.getText());
			b.setNgaySinh(ngaysinh);
			b.setSdt(textSDT.getText());
			b.setDiaChi(textDiaChi.getText());
			b.setVaiTro(cboVaiTro.getSelectedItem()+"");
			if(nvDao.Sua(b)) {
				modelNv.setRowCount(0);
				loadData();
				JOptionPane.showMessageDialog(null,"Sua thanh cong");
			}else {
				JOptionPane.showMessageDialog(null,"Sua that bai");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Nhap ngay khong dung");
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanVien frame = new FrmNhanVien();
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
	public FrmNhanVien() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Thiết lập thông tin nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 13, 383, 16);
		getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(22, 42, 875, 276);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Mã NV");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 13, 56, 16);
		panel.add(lblNewLabel_1);
		
		textMaNV = new JTextField();
		textMaNV.setBounds(103, 10, 216, 22);
		panel.add(textMaNV);
		textMaNV.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Tên NV");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(12, 53, 56, 16);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mật khẩu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 94, 80, 16);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Vai trò");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(12, 140, 56, 16);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Địa chỉ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(12, 183, 56, 16);
		panel.add(lblNewLabel_5);
		
		textTenNV = new JTextField();
		textTenNV.setColumns(10);
		textTenNV.setBounds(103, 50, 216, 22);
		panel.add(textTenNV);
		
		textMatKhau = new JTextField();
		textMatKhau.setColumns(10);
		textMatKhau.setBounds(103, 91, 216, 22);
		panel.add(textMatKhau);
		
		textDiaChi = new JTextField();
		textDiaChi.setColumns(10);
		textDiaChi.setBounds(103, 180, 216, 22);
		panel.add(textDiaChi);
		
		lblNewLabel_6 = new JLabel("Điện thoại");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(474, 13, 73, 16);
		panel.add(lblNewLabel_6);
		
		textSDT = new JTextField();
		textSDT.setColumns(10);
		textSDT.setBounds(578, 10, 216, 22);
		panel.add(textSDT);
		
		lblNewLabel_7 = new JLabel("Ngày sinh");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(474, 53, 73, 16);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_9 = new JLabel("Giới tính");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(474, 140, 73, 16);
		panel.add(lblNewLabel_9);
		
		textNgaySinh = new JTextField();
		textNgaySinh.setColumns(10);
		textNgaySinh.setBounds(578, 50, 216, 22);
		panel.add(textNgaySinh);
		
		cboVaiTro = new JComboBox();
		cboVaiTro.setBounds(103, 135, 151, 27);
		panel.add(cboVaiTro);
		
		rdbNam = new JRadioButton("Nam");
		buttonGroupGioiTinh.add(rdbNam);
		rdbNam.setBounds(574, 136, 127, 25);
		panel.add(rdbNam);
		
		rdbNu = new JRadioButton("Nữ");
		buttonGroupGioiTinh.add(rdbNu);
		rdbNu.setBounds(716, 136, 127, 25);
		panel.add(rdbNu);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themData();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setBounds(203, 227, 97, 25);
		panel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SuaData();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setBounds(361, 227, 97, 25);
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableNhanVien.getSelectedRow();
				if(index > -1) {
					if(nvDao.Xoa(listNhanVien.get(index))) {
						JOptionPane.showMessageDialog(null, "Xoa thanh cong");
						loadData();
					}else {
						JOptionPane.showMessageDialog(null, "Xoa that bai");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Chua chon nhan vien can xoa");
				}
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(513, 227, 97, 25);
		panel.add(btnXoa);
		
		panel_1 = new JPanel();
		panel_1.setBounds(22, 350, 554, 57);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_11 = new JLabel("Theo giới tính");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(12, 19, 98, 16);
		panel_1.add(lblNewLabel_11);
		
		cboLocGioiTinh = new JComboBox();
		cboLocGioiTinh.setBounds(106, 14, 151, 27);
		panel_1.add(cboLocGioiTinh);
		
		lblNewLabel_12 = new JLabel("Theo vai trò");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_12.setBounds(288, 19, 98, 16);
		panel_1.add(lblNewLabel_12);
		
		cboLocVaiTro = new JComboBox();
		cboLocVaiTro.setBounds(391, 16, 151, 27);
		panel_1.add(cboLocVaiTro);
		
		lblLc = new JLabel("Lọc");
		lblLc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLc.setBounds(22, 331, 57, 16);
		getContentPane().add(lblLc);
		
		lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTmKim.setBounds(596, 331, 154, 16);
		getContentPane().add(lblTmKim);
		
		panel_2 = new JPanel();
		panel_2.setBounds(588, 350, 309, 57);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textTimKiem = new JTextField();
		textTimKiem.setColumns(10);
		textTimKiem.setBounds(12, 13, 285, 31);
		panel_2.add(textTimKiem);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 438, 875, 257);
		getContentPane().add(scrollPane);
		
		tableNhanVien = new JTable();
		tableNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableNhanVien.getSelectedRow();
				NhanVien a = listNhanVien.get(index);
				textMaNV.setText(a.getManv());
				textTenNV.setText(a.getHoTen());
				textMatKhau.setText(a.getMatKhau());
				textNgaySinh.setText(a.getNgaySinh()+"");
				textDiaChi.setText(a.getDiaChi());
				textSDT.setText(a.getSdt());
				if(a.getGioiTinh().matches("Nam")) {
					rdbNam.setSelected(true);
					rdbNu.setSelected(false);
				}else {
					rdbNam.setSelected(false);
					rdbNu.setSelected(true);
				}
				if(a.getVaiTro().matches("Nhân viên")) {
					cboVaiTro.setSelectedIndex(0);
				}else {
					cboVaiTro.setSelectedIndex(1);
				}
			}
		});
		scrollPane.setViewportView(tableNhanVien);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		setMaximizable(true);
		setNormalBounds(new Rectangle(244, 0, 924, 743));
		setBounds(100, 100, 924, 742);
		
		
		
		//code xử lý
		tableNhanVien.setModel(modelNv);
		modelNv.addColumn("Mã nhân viên");
		modelNv.addColumn("Tên nhân viên");
		modelNv.addColumn("mật khẩu");
		modelNv.addColumn("Giới tính");
		modelNv.addColumn("Ngày sinh");
		modelNv.addColumn("SDT");
		modelNv.addColumn("Địa chỉ");
		modelNv.addColumn("Vai trò");
		loadData();
		cboVaiTro.setModel(comboModel);
		comboModel.addElement("Nhân viên");
		comboModel.addElement("Quản lý");
		cboVaiTro.setSelectedItem(0);
		

	}
}
