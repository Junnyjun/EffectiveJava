package Ex01.TEST;

public class StaticFactory implements Cloneable {
    private String name;
    private ProcessHandle.Info info;
    //info라는 가변상태가 있을때, 상위객체의 값이 바뀔수도있다
    // Info info = resourceClone.getInfo(); // 클론객체의 info 객체를 가져와
    //    info.setAge(10);//값을 변경하면?
    //  Clone이 아닌 상태가 되어버리게됩니다!

//    @Override
//    public StaticFactory clone()  {
//        try {
//            return(StaticFactory) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
//
//    @Override
//    public StaticFactory clone()  {
//        try {
//            StaticFactory clone = (StaticFactory) super.clone();
//            clone.info = clone.info.clone(); // 가변상태를 참조하고있는 필드도 복사해서 넘겨주자.
//            return clone;
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
}

