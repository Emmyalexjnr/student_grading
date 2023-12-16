/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gradingproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author c2888413
 */
public class GradingProject {

    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        ArrayList<Module> modules = loadCourseModules();
        ArrayList<Student> students = new ArrayList<>();

        int countStudents = readInteger(keyboardInput, "How many students do you want add");

        for (int i = 0; i < countStudents; i++) {
            String firstName = readText(keyboardInput, "Please input student first name");
            
            String lastName = readText(keyboardInput, "Please input student last name");
            
            String studentCode = readText(keyboardInput, "Please input student code");
            
            Student student = new Student(firstName, lastName, studentCode);
            students.add(student);

            int moduleIndex = 0;
            while (moduleIndex < modules.size()) {
                Module module = modules.get(moduleIndex);
                System.out.println(String.format("Add %s course module to this student", module.getModuleCode()));
                System.out.println("Type 'y' to add, 'n' to not add");
                String ans = getAns(keyboardInput);
                if(ans.equals("y")) {
                    Student currStudent = students.get(i);
                    currStudent.addModules(module);
                    int score = readInteger(keyboardInput, String.format("Put their score in this course(%s)", module.getModuleCode() ));
                    currStudent.addModuleMark(module.getModuleCode(), score);
                }
                moduleIndex++;
            }

        }

        System.out.println("-".repeat(20));
        System.out.println("Student Grades");
        System.out.println("-".repeat(20));
        for (Student value: students) {
            value.displayGrade();
            System.out.println("\n");
        }
    }

    public static ArrayList loadCourseModules() {
        ArrayList<Module> moduleLists = new ArrayList<>();
        Module module1 = new Module("ENG2041-N", "Differential Equations and Numerical Methods", "Module Description...");
        Module module2 = new Module("EAC4027-N", "Renewable Energy Conversion Systems", "Module Description...");
        Module module3 = new Module("GAV2023-N", "Network and Multiplayer Gaming", "Module Desciption...");
        Module module4 = new Module("MMD3058-N", "Project (BEng Tech)", "Module Description...");
        Module module5 = new Module("CIS1007-N", "Information Security and Cybercrime", "Module Desciption...");
        moduleLists.addAll(Arrays.asList(module1, module2, module3, module4, module5));
        return moduleLists;
    }

    public static int readInteger(Scanner keyboardInput, String prompt) {
        System.out.println(prompt);

        while (true) {
            try {
                int userInput = keyboardInput.nextInt();
                return userInput;
            } catch (java.util.InputMismatchException error) {
                System.err.println("Please enter a valid number");
                keyboardInput.next();
            }
        }
    }

    public static String readText(Scanner keyboardInput, String prompt) {
        System.out.println(prompt);
        String userInput = keyboardInput.next();
        return userInput;
    }

    public static String getAns(Scanner keyboardInput) {
        while (true) {
            String userInput = keyboardInput.next();
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("n")) {
                return userInput;
            } else {
                System.err.println("Please enter a valid letter, 'y' or 'n'");
            }
        }

    }

}
