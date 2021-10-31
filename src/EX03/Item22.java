package EX03;

public class Item22 {
    /**
     * 인터페이스는 타입을 정의하는 용도로만 사용하라
     *
     * 인터페이스에 상수(static final)로 작성하지 말라
     *
     */
}
// 코드 22-1 상수 인터페이스 안티패턴 - 사용금지! (139쪽)
interface PhysicalConstants {
    // 아보가드로 수 (1/몰)
    static final double AVOGADROS_NUMBER   = 6.022_140_857e23;

    // 볼츠만 상수 (J/K)
    static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;

    // 전자 질량 (kg)
    static final double ELECTRON_MASS      = 9.109_383_56e-31;
}
// 코드 22-2 상수 유틸리티 클래스 (140쪽)
class PhysicalConstants1 {
    private PhysicalConstants1() { }  // 인스턴스화 방지

    // 아보가드로 수 (1/몰)
    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;

    // 볼츠만 상수 (J/K)
    public static final double BOLTZMANN_CONST  = 1.380_648_52e-23;

    // 전자 질량 (kg)
    public static final double ELECTRON_MASS    = 9.109_383_56e-31;
}