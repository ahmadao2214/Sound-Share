package l2bb.l2beatbox2;

public class Beat {
    private String name, path;

    public Beat(String name, String path){
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPath() { return path; }

}
