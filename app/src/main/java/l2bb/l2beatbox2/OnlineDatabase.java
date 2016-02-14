package l2bb.l2beatbox2;

import com.firebase.client.Firebase;

import android.content.Context;

/**
 * Created by augustk on 2/14/2016.
 */
public class OnlineDatabase {

    private static OnlineDatabase instance = null;
    private Firebase myFirebaseRef = null;

    private OnlineDatabase(Context context)
    {
        super();

        Firebase.setAndroidContext(context);
        myFirebaseRef = new Firebase("https://dazzling-heat-6818.firebaseio.com/");
    }

    public static OnlineDatabase getInstance()
    {
        if (instance == null)
            throw new NullPointerException("Wrong getInstance was called before providing a context.");

        return instance;
    }

    public static OnlineDatabase getInstance(Context context)
    {
        if (instance == null)
            instance = new OnlineDatabase(context);

        return instance;
    }

    public void write()
    {
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
    }

}
