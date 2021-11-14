package EX05;

import java.util.ArrayList;
import java.util.List;

public class Item26 {
    /**
     * 로 타입은 사용하지 말라
     *
     * 제너릭 - 제너릭 클래스 + 제너릭 인터페이스
     * 로타입? 매개변수를 정의하지 않은 타입
     *
     * 제너릭 사용시에는 타입을 명시해줄것.
     *  매개변수를 신경쓰지않을 때에는 <?>를 사용하자
     *  ex) Collection<?> donot ?.add("data")
     */


    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.
    }


    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
