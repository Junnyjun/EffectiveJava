package EX02;

import java.util.Objects;

public class Item10 {
    public static void main(String[] args) {
        /**
         * Equals 는 일반 규약을 지켜 재정의하라
         *  반사성 : null이 이닌 모든 참조값 x의 x.euqls(x) = true
         *   두 객체는 서로에대한 동치 여부에 같은 값을 가진다
         *  대칭성 : null이 아닌 모든 참조값 x,y의 역함수는 같다 x.equals(y) == y.eqauls(x)
         *   두 객체는 동치여부에 똑같은 답을 한다
         *  추이성 : null이 아닌 모든 참조값 x,y,z의 x.equals(y) y.equals(z)면 z.equals(x) 도 같다
         *   세 객체는 삼단추론을 참으로 가진다.
         *   [ 리스코프 치환 원칙 : 중요한 속성은 하위 타입에서도 중요하다.
         *      그타입의 모든 메서드는 하위 타입에서도 똑같이 잘 작동해야 한다 ]
         *  일관성 : null이 아닌 모든 참조값 x,y의 x.equals(y)의 반복호출은 항상 같은값을 반환한다
         *    불변객체는 영원히 같은 결과를 반환하도록 만들어야 한다.
         *    equals에는 신뢰할 수 없는 자원이 끼어들지 않도록 한다.
         *  NonNull : null이 아닌 모든 참조값 x의 x.equals(null) 은 false다
         *    모든 객체는 null이 아니도록 한다.
         *
         *  EQUALS 구현 방법
         *  1. == 를 사용해 자기 자신의 참조 인지 확인
         *  2. instanceof 로 올바른 타입인지 확인
         *  3. 입력을 올바른 타입으로 형 변환한다.
         *  4. 입력 객체와 자기자신과 대응되는 핵심 필드들이 모두 일치하는지 검사.
         * EQUALS 재정의 X 유형
         * 1. 각 인스턴스가 본질적으로 고유하다
         *   값을 표현하는 게 아니라 동작하는 개체를 표헌하는 클래스
         *    EX) THREAD
         * 2. 인스턴스의 논리적 동치성을 검사할 일이 없다.
         *   두 Patern의 인스턴스가 정규표현식을 나타내는지 검사, ( 논리적 동치)
         *   하는 경우가 아니라면 Object의 Equal로 충분하다
         * 3. 상위 클래스의 Equals가 하위에도 들어맞는다.
         *   Set, List, Map 등은 필요하지 않다.
         * 4. 클래스가 Private & package-private 또는 Equals를 호출할 일이 없다
         *  쓸일이 없을때는 재정의하여 Exception 처리한다
         *
         * EQUALS 재정의 O 유형
         * 1. 논리적 동치성을 확인해야 하지만 상위클래스에서 재정의 되지 않았을때
         *   주로 값 클래스가 해당된다. ( Integer & String )
         *   Bad case의 3과 반대되는 경우라고 볼수 있다.
         *
         *  !! equals 사용시에는 hashcode도 재정의한다.
         *  복잡하게 만들지 말자
         */


    }
}
// 반사성을 어기는 코드는 어떻게 짜야할까요..?

// 대칭성
class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    //        @Override
//        public boolean equals(Object o) {
//            if (o instanceof CaseInsensitiveString)
//                return s.equalsIgnoreCase(
//                        ((CaseInsensitiveString) o).s);
//            if (o instanceof String)  // 한 방향으로만 작동한다!
//                return s.equalsIgnoreCase((String) o);
//            return false;
//        }
    // GoodCASE
    @Override public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}
//추이성
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    //    // 잘못된 코드 - 리스코프 치환 원칙 위배!
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }
    @Override public int hashCode()  {
        return 31 * x + y;
    }
// null 검사는 필요하지 않다 !
}

