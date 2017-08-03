package pl.lmnt.DocsDrive.model;

import java.time.LocalDateTime;

/**
 * Created by luke on 30.07.2017.
 */
public class Document {

    private String name;
    private Type type;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String location;

    public Document(String name, Type type, String location) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

    public Document() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
