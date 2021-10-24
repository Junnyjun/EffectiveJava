package EX02;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Comparator.comparingInt;

public class Item14 {
    public static void main(String[] args) {
        /**
         * Comparable을 구현할지 고려하라.
         *
         *
         * ! CompareTo
         * CompareTo는 동치성 & 순서 비교가 가능하며 [ 제너릭 ] 하다.
         * CompareTo는 Equals와 규약이 비슷하다.
         *
         * 1. 두 객체의 순서를 바꿔도 예상한 결과가 나와야 한다.
         * 2. A > B > C일때 A > C를 성립해야한다
         * 3. 크기가 같은 객체는 어떤 객체던지 항상 같아야 한다.
         *
         * 작성요령은 Equals와 비슷하다다
         * < > 관계 연산자
         *
         * */
    }
}

final class PhoneNumber14 implements Cloneable, Comparable<PhoneNumber14> {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber14(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix   = rangeCheck(prefix,   999, "프리픽스");
        this.lineNum  = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber14))
            return false;
        PhoneNumber14 pn = (PhoneNumber14)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }


    @Override public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

//    // 코드 14-2 기본 타입 필드가 여럿일 때의 비교자 (91쪽)
//    public int compareTo(PhoneNumber pn) {
//        int result = Short.compare(areaCode, pn.areaCode);
//        if (result == 0)  {
//            result = Short.compare(prefix, pn.prefix);
//            if (result == 0)
//                result = Short.compare(lineNum, pn.lineNum);
//        }
//        return result;
//    }

    // 코드 14-3 비교자 생성 메서드를 활용한 비교자 (92쪽)
    private static final Comparator<PhoneNumber14> COMPARATOR =
            comparingInt((PhoneNumber14 pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber14 pn) {
        return COMPARATOR.compare(this, pn);
    }

    private static PhoneNumber14 randomPhoneNumber() {
        Random rnd = ThreadLocalRandom.current();
        return new PhoneNumber14((short) rnd.nextInt(1000),
                (short) rnd.nextInt(1000),
                (short) rnd.nextInt(10000));
    }

    public static void main(String[] args) {
        NavigableSet<PhoneNumber14> s = new TreeSet<PhoneNumber14>();
        for (int i = 0; i < 10; i++)
            s.add(randomPhoneNumber());
        System.out.println(s);
    }
}
