package EX08;

public class Item51 {
    /**
     * 메서드 시그니처를 신중히 설계하라
     *
     * 1. 메서드 이름을 신중하게 짓자.
     *    ㄴ 표준 명명 규칙을 따른다.
     * 2. 편의 메서드를 많이 많들지 마라
     *    ㄴ 메서드가 많은 클래스는 가독성이떨어지고 유지보수가 어렵다
     *    ㄴ 확신이 서지 않으면 만들지 마라
     * 3. 매개변수 목록은 짧게 유지하라
     *    ㄴ 최대 4개까지가 적당하다.
     *    ㄴ 같은 타입의 매개변수 여러 개가 연달아 나오면 해롭다.
     *
     *    A. 여러 메서드로 쪼갠다.
     *    B. 매개변수 여러 개를 묶어주는 도우미 클래스를 만들어라.
     *    C. 빌더패턴을 메서드 호출에 응용한다.
     *
     * 매개변수의 타입으로는 클래스보다 인터페이스가 낫다.
     * Boolean 보다 열거타입이 낫다.
     */
}
