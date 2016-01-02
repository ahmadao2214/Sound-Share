package l2bb.l2beatbox2;

/**
 * Created by OZ on 12/28/2015.
 */
public class Beat {
    enum Type { Kick, HiHat, Snare, Scratch}

    String name;
    Type type;

    public int getSoundId() {return soundId;}

    int soundId;

    public Beat(String name, Type type, int soundId){
        this.name = name;
        this.type = type;
        this.soundId = soundId;
    }

    public String getName() { return name;}

    public void setName(String name){ this.name = name;}

    public Type getType() {return type;}

    public String toString(){ return name;}

    public static int getIconResource(Type type){
        switch(type){
            case Kick: return R.drawable.kick_drum;
            case HiHat: return R.drawable.hi_hat;
            case Snare: return R.drawable.snare_drum;
            case Scratch: return R.drawable.scratch;
        }
        return -1;
    }
}
