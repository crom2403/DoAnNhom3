package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.SanPham;
import util.ConnectToolKit;

public class SanPhamDAO {
	public List<SanPham> findAll(){
		List<SanPham> list = new ArrayList<SanPham>();
		Connection con = ConnectToolKit.getConnect();
		String sql = "select * from sanpham";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("masp");
				String ten = rs.getString("tensp");
				float gia = rs.getFloat("gia");
				int sl = rs.getInt("soluong");
				String mota = rs.getString("mota");
				
				
				SanPham a = new SanPham(ma,ten,gia,sl,mota);
				list.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean them(SanPham a){
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "insert into sanpham(masp,tensp,gia,soluong,mota) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getMasp());
			ps.setString(2, a.getTensp());
			ps.setFloat(3, a.getGia());
			ps.setInt(4, a.getSoluong());
			ps.setString(5, a.getMota());
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
	public boolean Xoa(SanPham a) {
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "delete from sanpham where masp=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getMasp());
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
	public boolean Sua(SanPham a) {
		boolean flag = false;
		Connection con = ConnectToolKit.getConnect();
		String sql = "update sanpham set tensp=?, gia=?, soluong=?, mota=? where masp=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getTensp());
			ps.setFloat(2, a.getGia());
			ps.setInt(3, a.getSoluong());
			ps.setString(4, a.getMota());
			ps.setString(5, a.getMasp());
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
