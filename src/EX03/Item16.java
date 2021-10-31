package EX03;

public class Item16 {
    /**
     * public 클래스에서는 public이 아닌 접근자를 사용해라
     *
     * 패키지 바깥에서 접근할 수 있는 클래스라면 접근자를 제공
     * public은 절대 가변 필드를 직접 노출해선 안된다 - private & package-private사용
     *
     */

    // 코드 16-2 접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화한다. (102쪽)
    class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() { return x; }
        public double getY() { return y; }

        public void setX(double x) { this.x = x; }
        public void setY(double y) { this.y = y; }
    }
    // 코드 16-3 불변 필드를 노출한 public 클래스 - 과연 좋은가? (103-104쪽)
    public final class Time {
        private static final int HOURS_PER_DAY = 24;
        private static final int MINUTES_PER_HOUR = 60;

        public final int hour;
        public final int minute;

        public Time(int hour, int minute) {
            if (hour < 0 || hour >= HOURS_PER_DAY)
                throw new IllegalArgumentException("Hour: " + hour);
            if (minute < 0 || minute >= MINUTES_PER_HOUR)
                throw new IllegalArgumentException("Min: " + minute);
            this.hour = hour;
            this.minute = minute;
        }
    }
}
