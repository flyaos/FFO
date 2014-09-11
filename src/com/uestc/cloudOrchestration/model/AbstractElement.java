package com.uestc.cloudOrchestration.model;

/**
 * Created by yao on 2014/8/27.
 */
public class AbstractElement {
    private String id;
    private String name;

    public AbstractElement() {}

    public AbstractElement(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
