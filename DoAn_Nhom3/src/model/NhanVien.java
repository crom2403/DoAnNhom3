package model;

import java.util.Date;

public class NhanVien {
	private String manv;
	private String hoTen;
	private String matKhau;
	private String gioiTinh;
	private Date ngaySinh;
	private String sdt;
	private String diaChi;
	private String vaiTro;
	public NhanVien(String manv, String hoTen, String matKhau, String gioiTinh, Date ngaySinh, String sdt,
			String diaChi, String vaiTro) {
		super();
		this.manv = manv;
		this.hoTen = hoTen;
		this.matKhau = matKhau;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.vaiTro = vaiTro;
	}
	public NhanVien() {
		super();
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	@Override
	public String toString() {
		return "NhanVien [manv=" + manv + ", hoTen=" + hoTen + ", matKhau=" + matKhau + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + ", diaChi=" + diaChi + ", vaiTro=" + vaiTro + "]";
	}
	
	
	
}
