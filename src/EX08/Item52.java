package EX08;

import java.math.BigInteger;
import java.util.*;

public class Item52 {
    /**
     * 다중정의는 신중히 사용하라
     *
     * 재정의한 메서드는 동적으로 선택되고 다중정의한 메서드는 정적으로 선택된다.
     * 다중정의가 혼동을 일으키는 상황을 피해야 한다
     *
     * 서로 다른 인터페이스라도 같은 위치에 두지말아야 한다.
     */
}

class FixedCollectionClassifier {
    public static String classify(Collection<?> c) {
        return c instanceof Set ? "집합" :
                c instanceof List ? "리스트" : "그 외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}

class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "집합";
    }

    public static String classify(List<?> lst) {
        return "리스트";
    }

    public static String classify(Collection<?> c) {
        return "그 외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}