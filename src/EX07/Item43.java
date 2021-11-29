package EX07;

import java.util.Map;
import java.util.TreeMap;

public class Item43 {
    /**
     * 람다보다는 메서드 참조를 사용하라 ( 람다보다 짧고 명확할때만)
     *
     * 메서드 참조 유형
     * 1. 메서드와 람다가 같은 클래스에 있을 때
     * 2. 수신객체 ( 참조 대상 인스턴스)를 특정하는 한정적 메서드 참조 -> 정적 참조
     * 3. 수신객체를 특정하지 않는 비한정적 인스턴스 메서드 참조
     * 4. 클래스 생성자
     * 5. 배열 생성자
     */

    public static void main(String[] args) {
        // 메서드 참조 유형
        Map<String, Integer> frequencyTable = new TreeMap<>();

        for (String s : args)
            frequencyTable.merge(s, 1, (count, incr) -> count + incr); // 람다
        System.out.println(frequencyTable);

        frequencyTable.clear();
        for (String s : args)
            frequencyTable.merge(s, 1, Integer::sum); // 메서드 참조
        System.out.println(frequencyTable);
    }
}
