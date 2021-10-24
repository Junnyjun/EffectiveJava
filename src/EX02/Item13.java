package EX02;

import Ex01.*;

public class Item13 {
    public static void main(String[] args) {
        /**
         * clone 재정의는 주의해서 진행하라
         *
         *  Cloneable을 구현한 클래스에서 clone을 호출하면 그객체의 필드들을 하나하나 [ 복사 ] 한 객체를 반환환다
         *  clone은 생성자와 같은 효과를 가진다. ( = 불변식을 보장해야 한다 )
         *
         *  복제본이 가변변수 일경우 깊은복사 & final을 고려해야 한다.
         *
         *  Cloneable을 구현하는 모든 클래스는 clone을 재정의 해야한다. ( + 깊은복사 .. )
         *
         *  ..! cloneable을 쓰지말라 ( 모르면) 는 내용으로 보인다..!
         *  쓴적도 없지만,, 더편한 복사팩터리/변환팩터리를 사용하도록 한다.
         *
         *
         *  */
    }

//    // 코드 13-1 가변 상태를 참조하지 않는 클래스용 clone 메서드 (79쪽)
//    @Override public PhoneNumber clone() {
//        try {
//            return (PhoneNumber) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();  // 일어날 수 없는 일이다.
//        }
//    }
//    // 코드 13-2 가변 상태를 참조하는 클래스용 clone 메서드
//    @Override public Item07.Stack clone() {
//        try {
//            Item07.Stack result = (Item07.Stack) super.clone();
//            result.elements = elements.clone();
//            return result;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
}
