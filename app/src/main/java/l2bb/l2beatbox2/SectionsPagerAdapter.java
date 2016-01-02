package l2bb.l2beatbox2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by OZ on 12/24/2015.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){

        switch(position){
            case 0:
                return SelectSoundFragment.newInstance(0);
            case 1:
                return RecordSoundFragment.newInstance(1);
        }

        return null;
    }

    @Override
    public int getCount() { return 2; }

    @Override
    public CharSequence getPageTitle(int position){
        switch(position){
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
        }

        return null;
    }
}
