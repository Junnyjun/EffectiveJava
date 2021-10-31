package EX03;

public class Item17 {
    /**
     * 변경 가능성을 최소화하라
     *
     * - 변경자를 제공하지 않는다
     * - 클래스를 확장할 수 없도록 한다
     * - 모든 필드를 final로 선언한다
     * - 모든 필드를 pivate로 선언
     * - 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.
     *
     * 불변 객체는 근본적으로 스레드 안전하여 동기화할 필요 없다
     *  ㄴ 안심하고 공유 가능
     *  ㄴ 실패 원자성을 제공
     *  ㄴ 독립된 객체로 만들어야 한다
     *
     *
     */


}
// 코드 17-1 불변 복소수 클래스 (106-107쪽)
final class Complex {
    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
}
