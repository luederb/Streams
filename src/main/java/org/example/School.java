package org.example;

import java.util.Objects;

public class School {
    private String name;
    private int numberOfStudents;

    public School(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return numberOfStudents == school.numberOfStudents && Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfStudents);
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}
