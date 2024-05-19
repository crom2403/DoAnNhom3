package model;

public class ChiTietHoaDon {
	private int macthd;
	private String mahd;
	private String masp;
	private String tensp;
	private int soluong;
	private float dongia;
	private float thanhtien;
	public ChiTietHoaDon(int macthd, String mahd, String masp, String tensp, int soluong, float dongia,
			float thanhtien) {
		super();
		this.macthd = macthd;
		this.mahd = mahd;
		this.masp = masp;
		this.tensp = tensp;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}
	public ChiTietHoaDon() {
		super();
	}
	public int getMacthd() {
		return macthd;
	}
	public void setMacthd(int macthd) {
		this.macthd = macthd;
	}
	public String getMahd() {
		return mahd;
	}
	public void setMahd(String mahd) {
		this.mahd = mahd;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
	public float getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(float thanhtien) {
		this.thanhtien = thanhtien;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [macthd=" + macthd + ", mahd=" + mahd + ", masp=" + masp + ", tensp=" + tensp
				+ ", soluong=" + soluong + ", dongia=" + dongia + ", thanhtien=" + thanhtien + "]";
	}

}
