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
import com.nguyenvietnam.ded17.adapter.LopAdapter;
import com.nguyenvietnam.ded17.database.DatabaseHelper;
import com.nguyenvietnam.ded17.model.Lop;
import com.nguyenvietnam.ded17.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class LopFragment extends Fragment {
    ListView listView;
    LopAdapter adapterLop;
    List<Lop> listLop;
    EditText tenLop, moTa;
    Button themLop;
    Spinner thongKe;
    public LopFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lop, container, false);
        tenLop = view.findViewById(R.id.edtTenLop);
        moTa = view.findViewById(R.id.edtMoTa);
        themLop = view.findViewById(R.id.btnThemLop);
        thongKe = view.findViewById(R.id.spThongKeLop);
        listView = view.findViewById(R.id.lvLop);

        String[] dsThongKe = {"Theo thời gian thêm", "Theo sĩ số giảm"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dsThongKe);
        thongKe.setAdapter(adapter);

        DatabaseHelper db = new DatabaseHelper(getActivity());
        listLop = db.getAllLop();

        adapterLop = new LopAdapter(getActivity(), listLop);
        listView.setAdapter(adapterLop);

        themLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lop lop = new Lop();
                lop.setTenLop(tenLop.getText().toString());
                lop.setMota(moTa.getText().toString());

                db.addLop(lop);
                getData();
                Toast.makeText(getActivity(), "Them lop thanh cong", Toast.LENGTH_SHORT).show();
            }

            private void getData() {
                listLop = db.getAllLop();

                adapterLop = new LopAdapter(getActivity(), listLop);
                listView.setAdapter(adapterLop);
            }
        });

        thongKe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    listLop = db.getAllLop();

                    adapterLop = new LopAdapter(getActivity(), listLop);
                    listView.setAdapter(adapterLop);
                }else if (position == 1) {
                    listLop = db.getAllLopSiSoGiam();

                    adapterLop = new LopAdapter(getActivity(), listLop);
                    listView.setAdapter(adapterLop);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        DatabaseHelper db = new DatabaseHelper(getActivity());
        listLop = db.getAllLop();

        adapterLop = new LopAdapter(getActivity(), listLop);
        listView.setAdapter(adapterLop);
    }
}