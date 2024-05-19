package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmBanHang extends JInternalFrame {
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnChonKhachHang;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnHuyHoaDon;
	private JButton btnThanhToan;
	private JButton btnTaoHoaDon;
	private JTable tableHoaDonCho;
	private JTable tableGioHang;
	private JLabel lblNewLabel_8;
	private JTextField textTimKiemSanPham;
	private JButton btnTimKiemSanPham;
	private JPanel panel_4;
	private JScrollPane scrollPane_1;
	private JTable tableSanPham;
	private JTextField textMaHoaDon;

	/**
	 * Launch the application.
	 */
	
	DefaultTableModel modelSanPham = new DefaultTableModel();
	DefaultTableModel modelGioHang = new DefaultTableModel();
	SanPhamDAO sanPhamDAO = new SanPhamDAO();
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	NhanVienDAO nhanVienDAO = new NhanVienDAO();
	FrmLogin login = new FrmLogin();
	KhachHang khchon = new KhachHang();
	int soluongchon = 0;
	List<SanPham> listSp = new ArrayList<SanPham>();
	List<SanPham> gioHang = new ArrayList<SanPham>();
	private JLabel lblNewLabel_9;
	private JLabel lblNhanVien;
	private JButton btnChonSanPham;
	private JLabel lblMaKHChon;
	private JLabel lblTenKHChon;
	private JLabel lblTongTien;
	private JButton btnXoaSP;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmBanHang frame = new FrmBanHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	public void setSoLuongChon(int sl) {
		soluongchon = sl;
	}
//	public void themVaoGioHang(int i,int soluongthem) {
//		SanPham c = listSp.get(i);
//		SanPham b = new SanPham(c.getMasp(),c.getTensp(),c.getGia(),c.getSoluong(),c.getMota());
//		if(gioHang.isEmpty()) {
//			b.setSoluong(soluongthem);
//			gioHang.add(b);
//		}else {
//			for (SanPham sanPham : gioHang) {
//				if(sanPham.getMasp().equals(b.getMasp())) {
//					int sum = sanPham.getSoluong() +  soluongthem;
//					if(sum <= c.getSoluong()) {
//						sanPham.setSoluong(sum);
//					}else {
//						JOptionPane.showMessageDialog(null,"Số lượng vượt quá số lượng còn lại!");
//					}
//				}else {
//					SanPham f = new SanPham(c.getMasp(),c.getTensp(),c.getGia(),c.getSoluong(),c.getMota());
//					f.setSoluong(soluongthem);
//					gioHang.add(f);
//				}
//			}
//		}
//		hienThiGioHang();
//	}
	
	public void themVaoGioHang(int i, int soluongthem) {
        SanPham c = listSp.get(i);
        SanPham b = new SanPham(c.getMasp(), c.getTensp(), c.getGia(), c.getSoluong(), c.getMota());
        if (gioHang.isEmpty()) {
            b.setSoluong(soluongthem);
            gioHang.add(b);
        } else {
            // Sử dụng Iterator để duyệt và thay đổi gioHang an toàn
            Iterator<SanPham> iterator = gioHang.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                SanPham sanPham = iterator.next();
                if (sanPham.getMasp().equals(b.getMasp())) {
                    int sum = sanPham.getSoluong() + soluongthem;
                    if (sum <= c.getSoluong()) {
                        sanPham.setSoluong(sum);
                    } else {
                        JOptionPane.showMessageDialog(null, "Số lượng vượt quá số lượng còn lại!");
                    }
                    found = true;
                }
            }
            // Nếu không tìm thấy sản phẩm trong gioHang, thêm sản phẩm mới
            if (!found) {
                SanPham f = new SanPham(c.getMasp(), c.getTensp(), c.getGia(), c.getSoluong(), c.getMota());
                f.setSoluong(soluongthem);
                gioHang.add(f);
            }
        }
        hienThiGioHang();
    }
	
	public void hienthiSanPham() {
		modelSanPham.setRowCount(0);
		listSp = sanPhamDAO.findAll();
		for(SanPham a : listSp) {
			Object[] ob = {a.getMasp(),a.getTensp(),a.getGia(),a.getSoluong(),a.getMota()};
			modelSanPham.addRow(ob);
		}
	}
	public void hienThiGioHang() {
		modelGioHang.setRowCount(0);
		for(SanPham a : gioHang) {
			float tien = a.getGia() * a.getSoluong();
			Object[] ob = {a.getTensp(),a.getGia(),a.getSoluong(),tien};
			modelGioHang.addRow(ob);
		}
	}
	
	public void setNhanVienPhuTrach(NhanVien a) {
		lblNhanVien.setText(a.getHoTen());
	}
	public void HienThiKhachHangDuocChon() {
		lblMaKHChon.setText(khchon.getMakh());
		lblTenKHChon.setText(khchon.getTenkh());
	}
	public void reloadFrame() {
		JOptionPane.showMessageDialog(null, khchon.getTenkh());
		HienThiKhachHangDuocChon();
		this.revalidate();
		this.repaint();
	}

	/**
	 * Create the frame.
	 */
	public FrmBanHang(NhanVien nvDn) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 924, 742);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Hóa đơn chờ");
		lblNewLabel.setBounds(12, 13, 110, 16);
		getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(12, 35, 503, 120);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tableHoaDonCho = new JTable();
		scrollPane.setViewportView(tableHoaDonCho);
		
		lblNewLabel_1 = new JLabel("Đơn hàng");
		lblNewLabel_1.setBounds(530, 13, 85, 16);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Giỏ hàng");
		lblNewLabel_2.setBounds(12, 168, 56, 16);
		getContentPane().add(lblNewLabel_2);
		
		panel_1 = new JPanel();
		panel_1.setBounds(12, 197, 503, 120);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		panel_1.add(scrollPane_2, BorderLayout.CENTER);
		
		tableGioHang = new JTable();
		scrollPane_2.setViewportView(tableGioHang);
		
		lblNewLabel_3 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_3.setBounds(12, 348, 146, 16);
		getContentPane().add(lblNewLabel_3);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(12, 377, 884, 316);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_8 = new JLabel("Tìm kiếm sản phẩm");
		lblNewLabel_8.setBounds(12, 13, 169, 16);
		panel_2.add(lblNewLabel_8);
		
		textTimKiemSanPham = new JTextField();
		textTimKiemSanPham.setBounds(153, 5, 338, 32);
		panel_2.add(textTimKiemSanPham);
		textTimKiemSanPham.setColumns(10);
		
		btnTimKiemSanPham = new JButton("Tìm");
		btnTimKiemSanPham.setBounds(524, 9, 97, 25);
		panel_2.add(btnTimKiemSanPham);
		
		panel_4 = new JPanel();
		panel_4.setBounds(12, 54, 860, 249);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, BorderLayout.CENTER);
		
		tableSanPham = new JTable();
		tableSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane_1.setViewportView(tableSanPham);
		
		btnChonSanPham = new JButton("Chọn SP");
		btnChonSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableSanPham.getSelectedRow();
				if(index > -1) {
					SanPham b = listSp.get(index);
					FrmChonSoLuong frmChonSL = new FrmChonSoLuong(FrmBanHang.this, b.getSoluong(),index);
					frmChonSL.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Chua chon san pham");
				}
			}
		});
		btnChonSanPham.setBounds(737, 12, 97, 25);
		panel_2.add(btnChonSanPham);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(527, 35, 369, 326);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Mã khách hàng:");
		lblNewLabel_4.setBounds(12, 13, 117, 16);
		panel_3.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Tên khách hàng:");
		lblNewLabel_5.setBounds(12, 52, 117, 16);
		panel_3.add(lblNewLabel_5);
		
		btnChonKhachHang = new JButton("Chọn");
		btnChonKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmChonKhachHang frmKH = new FrmChonKhachHang(FrmBanHang.this,khchon);
				frmKH.setVisible(true);
			}
		});
		btnChonKhachHang.setBounds(249, 77, 97, 25);
		panel_3.add(btnChonKhachHang);
		
		lblNewLabel_6 = new JLabel("Mã hóa đơn:");
		lblNewLabel_6.setBounds(12, 119, 97, 16);
		panel_3.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Tổng tiền:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(12, 208, 97, 16);
		panel_3.add(lblNewLabel_7);
		
		btnHuyHoaDon = new JButton("Hủy hóa đơn");
		btnHuyHoaDon.setBounds(127, 295, 117, 25);
		panel_3.add(btnHuyHoaDon);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnThanhToan.setBounds(12, 230, 345, 58);
		panel_3.add(btnThanhToan);
		
		btnTaoHoaDon = new JButton("Tạo");
		btnTaoHoaDon.setBounds(249, 122, 97, 25);
		panel_3.add(btnTaoHoaDon);
		
		textMaHoaDon = new JTextField();
		textMaHoaDon.setBounds(92, 116, 145, 31);
		panel_3.add(textMaHoaDon);
		textMaHoaDon.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Nhân viên phu trách:");
		lblNewLabel_9.setBounds(12, 172, 139, 16);
		panel_3.add(lblNewLabel_9);
		
		lblNhanVien = new JLabel("");
		lblNhanVien.setBounds(143, 168, 182, 25);
		panel_3.add(lblNhanVien);
		
		lblMaKHChon = new JLabel("");
		lblMaKHChon.setBounds(114, 13, 165, 16);
		panel_3.add(lblMaKHChon);
		
		lblTenKHChon = new JLabel("");
		lblTenKHChon.setBounds(114, 52, 165, 16);
		panel_3.add(lblTenKHChon);
		
		lblTongTien = new JLabel("");
		lblTongTien.setBounds(111, 209, 190, 16);
		panel_3.add(lblTongTien);
		
		
		// CODE
		setNhanVienPhuTrach(nvDn);
		tableSanPham.setModel(modelSanPham);
		modelSanPham.addColumn("Mã sản phẩm");
		modelSanPham.addColumn("Tên sản phẩm");
		modelSanPham.addColumn("Giá");
		modelSanPham.addColumn("Số lượng");
		modelSanPham.addColumn("Mô tả");
		
		tableGioHang.setModel(modelGioHang);
		
		btnXoaSP = new JButton("Xóa SP");
		btnXoaSP.setBounds(418, 164, 97, 25);
		getContentPane().add(btnXoaSP);
		modelGioHang.addColumn("Tên Sp");
		modelGioHang.addColumn("Đơn giá");
		modelGioHang.addColumn("Số lượng");
		modelGioHang.addColumn("Thành tiền");
		
		hienthiSanPham();
		

	}
}
