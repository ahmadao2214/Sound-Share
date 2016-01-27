package l2bb.l2beatbox2;

import android.support.v4.app.ListFragment;
import android.content.Context;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;

/**
 * Created by OZ on 12/24/2015.
 */

/**
 * A placeholder fragment containing a simple view.
 */
public class SelectSoundFragment extends ListFragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    VisualizerView mVisualizerView;
    MediaPlayer mp;
    BeatDatabase bd = BeatDatabase.getInstance(null);

    public SelectSoundFragment()
    {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment newInstance(int sectionNumber) {
        SelectSoundFragment fragment = new SelectSoundFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private void addLineRenderer(){
        Paint linePaint = new Paint();
        linePaint.setStrokeWidth(7f);
        linePaint.setAntiAlias(true);
        linePaint.setColor(getResources().getColor(R.color.colorPrimary));

        LineRenderer lineRenderer = new LineRenderer(linePaint);

        mVisualizerView.addRenderer(lineRenderer);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_select_sound, container, false);

        setListAdapter(new BeatAdapter());

        mp = new MediaPlayer();

        mVisualizerView = (VisualizerView) rootView.findViewById(R.id.visualizerView);
        addLineRenderer();

        mVisualizerView.link(mp);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        playRecording(v, bd.getBeat(position).getPath());
    }

    private void playRecording(View v, String path) {
        try {
            mp.setDataSource(path);
            mp.prepare();
        } catch(IOException e){
            e.printStackTrace();
        }

        mp.start();

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                mp.stop();
                mp.reset();

                mVisualizerView.setEnabled(false);
            }
        });
    }

    class BeatAdapter extends BaseAdapter {
            private LayoutInflater inflater;
            BeatDatabase bd = BeatDatabase.getInstance(null);

            @Override
            public int getCount() {
                return bd.getCount();
            }

            @Override
            public Object getItem(int i) {
                return bd.getBeat(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row = convertView;
                if (convertView == null) {
                    if (inflater == null)
                        inflater = (LayoutInflater) SelectSoundFragment.this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    row = inflater.inflate(R.layout.beat_list, parent, false);
                }

                if (bd.getCount() > 0) {
                    TextView name = (TextView) row.findViewById(R.id.text1);
                    Beat beat = bd.getBeat(position + 1);
                    name.setText(beat.getName());
                }
                return row;
            }
        }
}
