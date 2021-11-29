package EX07;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Item45 {
    /**
     * 스트림은 주의해서 사용하라
     *
     * 파이프라인 하나를 구성하는 모든 호출을 연결하여 단 하나의 표현식으로 나타낼 수 있다
     *  * 병렬 실행시 parallel
     * 기존 코드는 스트림을 사용하도록 리팩터링 하되 새코드가 더 나아 보일 때만 반영.
     *
     * ** 사용하기 어려운경우
     * 데이터가 파이프라인을 여러개 통과 할 때
     * return, continue, break가 필요 할 때
     *
     */
    public static void main(String[] args) {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
//                groups.computeIfAbsent(alphabetize(word),
//                        (unused) -> new TreeSet<>()).add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }
}
