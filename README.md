Büyük Sayılar Hesap Makinesi (Java)

Bu proje, Java dilinde yerleşik veri tiplerinin (int, long vb.) sınırlarını aşan çok büyük sayılarla işlem yapabilen bir hesap makinesidir.

 Not: Bu projede BigInteger sınıfı kullanılmamıştır. Tüm işlemler manuel olarak gerçekleştirilmiştir.

 Projenin Amacı

Java’da bulunan standart veri tipleri belirli bir büyüklüğe kadar sayıları tutabilir.
Bu projede, bu sınırlamaları aşmak için sayılar string (metin) olarak tutulup basamak basamak işlenmiştir.

 Özellikler
Büyük sayılarla toplama işlemi
Büyük sayılarla çıkarma işlemi
 çarpma işlemi
Veri tipi sınırlarından bağımsız çalışma
Manuel hesaplama algoritması (elde mantığı)
Nasıl Çalışır?
Sayılar String olarak alınır
Sağdan sola doğru basamak basamak işlem yapılır
Elde (carry) ve ödünç alma (borrow) işlemleri manuel olarak yönetilir
Sonuç yine string olarak oluşturulur

Bu yöntem, kağıt üzerinde yaptığımız işlemlerin programatik karşılığıdır.

 Kullanım
Projeyi klonla:
git clone <repo-link>
Derle:
javac *.java
Çalıştır:
java Test
Geliştirme Fikirleri
Bölme işlemi eklenmesi
Kullanıcı arayüzü (GUI) geliştirilmesi
Performans iyileştirmeleri
 Not: Bu proje, algoritma mantığını geliştirmek ve düşük seviyede sayı işlemlerini anlamak amacıyla yapılmıştır.
