package EX07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Item46 {
    /**
     * 스트림에서는 부작용 없는 함수를 사용하라
     *
     * foreach는 스트림연산 결과를 보고할 때만 사용하고 계산할때는 사용하지 말라.
     * toList, toSet, toMap, groupingBy, joining
     */

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);


        Map<String, Long> freq;
        try (Stream<String> words = new Scanner(file).tokens()) {
            freq = words.collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq);

        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
    }
}
