package EX09;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class Item65 {
    /**
     * 리플렉션 보다는 인터페이스를 사용하라
     *
     * 컴파일타임 타입 검사가 주는 이점을 누릴수 없다
     * 코드가 지저분하고 장황해진다
     * 성능이 떨어진다
     *
     * 리플렉션은 아주 제한된 상태로 사용해야 단점을 피하고 이점을 취할 수 있다.
     *
     * 리플렉션은 인스턴스 생성에만 쓰고 이렇게만든 인스턴스는 인터페이스나 상위 클래스로 참조해 사용하자
     */
    public static class ReflectiveInstantiation {
        // 코드 65-1 리플렉션으로 생성하고 인터페이스로 참조해 활용한다. (372-373쪽)
        public static void main(String[] args) {
            // 클래스 이름을 Class 객체로 변환
            Class<? extends Set<String>> cl = null;
            try {
                cl = (Class<? extends Set<String>>)  // 비검사 형변환!
                        Class.forName(args[0]);
            } catch (ClassNotFoundException e) {
                fatalError("클래스를 찾을 수 없습니다.");
            }

            // 생성자를 얻는다.
            Constructor<? extends Set<String>> cons = null;
            try {
                cons = cl.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                fatalError("매개변수 없는 생성자를 찾을 수 없습니다.");
            }

            // 집합의 인스턴스를 만든다.
            Set<String> s = null;
            try {
                s = cons.newInstance();
            } catch (IllegalAccessException e) {
                fatalError("생성자에 접근할 수 없습니다.");
            } catch (InstantiationException e) {
                fatalError("클래스를 인스턴스화할 수 없습니다.");
            } catch (InvocationTargetException e) {
                fatalError("생성자가 예외를 던졌습니다: " + e.getCause());
            } catch (ClassCastException e) {
                fatalError("Set을 구현하지 않은 클래스입니다.");
            }

            // 생성한 집합을 사용한다.
            s.addAll(Arrays.asList(args).subList(1, args.length));
            System.out.println(s);
        }

        private static void fatalError(String msg) {
            System.err.println(msg);
            System.exit(1);
        }
    }
}
