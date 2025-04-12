package org.lld.prep.random_questions;

import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solve {
    public void joinStrings() {
        List<String> input = Arrays.asList("User1","User2","User3");
        String output = String.join(",", input);

        System.out.println(output);
    }

    public void ListToMap() {
        List<String> list = Arrays.asList("apple", "banana", "cat", "dog");

        Map<String, Integer> convertMap = list.stream()
                .collect(Collectors.toMap(s -> s, s -> s.length()));

        System.out.println(convertMap.toString());
    }

    public void wordFrequency() {
        String input = "apple banana apple orange banana apple";

        Map<String, Long> converted = Arrays.stream(input.split(" "))
                                        .collect(Collectors.groupingBy
                                                (Function.identity(), Collectors.counting()));

        System.out.println(converted.toString());
    }

    public void sortNumbers() {
        List<Integer> nums = Arrays.asList(19,48,1,5,7,299,299,7);

       Optional<Integer> secondLargest = nums.stream()
               .distinct()
               .sorted((val1, val2) -> val2 - val1)
               .skip(1).findFirst();


        List<Integer> newNums = nums.stream().distinct().toList();
        System.out.println(secondLargest.get());
        System.out.println("Non Repeative Numbers: "+ newNums);
    }

    public void duplicateNumbers() {
        List<Integer> nums = Arrays.asList(19,48,1,5,7,299,299,7);

        List<Integer> output = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        Map<Integer, Integer> testM1 = Map.ofEntries(
                Map.entry(1,2),
                Map.entry(3,1),
                Map.entry(4,5),
                Map.entry(2,1)
        );

        System.out.println(output);

        Map<Integer, Integer> sortedMap = testM1.entrySet()
                                        .stream()
                                        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                        .collect(Collectors.toMap(
                                                Map.Entry::getKey,
                                                Map.Entry::getValue,
                                                (e1, e2) -> e1,
                                                LinkedHashMap::new
                                        ));

        System.out.println(sortedMap.toString());
    }

    public void getCountOfEachDepartment() {
        List<Employee> employees = Arrays.asList(
                new Employee(1,"Kunal",1937.8,28,"M","Tech"),
                new Employee(5,"Rishab",29746.8,28,"M","Tech"),
                new Employee(3,"Kalpit",192693.8,28,"M","Accounts"),
                new Employee(2,"Trisha",102937.1,28,"F","HR"),
                new Employee(4,"Kriti",19387137.8,28,"F","HR")
        );

        //1
        Map<String, Long> groupByDept = employees
                                    .stream()
                                    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(groupByDept.toString());

        //2
        Optional<Double> secondHighestSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .map(Employee::getSalary)
                .findFirst();

        System.out.println("Second Highest" + secondHighestSalary);

        Map<String, List<Employee>> groupByDeptEmployee = employees
                                                    .stream()
                                                    .collect(Collectors.groupingBy(Employee::getDepartment));

        //Map<String, Employee> oneEmployeePerDept = employees.stream()
        //    .collect(Collectors.toMap(
        //        Employee::getDepartment,       // key: department
        //        Function.identity(),           // value: employee itself
        //        (existing, replacement) -> existing // if duplicate dept, keep the first one
        //    ));

        System.out.println(groupByDeptEmployee.toString());

    }
}
