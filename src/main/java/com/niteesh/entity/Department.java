package com.niteesh.entity;


import javax.persistence.*;

@Entity
public class Department {
    @Id
    @SequenceGenerator(name = "deptIdGen", sequenceName = "deptIdSeq", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "deptIdGen", strategy = GenerationType.SEQUENCE)
    protected long id;
    protected String deptName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
