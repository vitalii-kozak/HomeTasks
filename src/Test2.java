public class Test2 {
    public static void main(String[] args) {
        String s = "Hello World!";
        String s1 = new String("Hello World!");
        System.out.println(s1.intern());
        System.out.println(s1.intern()==s);
    }
}
