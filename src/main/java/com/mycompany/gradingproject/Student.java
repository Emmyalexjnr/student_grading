/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradingproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author c2888413
 */
public class Student {

    private String firstName;
    private String lastName;
    private String studentNumber;
    private ArrayList<Module> modules = new ArrayList<>();
    private HashMap<Module, Integer> marks = new HashMap<>();
    private HashMap<Module, String> grades = new HashMap<>();

    
    public Student(String firstName, String lastName, String studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFullName() {
        String fullName = firstName + ", " + lastName.charAt(0);
        return fullName;
    }


    public void addModules(Module module) {
        modules.add(module);
    }

    public void addModuleMark(String moduleCode, int mark) {

        Module receivedModule = checkModule(moduleCode);
        if (receivedModule != null) {
            String grade = calculateMarks(mark);
            marks.put(receivedModule, mark);
            grades.put(receivedModule, grade);
        }
    }

    public HashMap<Module, Integer> getModuleMarks() {
        return marks;
    }
    
    public HashMap<Module, String> getModuleGrades() {
        return grades;
    }
    

    public Module checkModule(String moduleCode) {

        for (Module module : modules) {
            if (module.getModuleCode().equals(moduleCode)) {
                return module;
            }
        }
        return null;
    }

    public String calculateMarks(int mark) {
        if (mark >= 0 && mark <= 39) {
            return "FAIL";
        } else if (mark >= 40 && mark <= 49) {
            return "D";
        } else if (mark >= 50 && mark <= 59) {
            return "C";
        } else if (mark >= 60 && mark <= 69) {
            return "B";
        } else if (mark >= 70 && mark <= 79) {
            return "A";
        } else if (mark >= 80 && mark <= 89) {
            return "A*";
        } else {
            return "A**";
        }
    }

    public void displayGrade() {
        String fullName = getFullName();
        System.out.print(fullName + ". ");
        for(HashMap.Entry<Module, String> grade : grades.entrySet()) {
            Module key = grade.getKey();
            String value = grade.getValue();
            System.out.print(key.getModuleCode() + ": " + value + " ");
        }
    }
}
