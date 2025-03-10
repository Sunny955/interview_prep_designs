package org.lld.prep.employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamTestMain {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                Arrays.asList(
                        new Employee("Meenu",383681,26),
                        new Employee("Ram",100000,29),
                        new Employee("Shyam",38361,30),
                        new Employee("Mohsin",310281,47),
                        new Employee("Kurma",4596821,19)
                )
        );

        Predicate<Employee> p1 = e -> e.getSalary() < 60000;
        Predicate<Employee> p2 = e -> e.getSalary() > 40000;

        // Combine predicates using .and()
        Predicate<Employee> combine = p1.and(p2);

        List<Employee> employees1 = employees.stream().filter(combine).toList();
    }
}
