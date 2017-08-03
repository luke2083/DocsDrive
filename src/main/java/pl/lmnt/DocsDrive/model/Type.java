package pl.lmnt.DocsDrive.model;

/**
 * Created by luke on 30.07.2017.
 */
public class Type {

    private String name;
    private String desc;
    private String extension;


    public Type(String name, String desc, String extension) {
        this.name = name;
        this.desc = desc;
        this.extension = extension;
    }

    public Type() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
