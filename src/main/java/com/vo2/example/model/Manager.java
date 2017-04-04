package com.vo2.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by VO2 on 04/04/2017.
 */
@Entity
@Table(name = "manager")
@PrimaryKeyJoinColumn(name="person_id")
public class Manager extends Person {

    @Column(name = "free_time")
    private Integer freeTime;

    @Column(name = "work_time")
    private Integer workTime;

    public Integer getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Integer freeTime) {
        this.freeTime = freeTime;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }
}
