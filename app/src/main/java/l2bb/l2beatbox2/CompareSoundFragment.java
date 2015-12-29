package l2bb.l2beatbox2;

/**
 * Created by OZ on 12/28/2015.
 */

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import com.musicg.wave.*;
import com.musicg.fingerprint.FingerprintSimilarityComputer;

/**
 * A placeholder fragment containing a simple view.
 */
public class CompareSoundFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    TextView score;
    TextView similarity;

    public CompareSoundFragment(){

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */

    public static CompareSoundFragment newInstance(int sectionNumber){
        CompareSoundFragment fragment =  new CompareSoundFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_compare_sound, container, false);

        score = (TextView) rootView.findViewById(R.id.textView);
        similarity = (TextView) rootView.findViewById(R.id.textView2);

        AssetManager am = getResources().getAssets();

        Wave w1 = null;
        Wave w2 = null;

        try{
            w1 = new Wave(am.open("crash_7.wav"));
            w2 = new Wave(am.open("crash_2.wav"));
        } catch (IOException e){
            e.printStackTrace();
        }

        double s1 = new FingerprintSimilarityComputer(w1.getFingerprint(), w2.getFingerprint()).getFingerprintsSimilarity().getScore();
        double s2 = new FingerprintSimilarityComputer(w1.getFingerprint(), w2.getFingerprint()).getFingerprintsSimilarity().getSimilarity();

        score.setText("Score: " + s1);
        similarity.setText("Similarity: " + s2);

        return rootView;
    }
}
