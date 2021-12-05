package EX10;

public class Item74 {
    /**
     * 메서드가 던지는 모든 예외를 문서화하라
     *
     * 검사예외는 항상 따로따로 선언하고 각 예외가 발생하는 상황을 자바독의 @throws 태그를 사용하여 정호가히 문서화하자
     *
     * 한 클래스에 정의된 많은 메서드가 같은 이유로 같은 예외를 던진다면 클래스 설명에 추가하는 방법도 있다
     *
     *
     * */
}

class IndexOutOfBoundsException extends RuntimeException {
    private final int lowerBound;
    private final int upperBound;
    private final int index;

    /**
     * IndexOutOfBoundsException을 생성한다.
     *
     * @param lowerBound 인덱스의 최솟값
     * @param upperBound 인덱스의 최댓값 + 1
     * @param index      인덱스의 실젯값
     */
    public IndexOutOfBoundsException(int lowerBound, int upperBound,
                                     int index) {
        // 실패를 포착하는 상세 메시지를 생성한다.
        super(String.format(
                "최솟값: %d, 최댓값: %d, 인덱스: %d",
                lowerBound, upperBound, index));

        // 프로그램에서 이용할 수 있도록 실패 정보를 저장해둔다.
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }
}
