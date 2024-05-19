package dao;

import java.util.*;
import java.util.Date;

import model.NhanVien;
import util.ConnectToolKit;

import java.sql.*;
public class NhanVienDAO {
	
	public List<NhanVien> findAll(){
		List<NhanVien> list = new ArrayList<NhanVien>();
		Connection con = ConnectToolKit.getConnect();
		String sql = "select * from nhanvien";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("manv");
				String ten = rs.getString("hoten");
				String mk = rs.getString("matkhau");
				String gioitinh = rs.getString("gioitinh");
				Date ngaysinh = rs.getDate("ngaysinh");
				String sdt = rs.getString("sdt");
				String diachi = rs.getString("diachi");
				String vaitro = rs.getString("vaitro");
				NhanVien a = new NhanVien(ma,ten,mk,gioitinh,ngaysinh,sdt,diachi,vaitro);
				list.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean them(NhanVien a){
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "insert into nhanvien(manv,hoten,matkhau,gioitinh,ngaysinh,sdt,diachi,vaitro) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getManv());
			ps.setString(2, a.getHoTen());
			ps.setString(3, a.getMatKhau());
			ps.setString(4, a.getGioiTinh());
			ps.setDate(5, new java.sql.Date(a.getNgaySinh().getTime()));
			ps.setString(6, a.getSdt());
			ps.setString(7, a.getDiaChi());
			ps.setString(8, a.getVaiTro());
			int rs = ps.executeUpdate();
			if(rs > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean Xoa(NhanVien a) {
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "delete from nhanvien where manv=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getManv());
			int i = ps.executeUpdate();
			if(i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean Sua(NhanVien a) {
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "update nhanvien set hoten=?, matkhau=?, gioitinh=?, ngaysinh=?, sdt=?, diachi=?, vaitro=? where manv=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getHoTen());
			ps.setString(2, a.getMatKhau());
			ps.setString(3, a.getGioiTinh());
			ps.setDate(4, new java.sql.Date(a.getNgaySinh().getTime()));
			ps.setString(5, a.getSdt());
			ps.setString(6, a.getDiaChi());
			ps.setString(7, a.getVaiTro());
			ps.setString(8, a.getManv());
			int i = ps.executeUpdate();
			if(i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public NhanVien findById(String manv) {
		Connection con = ConnectToolKit.getConnect();
		String sql = "select * from nhanvien where manv=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,manv);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("manv");
				String ten = rs.getString("hoten");
				String mk = rs.getString("matkhau");
				String gioitinh = rs.getString("gioitinh");
				Date ngaysinh = rs.getDate("ngaysinh");
				String sdt = rs.getString("sdt");
				String diachi = rs.getString("diachi");
				String vaitro = rs.getString("vaitro");
				NhanVien a = new NhanVien(ma,ten,mk,gioitinh,ngaysinh,sdt,diachi,vaitro);
				return a;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
