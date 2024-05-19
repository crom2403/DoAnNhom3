package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.SanPhamDAO;
import model.NhanVien;
import model.SanPham;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmSanPham extends JInternalFrame {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textMaSp;
	private JTextField textTenSp;
	private JTextField textGiaSp;
	private JTextField textSoLuongSp;
	private JTextField textMotaSp;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable tableSanPham;

	/**
	 * Launch the application.
	 */
	DefaultTableModel modelSanPham = new DefaultTableModel();
	List<SanPham> listSp = new ArrayList<SanPham>();
	SanPhamDAO spDao = new SanPhamDAO();
	
	
	
	public void loadData() {
		modelSanPham.setRowCount(0);
		listSp = spDao.findAll();
		for(SanPham a : listSp) {
			Object[] ob = {a.getMasp(),a.getTensp(),a.getGia(),a.getSoluong(),a.getMota()};
			modelSanPham.addRow(ob);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSanPham frame = new FrmSanPham();
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
	public FrmSanPham() {
		setBounds(100, 100, 924, 742);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setBounds(12, 31, 80, 16);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1.setBounds(12, 70, 113, 16);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Giá");
		lblNewLabel_2.setBounds(12, 108, 80, 16);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Số lượng");
		lblNewLabel_3.setBounds(12, 149, 80, 16);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Mô tả");
		lblNewLabel_4.setBounds(12, 186, 80, 16);
		getContentPane().add(lblNewLabel_4);
		
		textMaSp = new JTextField();
		textMaSp.setBounds(137, 24, 315, 30);
		getContentPane().add(textMaSp);
		textMaSp.setColumns(10);
		
		textTenSp = new JTextField();
		textTenSp.setColumns(10);
		textTenSp.setBounds(137, 63, 315, 30);
		getContentPane().add(textTenSp);
		
		textGiaSp = new JTextField();
		textGiaSp.setColumns(10);
		textGiaSp.setBounds(137, 101, 315, 30);
		getContentPane().add(textGiaSp);
		
		textSoLuongSp = new JTextField();
		textSoLuongSp.setColumns(10);
		textSoLuongSp.setBounds(137, 142, 315, 30);
		getContentPane().add(textSoLuongSp);
		
		textMotaSp = new JTextField();
		textMotaSp.setColumns(10);
		textMotaSp.setBounds(137, 186, 315, 30);
		getContentPane().add(textMotaSp);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textMaSp.getText();
				String ten = textTenSp.getText();
				float gia = Float.parseFloat(textGiaSp.getText());
				int sl = Integer.parseInt(textSoLuongSp.getText());
				String mota = textMotaSp.getText();
				SanPham a = new SanPham(ma,ten,gia,sl,mota);
				if(spDao.them(a)) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					loadData();
				}else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại");
				}
			}
		});
		btnThem.setBounds(618, 27, 97, 25);
		getContentPane().add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableSanPham.getSelectedRow();		
				if(i > -1) {
					SanPham a = listSp.get(i);
					if(spDao.Xoa(a)) {
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						loadData();
					}else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Chưa chọn dòng cần xóa");
				}
			}
		});
		btnXoa.setBounds(618, 66, 97, 25);
		getContentPane().add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = textMaSp.getText();
				String ten = textTenSp.getText();
				float gia = Float.parseFloat(textGiaSp.getText());
				int sl = Integer.parseInt(textSoLuongSp.getText());
				String mota = textMotaSp.getText();
				SanPham a = new SanPham(ma,ten,gia,sl,mota);
				if(spDao.Sua(a)) {
					JOptionPane.showMessageDialog(null, "Sửa thành công");
					loadData();
				}else {
					JOptionPane.showMessageDialog(null, "Sửa thất bại");
				}
			}
		});
		btnSua.setBounds(618, 108, 97, 25);
		getContentPane().add(btnSua);
		
		panel = new JPanel();
		panel.setBounds(12, 271, 872, 422);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tableSanPham = new JTable();
		tableSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableSanPham.getSelectedRow();	
				SanPham a = listSp.get(i);
				textMaSp.setText(a.getMasp());
				textTenSp.setText(a.getTensp());
				textGiaSp.setText(a.getGia()+"");
				textSoLuongSp.setText(a.getSoluong()+"");
				textMotaSp.setText(a.getMota());
			}
		});
		scrollPane.setViewportView(tableSanPham);
		
		
		
		//code
		tableSanPham.setModel(modelSanPham);
		modelSanPham.addColumn("Mã sản phẩm");
		modelSanPham.addColumn("Tên sản phẩm");
		modelSanPham.addColumn("Giá");
		modelSanPham.addColumn("Số lượng");
		modelSanPham.addColumn("Mô tả");
		loadData();

	}
}
