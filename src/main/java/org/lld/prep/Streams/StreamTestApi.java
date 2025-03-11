package org.lld.prep.Streams;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    private String firstName;
    private String lastName;

    // Constructor
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

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

@SuppressWarnings("unused")
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
    public void multiSort() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe"),
                new Employee("Jane", "Doe"),
                new Employee("Alice", "Smith"),
                new Employee("Bob", "Johnson"),
                new Employee("Charlie", "Brown")
        );

        List<Employee> sortedEmployee = employees.stream().sorted(
                Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
        ).toList();

        sortedEmployee.forEach((Employee e) -> System.out.println(e.toString()));

        int sum = IntStream.range(1,11).sum();

        System.out.println("Sum from 1 to 10: "+sum);
    }

    public void countWordFrequency() {
        List<String> stationeryList = Arrays.asList(
                "Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil"
        );
        Map<String,Long> freqMap = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        freqMap.forEach((a,b)-> System.out.println(a + " : "+b));
    }
    public void concatArrSorted() {
        int[] a = new int[] {4, 2, 5, 1};
        int[] b = new int[] {8, 1, 9, 5};

        int[] c = IntStream.concat(Arrays.stream(a),Arrays.stream(b)).sorted().distinct().toArray();

        for(int i=0;i<c.length;i++) {
            System.out.println(c[i]);
        }
    }
    public void secondLargestNumber() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        int secondLarge = listOfIntegers.stream().sorted((a,b) -> b-a).skip(1).findFirst().get();

        System.out.println("Second largest: "+secondLarge);
    }
    public void sortAccordingtoLength() {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

        List<String> sortedLength = listOfStrings.stream().sorted((a,b) -> a.length()-b.length()).toList();

        sortedLength.forEach(System.out::println);
    }
    public void mostRepeatedElement() {
        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");

        Map<String, Long> freqMap = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<String, Long> mostFreqString = freqMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("Most freq string: "+mostFreqString.getKey()+" freq: "+mostFreqString.getValue());
    }
    public void lengthFreq() {
        List<String> strings = Arrays.asList("dog","cat","elephant","rabbit","fox","giraffe","ant","zebra","owl");

        Map<Integer, Long> lengthMap = strings.stream().collect(Collectors.groupingBy((s)->s.length(),Collectors.counting()));

        lengthMap.forEach((a,b) -> System.out.println("Length: "+a+ " frequency: "+b));
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
        streamTest.multiSort();
        streamTest.countWordFrequency();
        streamTest.concatArrSorted();
        streamTest.secondLargestNumber();
        streamTest.sortAccordingtoLength();
        streamTest.mostRepeatedElement();
        streamTest.lengthFreq();
    }
}


