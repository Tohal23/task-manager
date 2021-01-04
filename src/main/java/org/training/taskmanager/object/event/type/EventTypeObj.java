package org.training.taskmanager.object.event.type;

public class EventTypeObj {
    private Long id;
    private String name;

    public EventTypeObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EventTypeObj() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
