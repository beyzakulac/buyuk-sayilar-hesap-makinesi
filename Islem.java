import java.util.ArrayList;

public class Islem {

    public static BuyukSayi virgulKaydir(BuyukSayi sayi, int hane) {
        // Büyük sayıdaki virgülü belirtilen hane kadar kaydırarak yeni bir büyük sayı olarak geri döndürür.
        // hane eğer pozitif ise virgül sağa kaydırılır yetersiz gelirse sıfır eklenir.
        // hane eğer negatif ise virgül sola kaydırılır yetersiz gelirse sıfır eklenir.
        ArrayList<Byte> tam = new ArrayList<Byte>();
        ArrayList<Byte> ondalik = new ArrayList<Byte>();
        HaneAdet h = sayi.getHaneAdet();
        if (hane >0) {
            // Sağa kaydır tam kısım 
            for(int i= hane - 1 ; i>=0 ; i-- ) {
                Byte b = sayi.getOndalikRakam(i);
                byte r = b != null ? b : 0;
                tam.add(r);
            }

            for(int i = 0; i < h.getTamAdet();  i++) {
               tam.add(sayi.getTamRakam(i));
            }

           //sağa kaydır kusurat kısım 
           if( hane < h.getOndalikAdet()){
                for(int i=hane; i < h.getOndalikAdet(); i++) {
                    ondalik.add(sayi.getOndalikRakam(i));
                }
           }

    
        } else {
            // Sola Kaydır
            // sola kaydır tam kısım 
            if (-hane < h.getTamAdet()){
                for (int i = -hane; i < h.getTamAdet(); i++){
                    Byte b = sayi.getTamRakam(i);
                    byte r = b != null ? b : 0;
                    tam.add(r);
                }
            }

            // sola kaydır kusurat kısım 
            for(int i= -hane-1 ; i>=0; i--){
                Byte b = sayi.getTamRakam(i);
                byte r = b != null ? b : 0;
                ondalik.add(r);
            }

            for(int i = 0; i < h.getOndalikAdet();  i++ ){
                ondalik.add(sayi.getOndalikRakam(i));
            }

        }
        BuyukSayi sonuc = new BuyukSayi(tam, ondalik, sayi.getIsaret());
        sonuc.sadelestir();
        return sonuc;

    }
    
    public static BuyukSayi mutlakDeger(BuyukSayi sayi){
        BuyukSayi kopya = sayi.getKopya();
        kopya.setIsaret(IsaretTip.Pozitif);
        return kopya;
    }

    public static KiyasTip mutlakKiyasla(BuyukSayi sayi1, BuyukSayi sayi2) {
        // Sayıların mutlak değerlerini alarak kıyaslar
        BuyukSayi m1 = mutlakDeger(sayi1);
        BuyukSayi m2 = mutlakDeger(sayi2);
        return m1.Kiyasla(m2);
    }

    public static BuyukSayi mutlakToplam(BuyukSayi sayi1, BuyukSayi sayi2) {
    
        // Verilen iki BuyukSayi'yı işaretine bakmadan mutlak değerlerini top sonucu yine BuyukSayi olarak döndürür.
        HaneAdet h1 = sayi1.getHaneAdet(); // 1. büyük sayının hane adetlerini elde ediyoruz.
        HaneAdet h2 = sayi2.getHaneAdet(); // 2. büyük sayının hane adetlerini elde ediyoruz.

        int tamhane = h1.getTamAdet() > h2.getTamAdet() ? h1.getTamAdet()+1: h2.getTamAdet()+1;//
        int ondalikhane = h2.getOndalikAdet() > h2.getOndalikAdet() ? h1.getOndalikAdet(): h2.getOndalikAdet();//  1. büyük sayının ondalık hane adedi büyükse ekleğer 2. büyükse ona ekle.
        BuyukSayi sonuc = new BuyukSayi(tamhane, ondalikhane);

        Byte R1=0, R2=0;
        int T=0, R=0, E=0;

        // Kusuratların toplamı
        // ondalık haneleri sondan başla doğru dolaşıyoruz.
        for(int i=ondalikhane-1 ;i>=0;i--){
            Byte b1=sayi1.getOndalikRakam(i); // 1. sayının sıradaki ondalık hanesini byte olarak alıyoruz.
            R1 = b1 != null ? b1 : 0;  //yukarda aldığımız değer null ise 0 değilse kendisini alırız.

            Byte b2=sayi2.getOndalikRakam(i); // 2. sayının sıradaki ondalık hanesini byte olarak alıyoruz.
            R2 = b2 != null ? b2 : 0;//yukarda aldığımız değer null ise 0 değilse kendisini alırız.


            T= R1+R2+E;// aynı hanedeki ondalık rakamları ve bir önceki  işlemden kalan eldeyi topluyoruz.

            if (T > 9) {// eğer toplam çift haneliyse 
                E=T/10;// ilk haneyi elde 
                R=T%10;// sonraki haneyi ise sonuca yazılacak rakam olarak alıryoruz.
            }else{
                E=0;//toplam çift haneli değilse elde yoktur.
                R=T;//tek haneli toplam rakamını sonuca yazıalacak rakam olarak alıyoruz.
            }


            sonuc.setOndalikRakam(i,(byte)R);//sonuca yazılacak rakamı sonuçtaki yerine yazıyoruz. 
        }

        // Tamların toplamı
        for(int i=0 ;i<tamhane-1;i++){
            Byte b1=sayi1.getTamRakam(i); // 1. sayının sıradaki tam hanesini byte olarak alıyoruz.
            R1 = b1 != null ? b1 : 0;  //yukarda aldığımız değer null ise 0 değilse kendisini alırız.

            Byte b2=sayi2.getTamRakam(i); // 2. sayının sıradaki tam hanesini byte olarak alıyoruz.
            R2 = b2 != null ? b2 : 0;//yukarda aldığımız değer null ise 0 değilse kendisini alırız.
            
            T= R1+R2+E;
            if (T > 9) {
                E=T/10;
                R=T%10;
            }else{
                E=0;
                R=T;
            }
            sonuc.setTamRakam(i,(byte)R);
        }
        if (E>0) {
           sonuc.setTamRakam(tamhane-1,(byte)E); 
        }
        sonuc.sadelestir();
        return sonuc;
    }

    public static BuyukSayi mutlakFark(BuyukSayi sayi1, BuyukSayi sayi2) {
        // Verilen iki BuyukSayi'yı işaretine bakmadan büyük olan sayıdan küçükolan sayıyı çıkarır sonucu yine  pozitif BuyukSayi olarak döndürür.
        BuyukSayi m1 = mutlakDeger(sayi1);
        BuyukSayi m2 = mutlakDeger(sayi2);

        BuyukSayi s1 = null;
        BuyukSayi s2 = null;

        if (m1.Kiyasla(m2)==KiyasTip.Buyuk) {
            s1 = m2;
            s2 = m1;
        } else {
            s1 = m1;
            s2 = m2;
        }

        HaneAdet h1 = s1.getHaneAdet(); // büyük mutlak büyük sayının hane adetlerini elde ediyoruz.
        HaneAdet h2 = s2.getHaneAdet(); // küçük mutlak büyük sayının hane adetlerini elde ediyoruz.

        int tamhane = h1.getTamAdet(); //
        int ondalikhane = h1.getOndalikAdet() > h2.getOndalikAdet() ? h1.getOndalikAdet() : h2.getOndalikAdet();
        BuyukSayi sonuc = new BuyukSayi(tamhane, ondalikhane);

        Byte R1=0, R2=0;
        int  C=0, R=0, E=0;

        // Kusuratların çıkarılması.
        // ondalık haneleri sondan başla doğru dolaşıyoruz.
        for(int i = ondalikhane - 1; i>=0 ; i-- ){
            Byte b1 = s1.getOndalikRakam(i); // 1. sayının sıradaki tam hanesini byte olarak alıyoruz.
            R1 = b1 != null ? b1 : 0;  //yukarda aldığımız değer null ise 0 değilse kendisini alırız.
            
            Byte b2 = s2.getOndalikRakam(i); // 2. sayının sıradaki tam hanesini byte olarak alıyoruz.
            R2 = b2 != null ? b2 : 0;//yukarda aldığımız değer null ise 0 değilse kendisini alırız.

            C = R1 - R2 + E;
            if (C < 0 ) {
                C += 10;
                E = -1;
            } else {
                E = 0;
            }
            R = C;
            sonuc.setOndalikRakam(i,(byte)R);
        }
        
        // Tamların çıkarılması
        for (int i = 0; i < tamhane; i++){
            Byte b1 = s1.getTamRakam(i); // 1. sayının sıradaki tam hanesini byte olarak alıyoruz.
            R1 = b1 != null ? b1 : 0;  //yukarda aldığımız değer null ise 0 değilse kendisini alırız.

            Byte b2 = s2.getTamRakam(i); // 2. sayının sıradaki tam hanesini byte olarak alıyoruz.
            R2 = b2 != null ? b2 : 0;//yukarda aldığımız değer null ise 0 değilse kendisini alırız.

            C = R1 - R2 + E;
            if (C < 0){
                C += 10;
                E = -1;
            } else {
                E = 0;
            }
            R = C;
            sonuc.setTamRakam(i,(byte)R);
        }
        sonuc.sadelestir();
        return sonuc;
    
    }

    public static BuyukSayi topla(BuyukSayi sayi1, BuyukSayi sayi2) {

        if (sayi1.getIsaret() == sayi2.getIsaret()) {
            // İşaretler Aynı
            BuyukSayi sonuc = mutlakToplam(sayi1, sayi2);
            sonuc.setIsaret(sayi1.getIsaret());
            return sonuc;

        } else {
            // İşaretler Farklı
            BuyukSayi sonuc = mutlakFark(sayi1, sayi2);
            KiyasTip kiyas = mutlakKiyasla(sayi1, sayi2);
            if (kiyas == KiyasTip.Buyuk) {
                sonuc.setIsaret(sayi2.getIsaret());
            } else if (kiyas == KiyasTip.Kucuk) {
                sonuc.setIsaret(sayi1.getIsaret());
            } else {
                sonuc.setIsaret(IsaretTip.Pozitif);
            }

            return sonuc;           
        }
    }

    public static BuyukSayi cikar(BuyukSayi sayi1, BuyukSayi sayi2) {
        // Verilen ilk BuyukSayi'dan ikinci BuyukSayi'yı çıkarıp sonucu yine BuyukSayi olarak döndürür.
        BuyukSayi s2 = sayi2.getKopya();
        s2.IsaretDegis();
        return topla(sayi1, s2);
    }

    public static BuyukSayi rakamlaCarp(BuyukSayi sayi, int r) {
        // Verilen BuyukSayi'yı tek bir rakamla çarpıp sonucu yine BuyukSayi olarak döndürür.
        HaneAdet h = sayi.getHaneAdet();
        BuyukSayi s1 = virgulKaydir(sayi, h.getOndalikAdet());
        HaneAdet h1 = s1.getHaneAdet();
        BuyukSayi sonuc= new BuyukSayi(h1.getTamAdet()+1,0);

        Byte R1=(byte)r, R2=0;
        int C=0, R=0, E=0;
        for( int i= 0; i<=h1.getTamAdet(); i++){
            Byte b = s1.getTamRakam(i);
            R2 = b != null ? b : 0;
            C=R1*R2+E;
            if(C>9){
                R=C%10;
                E=C/10;
            }else{
                E=0;
                R=C;
            }
            sonuc.setTamRakam(i, (byte)R);
        }
        if(E>0){
            sonuc.setTamRakam(h1.getTamAdet(), (byte)E);
        }
        sonuc.setIsaret(sayi.getIsaret());
        sonuc.sadelestir();
        return virgulKaydir(sonuc, -h.getOndalikAdet());
    }

    public static BuyukSayi carp(BuyukSayi sayi1, BuyukSayi sayi2) {
        // Verilen iki BuyukSayi'yı çarpıp sonucu yine BuyukSayi olarak döndürür.
        HaneAdet h1 = sayi1.getHaneAdet();
        HaneAdet h2 = sayi2.getHaneAdet();
        BuyukSayi s1, s2;
        if (h1.getTamAdet() + h1.getOndalikAdet() > h2.getTamAdet() + h2.getOndalikAdet()) {
            s1 = virgulKaydir(sayi1, h1.getOndalikAdet());
            s2 = virgulKaydir(sayi2, h2.getOndalikAdet());
        } else {
            s1 = virgulKaydir(sayi2, h2.getOndalikAdet());
            s2 = virgulKaydir(sayi1, h1.getOndalikAdet());            
        }
        s1.setIsaret(IsaretTip.Pozitif);
        s2.setIsaret(IsaretTip.Pozitif);

        HaneAdet h = s2.getHaneAdet();
        BuyukSayi sonuc = new BuyukSayi();

        for (int i=0; i < h.getTamAdet(); i++) {
            int R = s2.getTamRakam(i);
            BuyukSayi s = rakamlaCarp(s1, R);
            if (i > 0) {
                sonuc  = topla(sonuc, virgulKaydir(s, i));
            } else {
                 sonuc  = topla(sonuc, s);
            }
        }
        sonuc = virgulKaydir(sonuc, -h1.getOndalikAdet() - h2.getOndalikAdet());
        if (sayi1.getIsaret() == sayi2.getIsaret()) {
            sonuc.setIsaret(IsaretTip.Pozitif);
        } else {
            sonuc.setIsaret(IsaretTip.Negatif);
        }
        sonuc.sadelestir();
        return sonuc;
    } 
    
    public static BuyukSayi bol(BuyukSayi sayi1, BuyukSayi sayi2) {
        // Verilen ilk BuyukSayi'yı ikinci BuyukSayi'ya bölerek sonucu yine BuyukSayi olarak döndürür.

        return null;
    }     
}
