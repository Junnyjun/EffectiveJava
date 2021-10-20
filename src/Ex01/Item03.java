package Ex01;

public class Item03 {
    public static void main(String[] args) {
        /**
         *  private 생성자나 열거타입으로 싱글턴을 보증하라.
         *   [ 싱글턴 : 인스턴스를 오직 하나만 생성할 수 있는 클래스 ]
         *   [ 클래스를 싱글턴으로 만들면 테스트가 용이하지 않다 ]
         *
         *   field type
         *   private 생성자는 instance 초기화할 때 딱 한번만 호출된다
         *    이로써 전체 시스템상 유일한 인스턴스임이 보증된다
         *
         *   static factory type ☆☆
         *   싱글턴 방식임이 명백하게 드러난다.
         *   final 필드이니 다른객체를 참조할수 없는 간결성을 가진다.
         *   메서드 참조를 공급자(supplier)로 사용할 수 있다는 점
         *     EX) FACTORY::getInstance -> Supplier<FACTORY></FACTORY>
         *
         *   Enum type
         *   간결하고 추가노력 없이 직렬화 할수 있다.
         *
         */

        // Field 타입
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        // 정적 팩토리 방식
        Elvis2 elvis2 = Elvis2.getInstance();
        elvis.leaveTheBuilding();

        // 이넘 방식
        Elvis3 elvis3 = Elvis3.INSTANCE;
        elvis3.leaveTheBuilding();

    }

    public static class Elvis {
        public static final Elvis INSTANCE = new Elvis();

        private Elvis() {
        }

        public void leaveTheBuilding() {
            System.out.println("Whoa baby, I'm outta here!");
        }

    }

    public static class Elvis2 {
        private static final Elvis2 INSTANCE = new Elvis2();

        private Elvis2() {
        }

        public static Elvis2 getInstance() {
            return INSTANCE;
        }

        public void leaveTheBuilding() {
            System.out.println("Whoa baby, I'm outta here!");
        }

        // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    }
    public enum Elvis3 {
        INSTANCE;

        public void leaveTheBuilding() {
            System.out.println("기다려 자기야, 지금 나갈께!");
        }

    }
}
