package l2bb.l2beatbox2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BeatAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    BeatDatabase bd = BeatDatabase.getInstance();

    @Override
    public int getCount() {
        return bd.getCount();
    }
    @Override
    public Object getItem(int i) {
        return bd.getBeat(i);
    }
    @Override
    public long getItemId(int i) { return i; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (convertView == null) {
            if (inflater == null)
                inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.beat_list, parent, false);
        }
        setName(position, row);
        return row;
    }

    public void setName(int position, View v){
        if (bd.getCount() > 0) {
            TextView name = (TextView) v.findViewById(R.id.text1);
            Beat beat = bd.getBeat(position + 1);
            name.setText(beat.getName());
        }
    }
}
