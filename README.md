
#  Büyük Sayılar Hesap Makinesi 

Standart veri tiplerinin (örneğin `int` veya `long`) kapasite sınırlarını aşan, çok fazla basamağa sahip devasa sayılarla matematiksel işlemler yapabilmek için geliştirilmiş Java tabanlı bir hesap makinesi uygulamasıdır.

Nesne Yönelimli Programlama (OOP) prensiplerine sadık kalınarak tasarlanmış bu proje, büyük sayıların hafızada tutulması ve işlenmesi süreçlerini kendi içindeki özel modüler sınıflarla yönetir.

## Özellikler

* **Sınırsız Hane Desteği:** İstediğiniz kadar basamağa sahip büyük sayılarla, veri kaybı veya taşma (overflow) hatası yaşamadan güvenle işlem yapabilirsiniz.
* **Aktif Desteklenen İşlemler:**
  * ➕ Toplama
  * ➖ Çıkarma
  * ✖️ Çarpma
* **Modüler Mimari:** Proje; işaret yönetimi (`IsaretTip.java`), işlem atamaları (`Islem.java`) ve büyüklük-küçüklük kıyaslamaları (`KiyasTip.java`) gibi görevleri ayrı dosyalara bölerek genişletilebilir bir altyapı sunar.

##  Kullanılan Teknolojiler

* **Dil:** Java
* **Kavramlar:** Nesne Yönelimli Programlama (OOP), Algoritma Tasarımı

##  Kurulum ve Kullanım

Projenin çalışması için bilgisayarınızda Java Development Kit (JDK) kurulu olmalıdır. Projeyi derleyip çalıştırmak için terminal veya komut satırında şu adımları izleyebilirsiniz:
1. Proje dosyalarının bulunduğu klasöre gidin:
   ```bash
   cd buyuk-sayilar-hesap-makinesi
   ```
Klasördeki tüm Java dosyalarını derleyin:

```bash
javac *.java
```
Test/Ana sınıfı çalıştırarak uygulamayı başlatın:

```bash
java Test
```
 Gelecek Planları (
Proje altyapısı yeni işlemleri destekleyecek şekilde genişletilmeye devam etmektedir. Yakın zamanda eklenecek güncellemeler:
➗ Bölme İşlemi: Büyük sayılar için özel bölme algoritmasının (Long Division) sisteme entegre edilmesi.
