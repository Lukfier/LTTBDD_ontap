package com.nguyenvietnam.ded17.model;

public class SinhVienLop {
    private int id;
    private SinhVien sv;
    private Lop lop;
    private String kyhoc;
    private int soTinChi;

    public SinhVienLop() {
    }

    public SinhVienLop(int id, SinhVien sv, Lop lop, String kyhoc, int soTinChi) {
        this.sv = sv;
        this.lop = lop;
        this.kyhoc = kyhoc;
        this.soTinChi = soTinChi;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
