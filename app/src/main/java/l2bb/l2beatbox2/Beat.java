package l2bb.l2beatbox2;

/**
 * Created by OZ on 12/28/2015.
 */
public class Beat {
    enum Type { Kick, HiHat, Snare, Scratch}

    String name;
    Type type;
    String difficultyLevel;

    public int getSoundId() {return soundId;}

    public void setSoundId(int soundId){ this.soundId = soundId; }

    int soundId;

    public Beat(String name, Type tye, String difficultyLevel, int soundId){
        this.name = name;
        this.type = type;
        this.difficultyLevel = difficultyLevel;
        this.soundId = soundId;
    }

    public String getName() { return name;}

    public void setName(String name){ this.name = name;}

    public String getShortDescription() {return difficultyLevel;}

    public void setDifficultyLevel (String shortDescription){
        this.difficultyLevel = shortDescription;
    }

    public Type getType() {return type;}

    public void setType(Type type){ this.type = type;}

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
