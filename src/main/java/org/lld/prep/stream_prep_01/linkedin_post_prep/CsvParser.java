package org.lld.prep.stream_prep_01.linkedin_post_prep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvParser {
    static class Employee {
        int id;
        String name;
        int age;
        double salary;

        Employee(int id, String name, int age, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return id + " - " + name + " - " + age + " - $" + salary;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Employee> result = Files.lines(Paths.get("/Users/sunnyranjan/Documents/Prep/src/main/java/org/lld/prep/stream_prep_01/linkedin_post_prep/employees.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map((fields) -> new Employee(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        Integer.parseInt(fields[2]),
                        Double.parseDouble(fields[3])
                ))
                .toList();

        System.out.println(result);

    }
}
