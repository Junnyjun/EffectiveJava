package EX03;

import java.util.*;

public class Item20 {
    /**
     * 추상 클래스 보다는 인터페이스를 우선하라
     *
     * 인터페이스는 믹스인 정의에 안성맞춤
     * 계증구조가 없는 타입 프레임워크를 만들 수 있다.
     *
     * 추상클래스로 골격 구현하여 다중 상속을 피하자
     *
     */
}
// 코드 20-1 골격 구현을 사용해 완성한 구체 클래스 (133쪽)
class IntArrays {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // 다이아몬드 연산자를 이렇게 사용하는 건 자바 9부터 가능하다.
        // 더 낮은 버전을 사용한다면 <Integer>로 수정하자.
        return new AbstractList<>() {
            @Override public Integer get(int i) {
                return a[i];  // 오토박싱(아이템 6)
            }

            @Override public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;     // 오토언박싱
                return oldVal;  // 오토박싱
            }

            @Override public int size() {
                return a.length;
            }
        };
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        List<Integer> list = intArrayAsList(a);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
// 코드 20-2 골격 구현 클래스 (134-135쪽)
abstract class AbstractMapEntry<K,V>
        implements Map.Entry<K,V> {
    // 변경 가능한 엔트리는 이 메서드를 반드시 재정의해야 한다.
    @Override public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Map.Entry.equals의 일반 규약을 구현한다.
    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map.Entry))
            return false;
        Map.Entry<?,?> e = (Map.Entry) o;
        return Objects.equals(e.getKey(),   getKey())
                && Objects.equals(e.getValue(), getValue());
    }

    // Map.Entry.hashCode의 일반 규약을 구현한다.
    @Override public int hashCode() {
        return Objects.hashCode(getKey())
                ^ Objects.hashCode(getValue());
    }

    @Override public String toString() {
        return getKey() + "=" + getValue();
    }
}
