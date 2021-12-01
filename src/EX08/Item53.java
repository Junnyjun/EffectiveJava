package EX08;

public class Item53 {
    /**
     * 가변 인수는 신중히 사용하라
     *
     * 인수의 개수가 정해지지 않았을 때 아주 유용하다.
     *
     * 성능의 최적화를 할때는 가변인수가 걸림돌이 될 수 있다.
     * 다중정의 메서드의 마지막 부분에 가변인수를 사용하는 패턴을 사용하라
     */
}

class Varargs {
    // 코드 53-1 간단한 가변인수 활용 예 (320쪽)
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

//    // 코드 53-2 인수가 1개 이상이어야 하는 가변인수 메서드 - 잘못 구현한 예! (320쪽)
//    static int min(int... args) {
//        if (args.length == 0)
//            throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
//        int min = args[0];
//        for (int i = 1; i < args.length; i++)
//            if (args[i] < min)
//                min = args[i];
//        return min;
//    }

    // 코드 53-3 인수가 1개 이상이어야 할 때 가변인수를 제대로 사용하는 방법 (321쪽)
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(min(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}