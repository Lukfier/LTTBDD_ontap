package com.nguyenvietnam.ded17.model;

public class Lop {
    private int maLop;
    private String tenLop;
    private String mota;
    private int siSo;

    public Lop() {
    }

    public Lop(int ma, String tenLop, String mota, int siSo) {
        this.maLop = ma;
        this.tenLop = tenLop;
        this.mota = mota;
        this.siSo = siSo;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
