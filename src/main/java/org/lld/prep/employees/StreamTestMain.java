package org.lld.prep.employees;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
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

        // Q2. List of names
        List<String> names = Arrays.asList("Jane","John","Arpit","Jason","Philip","Nitin","Joe");

        Map<Integer, Long> count = names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));

        count.keySet().stream().forEach(System.out::println);

        // Q3. List of names with null
        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");

        List<String> filteredList = list.stream().map((name) -> {
            if(name == null) {
                return "N/A";
            }
            return name;
        }).filter((name) -> !name.equals("N/A")).toList();

        List<String> filteredList1 = list.stream().filter(Objects::nonNull).toList();

        filteredList1.stream().forEach(System.out::println);

        // Q4 Integer array to stream
        Integer[] numbers = {1,2,3,4,6};
        Stream<Integer> stream = Arrays.stream(numbers);
        stream.toList().forEach(System.out::println);

        // Q5 Find the frequency of each element
        List<String> stationeryList = Arrays.asList(
            "Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil"
    );

        Map<String,Long> stringCount = stationeryList.stream()
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        stringCount.forEach((key, val) -> System.out.println("Key: "+key+" Value: "+val));

        // Q6 Anymatch in stream
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, null,7);

        boolean find = numberList.stream().filter(Objects::nonNull).anyMatch(num -> num == 7);

        System.out.println("Is there is num greater than 6: "+find);

        // Q7 Sorting names ascending/descending
        List<String> nameList = Arrays.asList("Ajerbeen","Manik","Kuttu","Joe","Linker");
        nameList.stream().sorted((name1, name2) -> name2.compareTo(name1)).toList().forEach((name) -> System.out.println(name));

        List<Integer> testNumbersList = Arrays.asList(5, 2, 8, 1, 9, null);
        int max = testNumbersList.stream().filter(Objects::nonNull).max((num1,num2) -> num1.compareTo(num2)).orElse(Integer.MIN_VALUE);
        System.out.println("Max: "+max);
    }
}
