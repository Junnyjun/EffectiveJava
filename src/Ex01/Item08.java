package Ex01;

import java.lang.ref.Cleaner;

public class Item08 {
    public static void main(String[] args) {
        /**
         * finalizer 와 cleaner 사용을 피하라
         *
         * finalizer
         * 예측 불가능 하며 상황에 따라 위험할 수 있어 불필요하다
         *
         * cleaner
         * 예측 불가능 하며 느리고, 불필요하다
         *
         * 이 둘은 제때 실행되어야 하는 작업은 할수없다.
         * ! 상태를 영구적으로 수정하는 작업에서는 절대 사용하지 않는다.
         */
    }

    public static class Room implements AutoCloseable {
        private static final Cleaner cleaner = Cleaner.create();

        // 청소가 필요한 자원. 절대 Room을 참조해서는 안 된다!
        private static class State implements Runnable {
            int numJunkPiles; // Number of junk piles in this room

            State(int numJunkPiles) {
                this.numJunkPiles = numJunkPiles;
            }

            // close 메서드나 cleaner가 호출한다.
            @Override public void run() {
                System.out.println("Cleaning room");
                numJunkPiles = 0;
            }
        }

        // 방의 상태. cleanable과 공유한다.
        private final State state;

        // cleanable 객체. 수거 대상이 되면 방을 청소한다.
        private final Cleaner.Cleanable cleanable;

        public Room(int numJunkPiles) {
            state = new State(numJunkPiles);
            cleanable = cleaner.register(this, state);
        }

        @Override public void close() {
            cleanable.clean();
        }
    }
}
