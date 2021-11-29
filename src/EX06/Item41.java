package EX06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Item41 {
    /**
     * 타입을 정의 하려면 마커 인터페이스를 사용하라
     *
     * 마커인터페이스는 클래스의 인스턴스들을 구분하는 타입으로 쓸 수 있다.
     * 적용 대상을 정밀하게 지정할 수 있다
     *
     *
     * */
}

@Target(ElementType.TYPE) //  이런식의 사용을 제한하라
@interface markerType {

}