package EX05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Item32 {
    /**
     * 제너릭과 가변인수를 사용할때는 신중하라
     * <p>
     * 배열과 마찬가지로 가변매개변수는 안전하지 않다.
     * 같이 사용하고 싶을땐 @SafeVarargs로 경고를 숨길수 있다.
     */

    public static void main(String[] args) {

        String[] attributes = pickTwo("좋은", "빠른", "저렴한");
        System.out.println(Arrays.toString(attributes));


        List<Integer> flatList = FlattenWithList.flatten(List.of(
                List.of(1, 2), List.of(3, 4, 5), List.of(6, 7)));
        System.out.println(flatList);
    }
    // 코드 32-4 제네릭 varargs 매개변수를 List로 대체한 예 - 타입 안전하다. (195-196쪽)
    public static class FlattenWithList {
        static <T> List<T> flatten(List<List<? extends T>> lists) {
            List<T> result = new ArrayList<>();
            for (List<? extends T> list : lists)
                result.addAll(list);
            return result;
        }

        public static class FlattenWithVarargs {
            @SafeVarargs
            static <T> List<T> flatten(List<? extends T>... lists) {
                List<T> result = new ArrayList<>();
                for (List<? extends T> list : lists)
                    result.addAll(list);
                return result;
            }

        }
    }

    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // 도달할 수 없다.
    }

}