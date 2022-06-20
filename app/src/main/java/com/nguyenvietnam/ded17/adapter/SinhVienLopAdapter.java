package com.nguyenvietnam.ded17.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nguyenvietnam.ded17.R;
import com.nguyenvietnam.ded17.model.SinhVienLop;

import java.util.List;

public class SinhVienLopAdapter extends BaseAdapter {
    private Context context;
    private List<SinhVienLop> listSinhVienLop;

    public SinhVienLopAdapter(Context context, List<SinhVienLop> listSinhVienLop) {
        this.context = context;
        this.listSinhVienLop = listSinhVienLop;
    }

    @Override
    public int getCount() {
        return listSinhVienLop.size();
    }

    @Override
    public Object getItem(int position) {
        return listSinhVienLop.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sinhvienlop, null, true);
        TextView ma, ten, namSinh, queQuan, namHoc, kyHoc, soTinChi;
        ten = view.findViewById(R.id.item_svl_ten);
        namSinh = view.findViewById(R.id.item_svl_namsinh);
        queQuan = view.findViewById(R.id.item_svl_quequan);
        namHoc = view.findViewById(R.id.item_svl_namhoc);
        ma =view.findViewById(R.id.item_svl_maSV);
        kyHoc =view.findViewById(R.id.item_svl_kyhoc);
        soTinChi = view.findViewById(R.id.item_svl_sotinchi);

        ten.setText(listSinhVienLop.get(position).getSv().getTenSV());
        namHoc.setText(listSinhVienLop.get(position).getSv().getNamHoc());
        namSinh.setText(listSinhVienLop.get(position).getSv().getNamSinh());
        queQuan.setText(listSinhVienLop.get(position).getSv().getQueQuan());
        ma.setText(listSinhVienLop.get(position).getSv().getMaSV()+"");
        kyHoc.setText(listSinhVienLop.get(position).getKyhoc());
        soTinChi.setText(listSinhVienLop.get(position).getSoTinChi()+"");
        return view;
    }
}
