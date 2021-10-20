package Ex01.TEST;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingleTonSerialTestor {
    public byte[] serialize(Object instance) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (bos; ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(instance);
        } catch (Exception e) {
            // ... 구현 생략
        }
        return bos.toByteArray();
    }

    public Object deserialize(byte[] serializedData) {
        ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
        try (bis; ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        } catch (Exception e) {
            // ... 구현 생략
        }
        return null;
    }

    public static void main(String[] args) {
        SingleTonSerial instance = SingleTonSerial.getInstance();
        SingleTonSerialTestor serializationTester = new SingleTonSerialTestor();
        byte[] serializedData = serializationTester.serialize(instance);
        SingleTonSerial instance2 = (SingleTonSerial)serializationTester.deserialize(serializedData);
        System.out.println("instance = " + instance);
        System.out.println("instance2 = " + instance2);
        System.out.println("instance == instance2 : " + (instance == instance2));
        System.out.println("instance.equals(instance2) : " + (instance.equals(instance2)));
    }
}
