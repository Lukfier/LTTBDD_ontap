package com.nguyenvietnam.ded17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.nguyenvietnam.ded17.adapter.SinhVienLopAdapter;
import com.nguyenvietnam.ded17.database.DatabaseHelper;
import com.nguyenvietnam.ded17.model.Lop;
import com.nguyenvietnam.ded17.model.SinhVien;
import com.nguyenvietnam.ded17.model.SinhVienLop;

import java.util.ArrayList;
import java.util.List;

public class SinhVienLopActivity extends AppCompatActivity {

    List<SinhVienLop> lsSinhVienLop;
    List<SinhVien> listSV;
    ListView listView;
    SinhVienLopAdapter adapterSVL;
    Spinner spMaSV;
    EditText kyHoc, soTinChi;
    Button themSVL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien_lop);
        
        spMaSV = findViewById(R.id.spDanhSachSinhVien);
        kyHoc = findViewById(R.id.edtKyhoc);
        soTinChi = findViewById(R.id.edtSoTinChi);
        listView = findViewById(R.id.lvSinhVienLop);
        themSVL = findViewById(R.id.btnThemSinhVienLop);

        int maLopInt = Integer.parseInt(getIntent().getStringExtra("maLop"));


        DatabaseHelper db = new DatabaseHelper(getBaseContext());
        listSV = db.getAllSinhVien();
        lsSinhVienLop = db.getAllSinhVienLop(maLopInt);
        for(int i = 0; i < lsSinhVienLop.size(); i++) {
            for(int j = 0; j < listSV.size(); j++) {
                if(listSV.get(j).getMaSV() == lsSinhVienLop.get(i).getSv().getMaSV()) {
                    listSV.remove(j);
                }
            }
        }
        String[] listMa = new String[listSV.size()];
        for(int i = 0; i < listSV.size(); i++) {
            listMa[i] = listSV.get(i).getMaSV()+"";
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(SinhVienLopActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listMa);
        spMaSV.setAdapter(adapter);
        spMaSV.setSelection(0);

        adapterSVL = new SinhVienLopAdapter(SinhVienLopActivity.this, lsSinhVienLop);
        listView.setAdapter(adapterSVL);

        themSVL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maSV = Integer.parseInt(spMaSV.getSelectedItem().toString());
                String kyHocStr = kyHoc.getText().toString();
                int soTinChiInt = Integer.parseInt(soTinChi.getText().toString());
                SinhVien sv = db.getSinhVienById(maSV);
                Lop lop = db.getLopById(maLopInt);
                SinhVienLop svl = new SinhVienLop();
                svl.setSv(sv);
                svl.setLop(lop);
                svl.setKyhoc(kyHocStr);
                svl.setSoTinChi(soTinChiInt);

                db.addSinhVienLop(svl);
                getData();
                Toast.makeText(SinhVienLopActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
            }

            public void getData() {
                listSV = db.getAllSinhVien();
                lsSinhVienLop = db.getAllSinhVienLop(maLopInt);
                for(int i = 0; i < lsSinhVienLop.size(); i++) {
                    for(int j = 0; j < listSV.size(); j++) {
                        if(listSV.get(j).getMaSV() == lsSinhVienLop.get(i).getSv().getMaSV()) {
                            listSV.remove(j);
                        }
                    }
                }
                String[] listMa = new String[listSV.size()];
                for(int i = 0; i < listSV.size(); i++) {
                    listMa[i] = listSV.get(i).getMaSV()+"";
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(SinhVienLopActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listMa);
                spMaSV.setAdapter(adapter);
                spMaSV.setSelection(0);

                adapterSVL = new SinhVienLopAdapter(SinhVienLopActivity.this, lsSinhVienLop);
                listView.setAdapter(adapterSVL);
            }
        });



    }


}