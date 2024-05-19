package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmChonKhachHang extends JFrame {
	
	
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	List<KhachHang> listKH = new ArrayList<KhachHang>();
	DefaultTableModel modelKH = new DefaultTableModel();
	KhachHang khchon = new KhachHang();
	
	public KhachHang getKhachHangDuocChon() {
		return khchon;
	}

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnChonKH;
	private JTable table;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JLabel lblNewLabel;
	private JTextField textMa;
	private JLabel lblNewLabel_1;
	private JTextField textTenKH;
	private JLabel lblNewLabel_2;
	private JTextField textDiaChi;
	private JLabel lblNewLabel_3;
	private JTextField textSDT;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmChonKhachHang frame = new FrmChonKhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public void hienThi() {
		modelKH.setRowCount(0);
		listKH = khachHangDAO.findAll();
		for(KhachHang a : listKH) {
			Object[] ob = {a.getMakh(),a.getTenkh(),a.getDiachi(),a.getSdt()};
			modelKH.addRow(ob);
		}
	}

	/**
	 * Create the frame.
	 */
	public FrmChonKhachHang(FrmBanHang banhang,KhachHang khchon) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 227, 784, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				KhachHang a = listKH.get(index);
				textMa.setText(a.getMakh());
				textTenKH.setText(a.getTenkh());
				textDiaChi.setText(a.getDiachi());
				textSDT.setText(a.getSdt());
			}
		});
		scrollPane.setViewportView(table);
		
		btnChonKH = new JButton("Chọn");
		btnChonKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if(index > -1) {
					KhachHang a = listKH.get(index);
					khchon.setMakh(a.getMakh());
					khchon.setTenkh(a.getTenkh());
					khchon.setDiachi(a.getDiachi());
					khchon.setSdt(a.getSdt());
					banhang.reloadFrame();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Chua chon khach hang");
				}
			}
		});
		btnChonKH.setBounds(861, 28, 97, 25);
		contentPane.add(btnChonKH);
		
		
		// CODE
		table.setModel(modelKH);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textMa.getText();
				String ten = textTenKH.getText();
				String dc = textDiaChi.getText();
				String sdt = textSDT.getText();
				KhachHang a = new KhachHang(ma,ten,dc,sdt);
				if(khachHangDAO.them(a)) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					hienThi();
				}else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại");
				}
				
			}
		});
		btnThem.setBounds(861, 79, 97, 25);
		contentPane.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = table.getSelectedRow();
					if(index > -1) {
						if(khachHangDAO.Xoa(listKH.get(index))) {
							JOptionPane.showMessageDialog(null, "Xoa thanh cong");
							hienThi();
						}else {
							JOptionPane.showMessageDialog(null, "Xoa that bai");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Chua chon khach hang can xoa");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Mã KH đã tồn tại");
				}
				
			}
		});
		btnXoa.setBounds(861, 136, 97, 25);
		contentPane.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textMa.getText();
				String ten = textTenKH.getText();
				String dc = textDiaChi.getText();
				String sdt = textSDT.getText();
				KhachHang a = new KhachHang(ma,ten,dc,sdt);
				if(khachHangDAO.Sua(a)) {
					modelKH.setRowCount(0);
					hienThi();
					JOptionPane.showMessageDialog(null,"Sua thanh cong");
				}else {
					JOptionPane.showMessageDialog(null, "Sua thất bại");
				}
				
			}
		});
		btnSua.setBounds(861, 192, 97, 25);
		contentPane.add(btnSua);
		
		lblNewLabel = new JLabel("Mã KH:");
		lblNewLabel.setBounds(12, 13, 56, 16);
		contentPane.add(lblNewLabel);
		
		textMa = new JTextField();
		textMa.setBounds(97, 10, 283, 22);
		contentPane.add(textMa);
		textMa.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Tên KH:");
		lblNewLabel_1.setBounds(12, 55, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		textTenKH = new JTextField();
		textTenKH.setBounds(97, 52, 283, 22);
		contentPane.add(textTenKH);
		textTenKH.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Địa chỉ:");
		lblNewLabel_2.setBounds(12, 105, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		textDiaChi = new JTextField();
		textDiaChi.setBounds(97, 102, 283, 19);
		contentPane.add(textDiaChi);
		textDiaChi.setColumns(10);
		
		lblNewLabel_3 = new JLabel("SĐT:");
		lblNewLabel_3.setBounds(12, 165, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		textSDT = new JTextField();
		textSDT.setBounds(97, 162, 283, 19);
		contentPane.add(textSDT);
		textSDT.setColumns(10);
		modelKH.addColumn("Mã khách hàng");
		modelKH.addColumn("Tên khách hàng");
		modelKH.addColumn("Địa chỉ");
		modelKH.addColumn("Số điện thoại");
		hienThi();
		
	}
}
