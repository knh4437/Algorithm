public class test {

    public static void main(String[] args) {
        System.out.println(Holder.Inner.num);
    }

}

class Holder {
    static class Inner {
        static int num=1;
    }
}