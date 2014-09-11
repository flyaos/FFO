package com.uestc.cloudOrchestration.model;

import java.util.List;

/**
 * Created by yao on 2014/8/27.
 */
public class NodeTemplate extends AbstractElement {

    /**
     * Relationship 的 source target 关联对象
     */
    private List<Capability> capabilities;
    private List<Requirement> requirementses;

    public NodeTemplate(){}

    public NodeTemplate(String id, String name) {
        super(id, name);
    }

    public List<Requirement> getRequirementses() {
        return requirementses;
    }

    public void setRequirementses(List<Requirement> requirementses) {
        this.requirementses = requirementses;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }
}
