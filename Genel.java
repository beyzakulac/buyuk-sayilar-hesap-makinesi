public class Genel {
    public static final String RAKAMLAR = "0123456789";

    public static String Temizle(String sayi){
        // Bir string içinde sayı ile ilgisiz karakterleri atar
        String sonuc  = "";
        boolean eksi_var = false;
        boolean virgul_var = false;
        boolean rakam_var = false;

        for (int i = 0; i<sayi.length(); i++) {
            char k = sayi.charAt(i);
            if (RAKAMLAR.indexOf(k) < 0) {
                // Rakam değil
                if (k == '-') {
                    if (rakam_var == false && eksi_var == false) {
                        sonuc += "-";
                        eksi_var = true;
                    }
                } else if (k == ',') {
                    if (rakam_var == true && virgul_var == false) {
                        sonuc += ",";
                        virgul_var = true;
                    }                    
                }
            } else {
                // Rakam
                sonuc += "" + k;
                rakam_var = true;
            }
            
        }
        return sonuc;
    }

    public static String SagdanSil(String str, int hane) {
        if (hane <= str.length()) {
            return str.substring(0, str.length() - hane);
        } else {
            return "";
        }
    }

    public static String Tamamla(String str){
        // Sayıyı tamamlar

        String sonuc  = str;

        // Sonda sadece virgül varsa siler
        if (str.charAt(str.length()-1) == ',') {
            sonuc = SagdanSil(sonuc, 1);
        }

        if (str == "-") {
            sonuc = "0";
        }

        return sonuc;
    }

    public static Byte toByte(String str) {
        // String bir değer içindeki rakam değerini döndürür.
        String val = str.trim();
        if (val != null && val.length() > 0) {
            char ch = str.charAt(0);
            if (Character.isDigit(ch)) {
                int numVal = Character.getNumericValue(ch);
                return (byte) numVal;
            }            
        }
        return null;
    }  
}

