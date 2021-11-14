package EX05;

import java.util.*;

public class Item31 {
    /**
     * 한정적와일드 카드를 사용해 API 유연성을 높여라
     *
     * 한정적 와일드 카드 ? < ? extend E>
     *    하위타입을 포함하여 지정할 수 있다.
     *
     *
     * 메서드 선언에 타입매개변수가 한번만 나오면 와일드 카드로 대체하라.
     *
     *
     */


    public static class Stack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        // 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)
        // 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
        // 따라서 타입 안전성을 보장하지만,
        // 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
        @SuppressWarnings("unchecked")
        public Stack() {
            elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public E pop() {
            if (size==0)
                throw new EmptyStackException();
            E result = elements[--size];
            elements[size] = null; // 다 쓴 참조 해제
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size)
                elements = Arrays.copyOf(elements, 2 * size + 1);
        }

//    // 코드 31-1 와일드카드 타입을 사용하지 않은 pushAll 메서드 - 결함이 있다! (181쪽)
//    public void pushAll(Iterable<E> src) {
//        for (E e : src)
//            push(e);
//    }

        // 코드 31-2 E 생산자(producer) 매개변수에 와일드카드 타입 적용 (182쪽)
        public void pushAll(Iterable<? extends E> src) {
            for (E e : src)
                push(e);
        }

//    // 코드 31-3 와일드카드 타입을 사용하지 않은 popAll 메서드 - 결함이 있다! (183쪽)
//    public void popAll(Collection<E> dst) {
//        while (!isEmpty())
//            dst.add(pop());
//    }

        // 코드 31-4 E 소비자(consumer) 매개변수에 와일드카드 타입 적용 (183쪽)
        public void popAll(Collection<? super E> dst) {
            while (!isEmpty())
                dst.add(pop());
        }

        // 제네릭 Stack을 사용하는 맛보기 프로그램
        public  void main(String[] args) {
            Stack<Number> numberStack = new Stack<>();
            Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
            numberStack.pushAll(integers);

            Collection<Object> objects = new ArrayList<>();
            numberStack.popAll(objects);

            System.out.println(objects);
        }

        public static class Swap {
            public static void swap(List<?> list, int i, int j) {
                swapHelper(list, i, j);
            }

            // 와일드카드 타입을 실제 타입으로 바꿔주는 private 도우미 메서드
            private static <E> void swapHelper(List<E> list, int i, int j) {
                list.set(i, list.set(j, list.get(i)));
            }

            public static void main(String[] args) {
                // 첫 번째와 마지막 인수를 스왑한 후 결과 리스트를 출력한다.
                List<String> argList = Arrays.asList(args);
                swap(argList, 0, argList.size() - 1);
                System.out.println(argList);
            }
        }
    }
}
