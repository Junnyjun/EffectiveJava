package EX08;

import java.util.*;

public class Item55 {
    /**
     * 옵셔널 반환은 신중하게 하라.
     *
     * null을 반환할수 있는 코드를 방치하면 전혀 다른곳에서 에러가 발생할 수 있다.
     *
     * Optional을 사용하면 비어있는경우 Empty 아닌경우 NotEmpty 라고 한다.
     * Null을 반환하지 않는 곳에서만 사용하도록 한다
     *
     * 컬렉션, 스트림, 배열, 옵셔널같은 컨테이너타입은 옵셔널로 감싸면 안된다.
     */

    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();

        // isPresent를 적절치 못하게 사용했다.
        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("부모 PID: " + (parentProcess.isPresent() ?
                String.valueOf(parentProcess.get().pid()) : "N/A"));

        // 같은 기능을 Optional의 map를 이용해 개선한 코드
        System.out.println("부모 PID: " +
                ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));
    }
    public static <E extends Comparable<E>>
    Optional<E> max(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main2(String[] args) {
        List<String> words = Arrays.asList(args);

        System.out.println(max(words));

        // 코드 55-4 옵셔널 활용 1 - 기본값을 정해둘 수 있다. (328쪽)
        String lastWordInLexicon = max(words).orElse("단어 없음...");
        System.out.println(lastWordInLexicon);
    }
}