package org.training.taskmanager.object.event.tag;

public class EventTagObj {
    private Long id;
    private String name;

    public EventTagObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EventTagObj() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
