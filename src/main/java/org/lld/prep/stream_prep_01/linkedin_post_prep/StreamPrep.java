package org.lld.prep.stream_prep_01.linkedin_post_prep;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPrep {
    public void filterEvenNums() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
    }

    public void wordFrequency() {
        String word = "akdcmcdamndhjials";
        Map<Character, Long> ans = word.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        ans.entrySet().forEach(System.out::println);
    }

    public void findFirstNonRepeatingChar() {
        String word = "akdcmcdamndhjials";
        Map<Character, Long> ans = word.chars()
                                    .mapToObj(c -> (char) c)
                                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()));


        ans.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().ifPresent(System.out::println);
    }

    public void removeDuplicates() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 6, 7, 8, 3, 10);

        // output -> [1,4,6,7,8,10]
//        list.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(num -> num.getValue() == 1)
//                .map(Map.Entry::getKey)
//                .forEach(System.out::println);

        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(num -> num.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    public void sortEmployeesBySalary() {
        List<Employee> employees = Arrays.asList(
                                    new Employee("1","Ajay",29,91736.27,"TECH"),
                                    new Employee("2","Vijay",26,21736.27,"HR"),
                                    new Employee("3","Mohan",35,31736.27,"ACCOUNT"),
                                    new Employee("4","Riya",19,41736.27,"FINANCE"),
                                    new Employee("5","Lokesh",28,8736.27,"HR"),
                                    new Employee("6","Komal",29,13736.27,"TECH")
                                    );

                employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .forEach(System.out::println);

                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                        .forEach((k, v) -> System.out.println("Department: " + k + " Employees size " + v.size()));

    }

    public void convertToUpperCase() {
        List<String> list = Arrays.asList("ancvd", "ddndgs", "dhdhd", "dksus");

//        list.stream().map(String::toUpperCase).forEach(System.out::println);
//        System.out.println(list.stream().collect(Collectors.joining(",")));
        list.stream().collect(Collectors.toMap(Function.identity(), String::length)).entrySet().stream().forEach(System.out::println);
    }

    public void sumOfAllNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(numbers.stream().reduce(0, (acc, num) -> acc + num));
        numbers.stream().sorted((a, b) -> b - a).skip(1).findFirst().ifPresent(System.out::println);
    }

    public void sortMapByValues() {
        Map<Integer, Integer> map = Map.of(1,2
                                            ,3,1
                                            ,5,6);

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }

    public void usingMergerWithCollector() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry","apple");

        Map<Character, String> map = words.stream()
                                    .collect(Collectors.toMap(
                                            word -> word.charAt(0),  // key
                                            word -> word,            // value
                                            (word1, word2) -> word1 + "," + word2 // in case of duplicates
                                    ));

        Map<String, Integer> map1 = words.stream()
                .collect(Collectors.toMap(
                        word -> word,                              // key
                        word -> 1,                                 // value
                        (freq1, freq2) -> freq1 + freq2    // in case of duplicates
                ));

        System.out.println(map1);
    }

    public void youngestEmployeeInEachDept() {
        List<Employee> employees = Arrays.asList(
                new Employee("1","Ajay",29,91736.27,"TECH"),
                new Employee("2","Vijay",26,21736.27,"HR"),
                new Employee("3","Mohan",35,31736.27,"ACCOUNT"),
                new Employee("4","Riya",19,41736.27,"FINANCE"),
                new Employee("5","Lokesh",28,8736.27,"HR"),
                new Employee("6","Komal",29,13736.27,"TECH")
        );

        employees
                .stream()
                .collect(Collectors.toMap(Employee::getDepartment, Employee::getAge, (a,b) -> Math.min(a,b)))
                .entrySet()
                .stream()
                .forEach(System.out::println);
    }

    public void mostFrequentElement() {
        List<Integer> list = Arrays.asList(1,3,4,1,2,3,3,5,3);

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent((e) -> System.out.println("Most frequent: "+ e));
    }
}
