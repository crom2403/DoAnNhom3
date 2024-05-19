package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

import model.HoaDon;
import util.ConnectToolKit;

public class HoaDonDAO {
	public List<HoaDon> getListHoaDon(){
		List<HoaDon> dshd = new ArrayList<HoaDon>();
		String sql = "select * from hoadon";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HoaDon hd = new HoaDon();
				hd.setMahd(rs.getString("mahd"));
				hd.setNgayXuat(rs.getDate("ngayxuat"));
				hd.setPttt(rs.getString("pttt"));
				hd.setTongtien(rs.getFloat("tongtien"));
				hd.setManv(rs.getString("manv"));
				hd.setTennv(rs.getString("tennv"));
				hd.setMakh(rs.getString("makh"));
				hd.setTenkh(rs.getString("tenkh"));
				dshd.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dshd;
	}
	
	public boolean addHoaDon(HoaDon hd) {
		boolean flag = false;
		String sql = "insert into hoadon values(?,?,?,?,?,?,?,?)";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hd.getMahd());
			ps.setDate(2, new java.sql.Date(hd.getNgayXuat().getTime()));
			ps.setString(3, hd.getPttt());
			ps.setFloat(4, hd.getTongtien());
			ps.setString(5, hd.getManv());
			ps.setNString(6, hd.getTennv());
			ps.setString(7, hd.getMakh());
			ps.setString(8, hd.getTenkh());
			int i = ps.executeUpdate();
			if(i>0)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean deleteHoaDon(String ma) {
		boolean flag = false;
		String sql = "delete from hoadon where mahd = ?";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ma);
			int i = ps.executeUpdate();
			if(i>0)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateHoaDon(HoaDon hd) {
		boolean flag = false;
		String sql = "update hoadon set ngayxuat=?, pttt=?, tongtien=? where mahd=?";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(hd.getNgayXuat().getTime()));
			ps.setString(2, hd.getPttt());
			ps.setFloat(3, hd.getTongtien());
			int i = ps.executeUpdate();
			if(i>0) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
