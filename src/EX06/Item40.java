package EX06;

import java.util.HashSet;
import java.util.Set;

public class Item40 {
    /**
     * @override 를 일관되게 사용하라
     *
     * 상위 클래스를 재정의 할때 사용,
     * 일반클래스 매서드 재정의떄는 X
     *
     *
     */
}

class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first  = first;
        this.second = second;
    }

    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size());
    }
}