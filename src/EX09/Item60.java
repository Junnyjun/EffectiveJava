package EX09;

import java.math.BigDecimal;

public class Item60 {
    /**
     * 정확한 답이 필요하다면 float과 double은 피하라.
     *
     * 이 두타입은 특히 금융관련된 계산에서는 맞지않는다.
     *  금웅계산에서는 BigDecimal , int , Long을 사용해야한다.
     *
     *  BigDecimal은 불편하고 느리다.
     *  int 와 long을 먼저 사용해본 후 BigDecimal의 사용을 고려하라.
     */


    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(달러): " + funds);
    }
}
