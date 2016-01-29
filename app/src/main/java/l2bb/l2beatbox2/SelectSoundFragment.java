package l2bb.l2beatbox2;

import android.support.v4.app.ListFragment;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.io.IOException;

/**
 * Created by OZ on 12/24/2015.
 */

public class SelectSoundFragment extends ListFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    VisualizerView mVisualizerView;
    MediaPlayer mp;
    BeatDatabase bd = BeatDatabase.getInstance(null);
    SwipeRefreshLayout mySwipeRefreshLayout;

    public static BeatAdapter beatAdapter;

    public SelectSoundFragment()
    {

    }

    public static Fragment newInstance(int sectionNumber) {
        SelectSoundFragment fragment = new SelectSoundFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_select_sound, container, false);

        beatAdapter = new BeatAdapter();
        setListAdapter(beatAdapter);

        mySwipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swiperefresh);
        mp = new MediaPlayer();
        mVisualizerView = (VisualizerView) rootView.findViewById(R.id.visualizerView);
        addLineRenderer();
        mVisualizerView.link(mp);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        myUpdateOperation();
                    }
                }
        );
        return rootView;
    }

    private void myUpdateOperation(){
        //noinspection ResourceType
        SelectSoundFragment f = (SelectSoundFragment)getActivity().getSupportFragmentManager().findFragmentById(R.layout.fragment_select_sound);
        f.beatAdapter.notifyDataSetChanged();
    }

    private void addLineRenderer(){
        LineRenderer lineRenderer = new LineRenderer(setupPaint());
        mVisualizerView.addRenderer(lineRenderer);
    }

    private Paint setupPaint(){
        Paint linePaint =  new Paint();
        linePaint.setStrokeWidth(7f);
        linePaint.setAntiAlias(true);
        linePaint.setColor(getResources().getColor(R.color.colorPrimary));
        return linePaint;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        playRecording(v, bd.getBeat(position).getPath());
    }

    private void playRecording(View v, String path) {
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
        } catch(IOException e){
            e.printStackTrace();
        }
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                mp.stop();
                mp.reset();
                mVisualizerView.setEnabled(false);
            }
        });
    }
}