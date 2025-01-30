package org.lld.prep.Streams;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class User {
    private String name;
    private int userId;
    private List<UserRole> userRoles;

    public User(String name, int userId, List<UserRole> userRoles) {
        this.name = name;
        this.userId = userId;
        this.userRoles = userRoles;
    }

    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public static class UserRole {
        private int id;
        public UserRole(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                ", userRoles=" + userRoles +
                '}';
    }
}

class StreamTest {
    public void evenNumbers() {
        // Q1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream().filter((num) -> num%2==0).toList();

        evenNumbers.forEach((num) -> System.out.println("Num: "+num));
    }
    public void mappingUppercase() {
        // Q2
        List<String> names = Arrays.asList("John", "Jane", "Adam");
        List<String> upperCase = names.stream().map((name) -> name.toUpperCase()).toList();

        upperCase.forEach((name) -> System.out.println("Name: "+name));
    }
    public void distinctElement() {
        // Q3
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4, 5);
        List<Integer> distinctNumber = numbers.stream().distinct().toList();

        distinctNumber.forEach((num) -> System.out.println("Num: "+num));
    }
    public void sortingInReverseOrder() {
        // Q4
        List<String> names = Arrays.asList("John", "Jane", "Adam");
        List<String> sortedNames = names.stream().sorted((name1, name2) -> name2.compareTo(name1)).toList();

        sortedNames.forEach((name) -> System.out.println("Name: "+name));
    }
    public void reduceSum() {
        // Q5
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println("Sum: "+sum);
    }
    public void groupingElements() {
        // Q6. Group a list of strings by their length using Stream API
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        Map<Integer, List<String>> groupElements = words.stream().collect(Collectors.groupingBy((name) -> name.length()));

        groupElements.forEach((key, value) -> System.out.println("Key: "+key+ " Value: "+value.size()));
    }
    public void maxiMini() {
        // Q7
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        int max = numbers.stream().max((num1,num2) -> num1.compareTo(num2)).orElse(0);
        int min = numbers.stream().min((num1,num2) -> num1.compareTo(num2)).orElse(0);

        System.out.println("Maxi, Mini: "+ max+" , "+min);
    }
    public void countingElements() {
        // Q8
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count = numbers.stream().filter((num) -> num>5).count();

        System.out.println("Count of greater than 5: "+count);
    }
    public void joinString() {
        List<String> words = Arrays.asList("Hello", "World", "Java", "8");
        String joined = words.stream().collect(Collectors.joining(" "));

        System.out.println("Joined string: "+ joined);
    }
    public void partitioningElement() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> part = numbers.stream().collect(Collectors.groupingBy((num) -> num%2 ==0));

        for (Map.Entry<Boolean, List<Integer>> entry : part.entrySet()) {
            Boolean key = entry.getKey();
            List<Integer> value = entry.getValue();
            System.out.println("Key: " + key + ", Values: " + value.toString());
        }
    }
    public void findFirst() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> num = numbers.stream().filter((n) -> n%2==0).findFirst();

        System.out.println("Num first: "+num.get());
    }
    public void anyElementMatch() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean anyGreaterThan3 = numbers.stream().anyMatch((num) -> num>3);

        System.out.println("Any greater: "+anyGreaterThan3);
    }
    public void parallelProcessing() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.parallelStream().reduce(0,(s, num)-> s+num);

        System.out.println("Parallel sum: "+sum);
    }
    public void convertToMap() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Map<String, Integer> group = words.stream().collect(Collectors.toMap((word) -> word, (word) -> word.length()));

        for (Map.Entry<String, Integer> entry : group.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + ", Values: " + value.toString());
        }
    }
    public void peekingElement() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .peek(System.out::println)
                .map(n -> n * 2)
                .peek(System.out::println)
                .collect(Collectors.toList());

        result.forEach((num) -> System.out.println("Num: "+num));
    }
    public void customCollector() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        String result = words.stream()
                .collect(Collector.of(
                        StringBuilder::new,
                        (sb, str) -> {
                            if (sb.length() > 0) sb.append(", ");
                            sb.append(str);
                        },
                        StringBuilder::append,
                        sb -> "[" + sb.toString() + "]"
                ));

    }
    public void convertIntToDouble() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> convert = numbers.stream().mapToDouble(Integer::doubleValue).peek(System.out::println).boxed().toList();
        List<Double> convert1 = numbers.stream().map(Double::valueOf).toList();

        convert1.forEach((num) -> System.out.println("Converted Num: "+num));
    }
    public void flatMapUsage() {
        List<User> users = Arrays.asList(
                new User("Akinni",1, Arrays.asList(new User.UserRole(101), new User.UserRole(102))),
                new User("Bob", 2, Arrays.asList(new User.UserRole(103), new User.UserRole(104))),
                new User("Charlie", 3, Arrays.asList(new User.UserRole(105)))
                );

        List<Integer> userRolesId = users.stream()
                .flatMap((user) -> user.getUserRoles().stream())
                .map((userRole) -> userRole.getId())
                .toList();

        System.out.println("User roles ids: "+userRolesId);
    }
}

public class StreamTestApi {
    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.evenNumbers();
        streamTest.mappingUppercase();
        streamTest.distinctElement();
        streamTest.sortingInReverseOrder();
        streamTest.reduceSum();
        streamTest.groupingElements();
        streamTest.maxiMini();
        streamTest.countingElements();
        streamTest.joinString();
        streamTest.partitioningElement();
        streamTest.findFirst();
        streamTest.anyElementMatch();
        streamTest.parallelProcessing();
        streamTest.convertToMap();
        streamTest.peekingElement();
        streamTest.convertIntToDouble();
        streamTest.flatMapUsage();
    }
}


