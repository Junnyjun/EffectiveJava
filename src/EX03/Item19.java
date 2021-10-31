package EX03;

import java.time.Instant;

public class Item19 {
    /**
     * 상속을 고려해 설계하고 문서화하라 ( 아니라면 상속을 금지하라 )
     *
     * 상속용 클래스는 재정의할 수 있는 메서드들을 내부적으로 어떻게 이용하는지 문서로 남겨야 한다.
     * 내부 동작과정에 끼어드는 훅을 잘 생각해서 공개해야한다.
     *  ㄴ 하위클래스로 검증 필수
     *  상속시엔 재정의 메서드 호출을 방지해라
     *
     *  재정의 가능 메서드를 만들고 문서화 시키는 방법이 가장 좋다.
     *
     *  protected & final 로 접근을 막는편이 좋다
     */
}
final class Sub extends Super {
    // 초기화되지 않은 final 필드. 생성자에서 초기화한다.
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    // 재정의 가능 메서드. 상위 클래스의 생성자가 호출한다.
    @Override public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
// 재정의 가능 메서드를 호출하는 생성자 - 따라 하지 말 것! (115쪽)
class Super {
    // 잘못된 예 - 생성자가 재정의 가능 메서드를 호출한다.
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}