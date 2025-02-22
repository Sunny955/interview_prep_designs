package org.lld.prep.comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {
    Integer id;
    int age;
    String name;

    public Employee(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "Employee{id=" + id +", age: " +age +", name='" + name + "'}";
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getAge() - o2.getAge();
    }
}

public class MainRun {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,27,"Abhi"));
        employees.add(new Employee(2,39,"Rupa"));
        employees.add(new Employee(3,22,"Sinu"));
        employees.add(new Employee(4,45,"Dalli"));

        // Sorting via comparable
        Collections.sort(employees);
        System.out.println(employees);

        // Sorting via comparator using lambda functions
        // Remember compareTo() can only work on wrapper class and not on primitve
        Collections.sort(employees,(Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println(employees);

        // Sorting via class
        Collections.sort(employees,new IdComparator());
        System.out.println(employees);
    }
}
