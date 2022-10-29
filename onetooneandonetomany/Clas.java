package com.onetooneandonetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clas")
public class Clas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClassID")
    private Integer id;

    @Column(name = "ClassName", nullable = false, unique = true)
    private String className;

    @Column(name = "Floor", nullable = false)
    private Integer floor;

    @OneToMany
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", floor=" + floor +
                ", students=" + students +
                '}';
    }
}



