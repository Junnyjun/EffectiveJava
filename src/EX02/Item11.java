package EX02;

public class Item11 {
    public static void main(String[] args) {
        /**
         * Equals를 재정의 하려거든 Hashcode도 재정의 하라
         *
         * Equals를 재정의한 클래스 모두에서 hashCode도 재정의 해야한다.
         *  ⇒ Equals 비교에는 사용되는 정보가 변경되지 않았다면 어플리케이션이 실행되는 동안,
         *  그 객체의 hashcode도 일관된 값을 반환해야 한다
         *  ⇒ equals가 두객체를 같다고 판단했다면, 두 객체의 hashcode는 똑같은 값을 반환
         *  ⇒ equals가 두객체를 다르다고 판단 했더라고 hashcode가 다를 필요는 없다.
         *
         *  Hashcode 작성 요령
         *  1. int result = [임의값]
         *  2. 해당 필드의 해시코드 [임의값] 을 계산
         *    ㄱ. 기본 타입 필드 -> type.hashcode(Field) 를 수행
         *    ㄴ. 참조 타입 필드면서 이클래스의 euqals메서드가 이 필드의 equals를 재귀적으로 호출해 비교
         *    ㄷ. 필드가 배열 이라면 핵심원소를 각각 별도 필드처럼 다룬다.
         *  3. 2에서 계산한 해시코드 [임의값]으로 result를 갱신&반환한다
         *
         * 해시코드에 핵심 필드를 생략해서는 안된다.
         *
         */
    }
}
final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

//    @Override public boolean equals(Object o) {
//        if (o == this)
//            return true;
//        if (!(o instanceof PhoneNumber14))
//            return false;
//        PhoneNumber14 pn = (PhoneNumber14)o;
//        return pn.lineNum == lineNum && pn.prefix == prefix
//                && pn.areaCode == areaCode;
//    }

    // hashCode 없이는 제대로 동작하지 않는다. 다음 셋 중 하나를 활성화하자.

//    // 코드 11-2 전형적인 hashCode 메서드
//    @Override public int hashCode() {
//        int result = Short.hashCode(areaCode);
//        result = 31 * result + Short.hashCode(prefix);
//        result = 31 * result + Short.hashCode(lineNum);
//        return result;
//    }

    //    // 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다. (71쪽)
//    private int hashCode; // 자동으로 0으로 초기화된다.
//
//    @Override public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = Short.hashCode(areaCode);
//            result = 31 * result + Short.hashCode(prefix);
//            result = 31 * result + Short.hashCode(lineNum);
//            hashCode = result;
//        }
//        return result;
//    }

}
