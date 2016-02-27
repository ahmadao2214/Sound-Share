package l2bb.l2beatbox2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class CollabSoundFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    VisualizerView mVisualizerView;
    Button start, stop;
    MediaRecorder mRecorder;
    MediaPlayer mPlayer;
    String fileName, path;

    public CollabSoundFragment(){

    }

    public static CollabSoundFragment newInstance(int sectionNumber){
        CollabSoundFragment fragment = new CollabSoundFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_collab_sound, container, false);
        setupButtons(rootView);
        newMediaRecorder();

        path = (getNextFileName(rootView.getContext()).toString());
        mRecorder.setOutputFile(path);
        try {
            mRecorder.prepare();
        } catch(IOException e){
            e.printStackTrace();
        }
        setupVisualizer(rootView);

        return rootView;
    }

    private void setupButtons(View rootView){
        start = (Button) rootView.findViewById(R.id.button);
        stop = (Button) rootView.findViewById(R.id.button2);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecording(v);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording(v);
            }
        });
    }

    private void newMediaRecorder(){
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
    }

    private void setupVisualizer(View rootView){
        mPlayer = new MediaPlayer();
        mVisualizerView = (VisualizerView) rootView.findViewById(R.id.visualizerView);
        addLineRenderer();
        mVisualizerView.link(mPlayer);
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

    private void startRecording(View v) {
        mRecorder.start();
        //playRecording(v, );

        start.setEnabled(false);
        stop.setEnabled(true);
    }

    private void stopRecording(View v){
        mRecorder.stop();
        mRecorder.reset();
        mRecorder.release();

        stop.setEnabled(false);
    }

    private void playRecording(View v, String path) {
        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
            mPlayer.start();
        } catch(IOException e){
            e.printStackTrace();
        }
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.reset();
                mVisualizerView.setEnabled(false);
            }
        });
    }

    private File getNextFileName(Context c){
        fileName = "Audio_" + System.currentTimeMillis() + ".3gp";
        File file = new File(c.getFilesDir(), fileName);
        return file;
    }

}
