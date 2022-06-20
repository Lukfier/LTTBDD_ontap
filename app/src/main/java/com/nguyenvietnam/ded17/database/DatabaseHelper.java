package com.nguyenvietnam.ded17.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.nguyenvietnam.ded17.model.Lop;
import com.nguyenvietnam.ded17.model.SinhVien;
import com.nguyenvietnam.ded17.model.SinhVienLop;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DBNAME = "QLSinhVien.db";
    private static final int DBVERSION=1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1="CREATE TABLE sinhvien(" +
                "maSV INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenSV TEXT, namSinh TEXT, queQuan TEXT, namHoc TEXT)";

        String sql2 = "CREATE TABLE lop(" +
                "maLop INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenLop TEXT, moTa TEXT)";

        String sql3 = "CREATE TABLE sinhvienlop(" +
                "ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                "maSV INTEGER, maLop INTEGER, kyHoc TEXT, soTinChi INTEGER)";
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String sql = "SELECT * FROM sinhvien";
        Cursor rs = st.rawQuery(sql, null);
        while(rs!=null && rs.moveToNext()) {
            int maSV = rs.getInt(0);
            String ten = rs.getString(1);
            String namSinh = rs.getString(2);
            String queQuan = rs.getString(3);
            String namHoc = rs.getString(4);
            list.add(new SinhVien(maSV, ten, namSinh, queQuan, namHoc));
        }
        return list;
    }

    public List<Lop> getAllLop() {
        List<Lop> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String sql = "SELECT * FROM lop";
        Cursor rs = st.rawQuery(sql, null);
        while(rs!=null && rs.moveToNext()) {
            int maLop = rs.getInt(0);
            String ten = rs.getString(1);
            String moTa = rs.getString(2);
            int siSo = getAllSinhVienLop(maLop).size();
            list.add(new Lop(maLop, ten, moTa, siSo));
        }
        return list;
    }

    public List<SinhVienLop> getAllSinhVienLop(int maLopD) {
        List<SinhVienLop> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String sql = "SELECT * FROM sinhvienlop WHERE maLop = ?";
        String[] selectionArgs = {maLopD+""};
        Cursor rs = st.rawQuery(sql, selectionArgs);
        while(rs!=null && rs.moveToNext()) {
            int ma = rs.getInt(0);
            int maSV = rs.getInt(1);
            int maLop = rs.getInt(2);
            String kyHoc = rs.getString(3);
            int soTinChi = rs.getInt(4);
            SinhVien sv = getSinhVienById(maSV);
            Lop lop = getLopById(maLop);
            list.add(new SinhVienLop(ma, sv, lop, kyHoc, soTinChi));
        }
        return list;
    }

    public SinhVien getSinhVienById(int id) {
        SQLiteDatabase st = getReadableDatabase();
        SinhVien sv = new SinhVien();
        String[] selectionArgs = {id+""};
        String sql = "SELECT * FROM sinhvien WHERE maSV = ?";
        Cursor rs = st.rawQuery(sql, selectionArgs);
        if(rs.moveToFirst()) {
            sv.setMaSV(rs.getInt(0));
            sv.setTenSV(rs.getString(1));
            sv.setNamSinh(rs.getString(2));
            sv.setQueQuan(rs.getString(3));
            sv.setNamHoc(rs.getString(4));
        }
        return sv;
    }

    public Lop getLopById(int id) {
        SQLiteDatabase st = getReadableDatabase();
        Lop lop = new Lop();
        String[] selectionArgs = {id+""};
        String sql = "SELECT * FROM lop WHERE maLop = ?";
        Cursor rs = st.rawQuery(sql, selectionArgs);
        if(rs.moveToFirst()) {
            lop.setMaLop(rs.getInt(0));
            lop.setTenLop(rs.getString(1));
            lop.setMota(rs.getString(2));
        }
        return lop;
    }

    public void addSinhVien(SinhVien sv) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO sinhvien (tenSV, namSinh, queQuan, namHoc) VALUES (?,?,?,?)";
        String[] selectionArgs = {sv.getTenSV(), sv.getNamSinh(), sv.getQueQuan(), sv.getNamHoc()};
        db.execSQL(sql, selectionArgs);
    }

    public void addLop(Lop lop) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO lop (tenLop, moTa) VALUES (?,?)";
        String[] selectionArgs = {lop.getTenLop(), lop.getMota()};
        db.execSQL(sql, selectionArgs);
    }

    public void addSinhVienLop(SinhVienLop svl) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO sinhvienlop (maSV, maLop, kyHoc, soTinChi) VALUES (?,?,?,?)";
        String[] selectionArgs = {svl.getSv().getMaSV() +"", svl.getLop().getMaLop()+"", svl.getKyhoc(), svl.getSoTinChi() + ""};
        db.execSQL(sql, selectionArgs);
    }
}
