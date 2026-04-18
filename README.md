#  Taş-Kağıt-Makas Oyunu (C Programlama)

Bu proje, C dili ile terminal (komut satırı) üzerinden oynanabilen klasik bir Taş-Kağıt-Makas oyunudur. Kullanıcı, bilgisayarın rastgele yaptığı seçimlere karşı oynar ve sonuç anlık olarak ekranda gösterilir.

##  Özellikler

* **Rastgele Bilgisayar Hamlesi:** Bilgisayar, `srand` ve `time` fonksiyonlarını kullanarak her defasında tahmin edilemez, tamamen rastgele bir seçim yapar.
* **Oyun Mantığı Algoritması:** Taşın makası, makasın kağıdı ve kağıdın taşı yendiği standart kurallar, modüler bir `game()` fonksiyonu içerisinde kontrol edilir.
* **Hızlı ve Hafif:** Sadece standart C kütüphaneleri kullanılarak geliştirilmiş, CLI (Command Line Interface) tabanlı hızlı bir yapıdadır.

##  Kullanılan Teknolojiler

* **C Programlama Dili**
* **Kullanılan Kütüphaneler:** `<stdio.h>`, `<stdlib.h>`, `<time.h>`, `<math.h>`

## Kurulum ve Derleme

Projeyi bilgisayarınızda çalıştırmak için bir C derleyicisine (örneğin GCC veya MinGW) ihtiyacınız vardır. Terminali veya komut satırını açıp proje klasörüne gidin ve şu komutu çalıştırarak kodu derleyin:

```bash
gcc tas-kagit-makas.c -o oyun
(Not: C dosyanızın adı farklıysa tas-kagit-makas.c kısmını kendi dosya adınızla değiştirin.)

 Kullanım
Derleme işlemi bittikten sonra oyunu başlatmak için bulunduğunuz terminalde şu komutu girin:

Windows için: oyun.exe

Mac/Linux için: ./oyun

Ekranda sizden bir seçim yapmanız istenecek. Klavyeden ilgili harfi büyük olarak girin ve Enter'a basın:

Taş için: T

Kağıt için: K

Makas için: M

Oyun sonucu (Kazandın, Kaybettin veya Berabere) ve bilgisayarın seçimi ekranda belirecektir.

 Notlar
Büyük Harf Duyarlılığı: Oyun kod yapısı gereği harf girişlerinde büyük/küçük harf duyarlılığına sahiptir. Lütfen seçimlerinizi yaparken büyük harf (T, K, M) kullanmaya özen gösterin. Küçük harf girilmesi durumunda program eşleştirme yapamayacağı için varsayılan olarak "Berabere" sonucunu verebilir.
