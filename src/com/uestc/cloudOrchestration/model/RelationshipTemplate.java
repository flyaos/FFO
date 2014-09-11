package com.uestc.cloudOrchestration.model;

/**
 * Created by yao on 2014/8/27.
 */
public class RelationshipTemplate extends AbstractElement {

    private String sourceElement;
    private String targetElement;

    public RelationshipTemplate(){}

    public RelationshipTemplate(String id, String name) {
        super(id, name);
    }

    public String getSourceElement() {
        return sourceElement;
    }

    public void setSourceElement(String sourceElement) {
        this.sourceElement = sourceElement;
    }

    public String getTargetElement() {
        return targetElement;
    }

    public void setTargetElement(String targetElement) {
        this.targetElement = targetElement;
    }
}
