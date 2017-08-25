import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//2.2. Напишите консольное приложение, которое:
//        - описывает некоторый класс с полями целого типа и различным доступом,
//        несколько конструкторов с параметрами, методы доступа (геттеры и
//        сеттеры);
//        - создает экземпляр описанного класса через механизм рефлексии (любым
//        конструктором);
//        - отображает информацию о состоянии созданного экземпляра через
//        рефлексию;
//        - изменяет состояние экземпляра динамическим вызовом одного из
//        методов доступа.
//        ТРЕБОВАНИЯ.
//        1. Приложение должно быть написано на языке Java.
//        2. Использовать только стандартные компиляторы и библиотеки.
//        3. При кодировании должны быть использованы соглашения об
//        оформлении кода для языка Java.
//        4. Информация об экземпляре должна быть выведена в консоль после
//        создания и изменения.

public class Task4_2_2 {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {


        Point point = createPoint();
        ;
        System.out.println(point);

        System.out.println(objectInfo(point));

        newFields(point, 3, 3);

        System.out.println(point);
        System.out.println(objectInfo(point));

    }

    public static Point createPoint() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        return Point.class.getDeclaredConstructor(new Class[]{double.class, double.class}).newInstance(2, 2);
    }

    public static String objectInfo(Point point) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {

        String result;

        Method method1 = Point.class.getDeclaredMethod("getX");
        double x = (double) method1.invoke(point);

        Method method2 = Point.class.getDeclaredMethod("getY");
        double y = (double) method2.invoke(point);

        Method method3 = Point.class.getDeclaredMethod("getZ");
        method3.setAccessible(true);
        double z = (Double) method3.invoke(point);

        Method method4 = Point.class.getDeclaredMethod("summ");
        method4.setAccessible(true);
        double sum = (double) method4.invoke(point);

        result = "Point:  X: " + x + " Y: " + y + " Z: " + z + " SUMMA " + sum;

        return result;
    }

    public static boolean newFields(Point point, double y, double z) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Method method1 = Point.class.getDeclaredMethod("setZ", double.class);
        method1.setAccessible(true);
        method1.invoke(point, z);

        Field field = Point.class.getDeclaredField("y");
        field.setAccessible(true);
        field.setDouble(point, y);

        return false;
    }
}

class Point {
    private final double x;
    private final double y;
    private double z;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double summ() {
        return (this.x + this.y);
    }

    @Override
    public String toString() {
        return "Point (X=" + x + ", Y=" + y + ", Z=" + z + ")";
    }
}