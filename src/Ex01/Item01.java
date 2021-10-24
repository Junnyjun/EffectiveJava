package Ex01;

import java.lang.reflect.Array;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import static java.util.concurrent.TimeUnit.HOURS;


public class Item01 {

    public static void main(String[] args) {
        /**
         * 생성자 대신 정적 팩터리 메서드를 고려
         * 1. 이름을 가질수있다
         *  이는 가독성을 의미한다
         * 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
         *  이는 큰 객체일수록 성능을 끌어올려준다
         *  인스턴스의 생명주기를 다루는데 용이하다.
         * 3. 반환 타입의 하위타입 객체를 반환할 수 있는 능력이 있다
         *  이는 '유연성'을 의미한다
         *  API의 크기가 작아짐과 가독성 및 코드 구현 난이도 저하로 이어진다.
         *  '정적 필드와 정적 멤버 클래스는 Public'
         * 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
         *  클래스의 확장 가능성 및 이용자의 편의를 증가시킨다.
         * 5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
         *  프라임워크 사용자에게 기본구현체 & 커스텀 구현체를 선택할 수 있도록 해준다.
         *
         *  !!
         *  상속을 위해서는 public이나 protected 생성자가 필요하니 정적메소드로는 하위클래스를 만들 수 없다
         *  프로그래머가 찾기 어렵디
         *
         *  ##
         *  static method로 성능을 이끌어내자,,!
         */

        Object newArray = Array.newInstance();
        FileStore fs = Files.getFileStore("/");

    }

    public static LocalTime of(int hour, int minute) {
        ChronoField.HOUR_OF_DAY.checkValidValue((long) hour);
        if (minute == 0) {
            return HOURS[hour];
        } else {
            ChronoField.MINUTE_OF_HOUR.checkValidValue((long) minute);
            return new LocalTime(hour, minute, 0, 0);
        }
    }
}


