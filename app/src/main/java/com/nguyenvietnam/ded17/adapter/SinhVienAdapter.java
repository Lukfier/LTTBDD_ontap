package com.nguyenvietnam.ded17.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.nguyenvietnam.ded17.R;
import com.nguyenvietnam.ded17.model.Lop;
import com.nguyenvietnam.ded17.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private List<SinhVien> listSinhVien;

    public SinhVienAdapter(Context context, List<SinhVien> listSinhVien) {
        this.context = context;
        this.listSinhVien = listSinhVien;
    }

    @Override
    public int getCount() {
        return listSinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return listSinhVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sinhvien, null, true);
        TextView ma, ten, namSinh, queQuan, namHoc;
        ten = view.findViewById(R.id.item_tenSV);
        namSinh = view.findViewById(R.id.item_namsinh);
        queQuan = view.findViewById(R.id.item_quequan);
        namHoc = view.findViewById(R.id.item_namhoc);
        ma =view.findViewById(R.id.item_maSV);

        ten.setText(listSinhVien.get(position).getTenSV());
        namHoc.setText(listSinhVien.get(position).getNamHoc());
        namSinh.setText(listSinhVien.get(position).getNamSinh());
        queQuan.setText(listSinhVien.get(position).getQueQuan());
        ma.setText(listSinhVien.get(position).getMaSV()+"");


        return view;
    }
}
