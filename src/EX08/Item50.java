package EX08;

import java.sql.Date;
import java.time.Period;

public class Item50 {
    /**
     * 적시에  방어적 복사본을 만들라
     *
     * 클라이언트가 불변식을 꺠드리려 혈안이 되어 있다고 가정하고 방어적으로 프로그래밍 한다.
     * 생성자에서 받은 가변 매개변수 각가을 방어적으로 복사해야한다
     *
     *매개변수가 제 3자에 의해 확장될 수 있는 타입이라면 방어적 복사본을 만들 떄 clone을 사용해선 안된다.
     *
     * 클라이언트로 반환하는 구성요소가 가변이라면 그 요소는 반드시 방어적으로 복사해야 한다.
     *
     */
    public final class Period {
        private final Date start;
        private final Date end;

        /**
         * @param  start 시작 시각
         * @param  end 종료 시각. 시작 시각보다 뒤여야 한다.
         * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
         * @throws NullPointerException start나 end가 null이면 발생한다.
         */
        public Period(Date start, Date end) {
            if (start.compareTo(end) > 0)
                throw new IllegalArgumentException(
                        start + "가 " + end + "보다 늦다.");
            this.start = start;
            this.end   = end;
        }

        public Date start() {
            return start;
        }
        public Date end() {
            return end;
        }

        public String toString() {
            return start + " - " + end;
        }


        public static void main(String[] args) {
            // 코드 50-2 Period 인스턴스의 내부를 공격해보자. (303쪽)
            Date start = new Date();
            Date end = new Date();
            Period p = new Period(start, end);
            end.setYear(78);  // p의 내부를 변경했다!
            System.out.println(p);

            // 코드 50-4 Period 인스턴스를 향한 두 번째 공격 (305쪽)
            start = new Date();
            end = new Date();
            p = new Period(start, end);
            p.end().setYear(78);  // p의 내부를 변경했다!
            System.out.println(p);
        }
}
