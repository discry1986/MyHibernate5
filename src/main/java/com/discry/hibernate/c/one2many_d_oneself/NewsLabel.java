package com.discry.hibernate.c.one2many_d_oneself;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhoujp1 on 2017-03-10.
 */
public class NewsLabel {
    private Integer id;
    private String name;
    private String content;
    private Set<NewsLabel> childNewLabels;//作为一方有一个多方set集合
    private NewsLabel parentNewLabel;//作为多方有一个一方的对象

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<NewsLabel> getChildNewLabels() {
        return childNewLabels;
    }

    public void setChildNewLabels(Set<NewsLabel> childNewLabels) {
        this.childNewLabels = childNewLabels;
    }

    public NewsLabel getParentNewLabel() {
        return parentNewLabel;
    }

    public void setParentNewLabel(NewsLabel parentNewLabel) {
        this.parentNewLabel = parentNewLabel;
    }

    public NewsLabel() {
        childNewLabels = new HashSet<NewsLabel>();
    }

    public NewsLabel(String name, String content) {
        this();
        this.name = name;
        this.content = content;
    }
}
