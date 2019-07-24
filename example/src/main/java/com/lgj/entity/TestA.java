package com.lgj.entity;

import javax.persistence.*;

@Table(name = "test_a")
public class TestA {
    private String name;

    private String brief;

    /**
     * 活动优先级
     */
    private Integer aaa;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return brief
     */
    public String getBrief() {
        return brief;
    }

    /**
     * @param brief
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 获取活动优先级
     *
     * @return aaa - 活动优先级
     */
    public Integer getAaa() {
        return aaa;
    }

    /**
     * 设置活动优先级
     *
     * @param aaa 活动优先级
     */
    public void setAaa(Integer aaa) {
        this.aaa = aaa;
    }
}