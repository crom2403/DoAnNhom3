package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang;
import model.SanPham;
import util.ConnectToolKit;

public class KhachHangDAO {
	public List<KhachHang> findAll(){
		List<KhachHang> list = new ArrayList<KhachHang>();
		Connection con = ConnectToolKit.getConnect();
		String sql = "select * from khachhang";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("makh");
				String ten = rs.getString("tenkh");
				String dc = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				
				
				KhachHang a = new KhachHang(ma,ten,dc,sdt);
				list.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean them(KhachHang a){
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "insert into khachhang(makh,tenkh,diachi,sdt) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,a.getMakh());
			ps.setString(2, a.getTenkh());
			ps.setString(3, a.getDiachi());
			ps.setString(4, a.getSdt());
			int rs = ps.executeUpdate();
			if(rs > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return false;
		}
		return flag;
	}
	public boolean Xoa(KhachHang a) {
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "delete from khachhang where makh=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getMakh());
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
	public boolean Sua(KhachHang a) {
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "update khachhang set tenkh=?, diachi=?, sdt=? where makh=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getTenkh());
			ps.setString(2, a.getDiachi());
			ps.setString(3, a.getSdt());
			ps.setString(4,a.getMakh());
			int rs = ps.executeUpdate();
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
}
