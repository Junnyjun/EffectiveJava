package Ex01;

public class Item04 {
    public static void main(String[] args) {
        /**
         *  인스턴스화를 막으려거든 private 생성자를 사용하라
         *
         *   추상클래스만 으로는 인스턴스화를 막을 수 없다.
         *
         *   ! private 생성자로 인스턴스화를 막을 수 있다.
         *
        */

        class UtilityClass {
            // 기본 생성자가 만들어지는 것을 막는다(인스턴스화 방지용).
            private UtilityClass() {
                throw new AssertionError();
            }

            // 나머지 코드는 생략
        }
    }
}
