package EX09;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class Item58 {
    /**
     * 전통적인 for문 보다는 for-each 문을 사용하라.
     *
     * for-each를 사용할 수 없는 경우.
     *
     * 1. 파괴적인 필터링
     *   컬렉션을 순회하며 선택된 원소를 제거할때.
     * 2. 변형
     *   리스트나 배열을 순회하면서, 그원소의 값 일부, 혹은 전부를 교체해야 할때
     * 3. 병렬 반복.
     */

    public static void main(String[] args) throws IOException {
        try (InputStream in = new URL(args[0]).openStream()) {
            in.transferTo(System.out);
        }
    }
}
class RandomBug {
    // 코드 59-1 흔하지만 문제가 심각한 코드! (351쪽)
    static Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    // 무작위 수 1백만 개 생성 후, 중간 값보다 작은 수의 개수 출력 (351쪽)
    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++)
            if (random(n) < n / 2)
                low++;
        System.out.println(low);

    }
}
