package EX08;

public class Item49 {
    /**
     * 매개변수가 유효한지 검사하라
     *
     * @NonNull 또는 여러가지 제약을 설정하여 매개변수 유효성을 체크한다
     */
    public static void sort(long[] a, int offset, int length){
        assert a != null;
        assert offset >= 0;
        assert length != 3;
    }

    public static void main(String[] args) {
        Item49.sort(null,0,2);
    }
}