package com.nguyenvietnam.ded17.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.nguyenvietnam.ded17.R;
import com.nguyenvietnam.ded17.adapter.SinhVienAdapter;
import com.nguyenvietnam.ded17.database.DatabaseHelper;
import com.nguyenvietnam.ded17.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienFragment extends Fragment {
    EditText ten, namSinh, queQuan;
    Button themSinhVien;
    Spinner namHoc, thongKe;
    ListView listView;
    SinhVienAdapter adapterSV;
    List<SinhVien> lsSinhVien;

    public SinhVienFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sinh_vien, container, false);
        ten = view.findViewById(R.id.edtTenSinhVien);
        namSinh = view.findViewById(R.id.edtNamSinh);
        queQuan = view.findViewById(R.id.edtQueQuan);
        themSinhVien = view.findViewById(R.id.btnThemSinhVien);
        namHoc = view.findViewById(R.id.spNamHoc);
        thongKe = view.findViewById(R.id.spThongKeSinhVien);
        listView = view.findViewById(R.id.lvSinhVien);

        String[] dsNamHoc = {"Năm nhất", "Năm hai", "Năm ba", "Năm bốn"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dsNamHoc);
        namHoc.setAdapter(adapter);

        String[] dsThongKe = {"Tất cả sinh viên", "Tên Nam và học năm hai"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dsThongKe);
        thongKe.setAdapter(adapter1);

        DatabaseHelper db = new DatabaseHelper(getActivity());
        lsSinhVien = db.getAllSinhVien();


        adapterSV = new SinhVienAdapter(getActivity(), lsSinhVien);
        listView.setAdapter(adapterSV);

        themSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv = new SinhVien();
                sv.setTenSV(ten.getText().toString());
                sv.setQueQuan(queQuan.getText().toString());
                sv.setNamHoc(namHoc.getSelectedItem().toString());
                sv.setNamSinh(namSinh.getText().toString());

                db.addSinhVien(sv);
                getData();
                Toast.makeText(getActivity(), "Them sinh vien thanh cong", Toast.LENGTH_SHORT).show();
            }

            private void getData() {
                lsSinhVien = db.getAllSinhVien();
                adapterSV = new SinhVienAdapter(getActivity(), lsSinhVien);
                listView.setAdapter(adapterSV);
            }
        });

        thongKe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    lsSinhVien = db.getAllSinhVien();
                    adapterSV = new SinhVienAdapter(getActivity(), lsSinhVien);
                    listView.setAdapter(adapterSV);
                }else if (position == 1) {
                    lsSinhVien = db.getAllSinhVienNam2();
                    adapterSV = new SinhVienAdapter(getActivity(), lsSinhVien);
                    listView.setAdapter(adapterSV);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}