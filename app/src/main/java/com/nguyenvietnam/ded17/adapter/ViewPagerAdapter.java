package com.nguyenvietnam.ded17.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nguyenvietnam.ded17.fragment.LopFragment;
import com.nguyenvietnam.ded17.fragment.SinhVienFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int pageNum;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNum = 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new SinhVienFragment();
            case 1: return new LopFragment();
            default: return new SinhVienFragment();
        }
    }

    @Override
    public int getCount() {
        return pageNum;
    }
}
