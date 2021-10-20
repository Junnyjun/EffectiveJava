package Ex01;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Item02 {
    public static void main(String[] args) {
        /**
         * 생성자에 매개변수가 많다면 빌더를 고려하라.
         *
         * i ) 점층적 생성자
         *  bad : 쓸수는 있지만 매개변수의 수가 많아지면 코드 가독성이 떨어진다
         * ii ) Setter (java beans)
         *  good : 인스턴스 생성이 쉽고 읽기쉬운코드
         *  bad : 여러 메서드를 호출해야 하며, 객체완성 전에는 일관성이 무너진다.
         *
         * iii ) 빌더 패턴
         *  good :
         *  객체를 직접 만드는 대신 필수 매개변수로 생성자를 호출해 빌더 객체를 얻는다
         *   [ 메서드 연쇄 , 플루언트 API ]
         *  계층적으로 설계된 클래스와 함께 쓰기 좋다.
         *  bad :
         *   빌더의 생성비용, 매개변수의 개수가 충분한지를 확인한다
         */
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
    }
    public static class NutritionFacts {
        private final int servingSize;
        private final int servings;
        private final int calories;
        private final int fat;
        private final int sodium;
        private final int carbohydrate;

        public static class Builder {
            // 필수 매개변수
            private final int servingSize;
            private final int servings;

            // 선택 매개변수 - 기본값으로 초기화한다.
            private int calories = 0;
            private int fat = 0;
            private int sodium = 0;
            private int carbohydrate = 0;

            public Builder(int servingSize, int servings) {
                this.servingSize = servingSize;
                this.servings = servings;
            }

            public Builder calories(int val) {
                calories = val;
                return this;
            }

            public Builder fat(int val) {
                fat = val;
                return this;
            }

            public Builder sodium(int val) {
                sodium = val;
                return this;
            }

            public Builder carbohydrate(int val) {
                carbohydrate = val;
                return this;
            }

            public NutritionFacts build() {
                return new NutritionFacts(this);
            }
        }

        private NutritionFacts(Builder builder) {
            servingSize = builder.servingSize;
            servings = builder.servings;
            calories = builder.calories;
            fat = builder.fat;
            sodium = builder.sodium;
            carbohydrate = builder.carbohydrate;
        }
    }
}
