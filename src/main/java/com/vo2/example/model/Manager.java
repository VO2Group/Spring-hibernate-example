package com.vo2.example.model;

import javax.persistence.*;
import java.util.List;

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

    ////////////////////////
    //  LES RELATIONS
    ////////////////////////
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> consultants;

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

    public List<Person> getConsultants() {
        return consultants;
    }

    public void setConsultants(List<Person> consultants) {
        this.consultants = consultants;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "freeTime=" + freeTime +
                ", workTime=" + workTime +
                "} " + super.toString();
    }
}
