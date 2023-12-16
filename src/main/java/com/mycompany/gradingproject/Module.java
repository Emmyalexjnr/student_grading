/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradingproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author c2888413
 */
public class Module {

    private String title;
    private String description;
    private String moduleCode;
    private ArrayList<Student> students = new ArrayList<>();

    public Module( String moduleCode, String title, String description ) {
        this.title = title;
        this.moduleCode = moduleCode;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void addStudents(Student student) {
        if (!checkIfStudentsExist(student)) {
            students.add(student);
        }

    }

    private boolean checkIfStudentsExist(Student student) {
        return students.contains(student);
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
}
