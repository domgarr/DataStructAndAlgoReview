public class Test {
    String a;
    String b;

    public Test(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
