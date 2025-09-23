public class Test {
    public static void main(String[] args) {
        BuyukSayi s1 = new BuyukSayi("-6554654132134654870,005460047");
        BuyukSayi s2 = new BuyukSayi("214543546589764770,000254766577");
        BuyukSayi s = Islem.carp(s1, s2);
        System.out.println("1. Sayı : " + s1.toString());
        System.out.println("2. Sayı : " + s2.toString());
        System.out.println("SONUÇ   : " + s.toString());
    }
}