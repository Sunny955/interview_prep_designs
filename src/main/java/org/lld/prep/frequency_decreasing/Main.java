package org.lld.prep.frequency_decreasing;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 4, 4, 4, 3, 4, 5, 5, 5, 2, 2, 2);

        List<Integer> output = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int freqCompare = e2.getValue().compareTo(e1.getValue());

                    if (freqCompare == 0) {
                        return e2.getKey().compareTo(e1.getKey());
                    }

                    return freqCompare;
                })
                .flatMap(entry -> Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream())
                .toList();

        System.out.println(output);

    }
}
