package org.lld.prep.employees;

public class Employee {
    private String name;
    private long salary;
    private int age;

    public Employee(String name, long salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
