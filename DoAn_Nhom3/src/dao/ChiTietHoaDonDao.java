package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.ChiTietHoaDon;
import util.ConnectToolKit;

public class ChiTietHoaDonDao {
	public List<ChiTietHoaDon> getListCTHoaDon(){
		List<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
		String sql = "select * from chitiethoadon";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ChiTietHoaDon cthd = new ChiTietHoaDon();
				cthd.setMacthd(rs.getInt("macthd"));
				cthd.setMahd(rs.getString("mahd"));
				cthd.setMasp(rs.getString("masp"));
				cthd.setTensp(rs.getString("tensp"));
				cthd.setSoluong(rs.getInt("soluong"));
				cthd.setDongia(rs.getFloat("dongia"));
				cthd.setThanhtien(rs.getFloat("thanhtien"));
				dscthd.add(cthd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dscthd;
	}
	
	public boolean addCTHoaDon(ChiTietHoaDon cthd) {
		boolean flag = false;
		String sql = "insert into chitiethoadon(mahd,masp,tensp,soluong,dongia,thanhtien) values(?,?,?,?,?,?)";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, cthd.getMahd());
			ps.setString(2, cthd.getMasp());
			ps.setString(3, cthd.getTensp());
			ps.setInt(4, cthd.getSoluong());
			ps.setFloat(5, cthd.getDongia());
			ps.setFloat(6, cthd.getThanhtien());
			int i = ps.executeUpdate();
			if(i>0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int ma = rs.getInt(1);
					cthd.setMacthd(ma);
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean deleteCTHoaDon(int macthd) {
		boolean flag=false;
		String sql = "delete from chitiethoadon where macthd=?";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, macthd);
			int i = ps.executeUpdate();
			if(i>0)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateCTHoaDon(ChiTietHoaDon cthd) {
		boolean flag = false;
		String sql = "update chitiethoadon set mahd=?,masp=?,tensp=?,soluong=?,dongia=?,thanhtien=? where macthd=?";
		Connection con = ConnectToolKit.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cthd.getMahd());
			ps.setString(2, cthd.getMasp());
			ps.setString(3, cthd.getTensp());
			ps.setInt(4, cthd.getSoluong());
			ps.setFloat(5, cthd.getDongia());
			ps.setFloat(6, cthd.getThanhtien());
			ps.setInt(7, cthd.getMacthd());
			int i = ps.executeUpdate();
			if(i>0)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}

