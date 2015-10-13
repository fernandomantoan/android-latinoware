package com.fernandomantoan.latinoware.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fernandomantoan.latinoware.R;
import com.fernandomantoan.latinoware.fragment.CoursesFragment;
import com.fernandomantoan.latinoware.fragment.MyGridFragment;
import com.fernandomantoan.latinoware.fragment.SpeechsFragment;

public class FixedTabsPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int mSelected = 0;

    public FixedTabsPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SpeechsFragment();
            case 1:
                return new MyGridFragment();
            case 2:
                return new CoursesFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.palestras);
            case 1:
                return mContext.getString(R.string.minha_grade);
            case 2:
                return mContext.getString(R.string.cursos);
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(Object object) {
        if ((mSelected == 0 && object instanceof MyGridFragment) ||
                (mSelected == 1 && object instanceof SpeechsFragment)) {
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    public void setSelected(int selected) {
        mSelected = selected;
    }
}
