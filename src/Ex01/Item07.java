package Ex01;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Item07 {
    public static void main(String[] args) {
        /**
         * 다 쓴 객체 참조를 해제하라
         *
         *  객체 참조를 해제하면 가비지 컬렉터는 그 객체가 참조하는 모든 객체를 회수하지 못한다.
         *
         *
         *  ! 비활성 영역의 객체는 null 처리해서 쓰지 않을 것을 명시
         *  ! 자기 메모리를 직접 관리하는 클래스는 항시 메모리 누수에 주의
         *
         *  ## 메모리 , 캐시 , 리스너&콜백은 항상 주의하자자
        */

        // BAD
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }

    public static class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0)
                throw new EmptyStackException();
            return elements[--size];
        }

        /**
         * 원소를 위한 공간을 적어도 하나 이상 확보한다.
         * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
         */
        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }

        public Object pop2() {
            if (size == 0)
                throw new EmptyStackException();
            Object result = elements[--size];
            elements[size] = null; // 다 쓴 참조 해제
            return result;
        }
    }
}
