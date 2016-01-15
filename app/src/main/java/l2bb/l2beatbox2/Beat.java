package l2bb.l2beatbox2;

/**
 * Created by OZ on 12/28/2015.
 */
public class Beat {

    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Beat(String name, String path){
        this.name = name;
        this.path = path;
    }
}
