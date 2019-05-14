package com.kelvin.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kelvin.springboot.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kelvin Mai
 * @date 4/16/2019
 */

@Entity
@Table(name = "k_company")
@EntityListeners(AuditingEntityListener.class)
public class Company extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "c_name", nullable = false)
    private String cName;
    private String code;
    @Column(name = "establish_time")
    private Date establishTime;
    @JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", cName='" + cName + '\'' +
                ", code='" + code + '\'' +
                ", establishTime=" + establishTime +
                '}';
    }
}
