package model;

import java.sql.Date;

public class HoaDon {
	private String mahd;
	private Date ngayXuat;
	private String pttt;
	private float tongtien;
	private String manv;
	private String tennv;
	private String makh;
	private String tenkh;
	public HoaDon(String mahd, Date ngayXuat, String pttt, float tongtien, String manv, String tennv, String makh,
			String tenkh) {
		super();
		this.mahd = mahd;
		this.ngayXuat = ngayXuat;
		this.pttt = pttt;
		this.tongtien = tongtien;
		this.manv = manv;
		this.tennv = tennv;
		this.makh = makh;
		this.tenkh = tenkh;
	}
	public HoaDon() {
		super();
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public Date getNgayXuat() {
		return ngayXuat;
	}
	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
	public String getPttt() {
		return pttt;
	}
	public void setPttt(String pttt) {
		this.pttt = pttt;
	}
	public float getTongtien() {
		return tongtien;
	}
	public void setTongtien(float tongtien) {
		this.tongtien = tongtien;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	@Override
	public String toString() {
		return "HoaDon [mahd=" + mahd + ", ngayXuat=" + ngayXuat + ", pttt=" + pttt + ", tongtien=" + tongtien
				+ ", manv=" + manv + ", tennv=" + tennv + ", makh=" + makh + ", tenkh=" + tenkh + "]";
	}

}
