package model;

public class SanPham {
	private String masp;
	private String tensp;
	private float gia;
	private int soluong;
	private String mota;
	public SanPham(String masp, String tensp, float gia, int soluong, String mota) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.soluong = soluong;
		this.mota = mota;
	}
	public SanPham() {
		super();
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
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	@Override
	public String toString() {
		return "SanPham [masp=" + masp + ", tensp=" + tensp + ", gia=" + gia + ", soluong=" + soluong + ", mota=" + mota
				+ "]";
	}
	
}
