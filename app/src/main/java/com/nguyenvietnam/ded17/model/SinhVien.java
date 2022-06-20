package com.nguyenvietnam.ded17.model;

public class SinhVien {
    private int maSV;
    private String tenSV;
    private String namSinh;
    private String queQuan;
    private String namHoc;

    public SinhVien() {
    }

    public SinhVien(int ma, String tenSV, String namSinh, String queQuan, String namHoc) {
        this.maSV = ma;
        this.tenSV = tenSV;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }
}
