package com.nguyenvietnam.ded17.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.nguyenvietnam.ded17.R;
import com.nguyenvietnam.ded17.SinhVienLopActivity;
import com.nguyenvietnam.ded17.model.Lop;

import java.util.List;

public class LopAdapter extends BaseAdapter {
    private Context context;
    private List<Lop> listLop;

    public LopAdapter(Context context, List<Lop> listLop) {
        this.context = context;
        this.listLop = listLop;
    }

    @Override
    public int getCount() {
        return listLop.size();
    }

    @Override
    public Object getItem(int position) {
        return listLop.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lop, null, true);
        TextView maLop, tenLop, moTa, siSo;
        Button xemDS;
        tenLop = view.findViewById(R.id.item_tenlop);
        moTa = view.findViewById(R.id.item_mota);
        maLop = view.findViewById(R.id.item_malop);
        siSo = view.findViewById(R.id.item_siso);
        xemDS = view.findViewById(R.id.item_DS);

        maLop.setText(listLop.get(position).getMaLop()+"");
        tenLop.setText(listLop.get(position).getTenLop());
        moTa.setText(listLop.get(position).getMota());
        siSo.setText(listLop.get(position).getSiSo()+"");

        xemDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SinhVienLopActivity.class);
                intent.putExtra("maLop", maLop.getText().toString());
                context.startActivity(intent);
            }
        });

        return view;
    }
}
