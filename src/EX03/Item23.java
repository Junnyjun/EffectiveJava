package EX03;

public class Item23 {
    /**
     * 태그 달린 클래스보다는 클래스 계층구조를 활용하라
     *
     * 태그달린 클래스의 단점을 모두 해결
     *
     */
}

class Circle extends Figure {
    final double radius;

    Circle(double radius) { this.radius = radius; }

    @Override double area() { return Math.PI * (radius * radius); }
}
abstract class Figure {
    abstract double area();
}
class Rectangle extends Figure {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width  = width;
    }
    @Override double area() { return length * width; }
}
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}