package EX05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Item28 {
    /**
     * 배열보다는 리스트를 사용하라
     *
     * 배열을 사용하면 exception의 발견이 늦어진다.
     *
     * 제너릭은 [](배열)을 허용하지 않는다.
     *
     */
    public static class Chooser<T> {
        private final List<T> choiceList;

        public Chooser(Collection<T> choices) {
            choiceList = new ArrayList<>(choices);
        }

        public T choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceList.get(rnd.nextInt(choiceList.size()));
        }

        public static void main(String[] args) {
            List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

            Chooser<Integer> chooser = new Chooser<>(intList);

            for (int i = 0; i < 10; i++) {
                Number choice = chooser.choose();
                System.out.println(choice);
            }
        }
    }
}
