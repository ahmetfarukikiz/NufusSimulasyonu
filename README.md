# Java ile Nesne Yönelimli Şehir Nüfus Simülasyonu

Bu proje, Sakarya Üniversitesi Bilgisayar Mühendisliği Programlama Dillerinin Prensipleri dersi kapsamında geliştirilmiştir. Temel amacı; Java programlama dili kullanılarak Nesne Yönelimli Programlama (OOP) kavramlarının, SOLID prensiplerinin (SRP, OCP, DIP), "Tell, Don't Ask" yaklaşımlarının uygulamalarını içermektedir.

---

## 📌 Proje Hakkında ve Kurallar

Yazılım, kullanıcıdan alınan iki basamaklı sayılardan oluşan bir string dizisi ve simülasyon tur sayısı üzerinden çalışan, hiyerarşik bir yerleşim yeri simülasyonudur.

Girdi olarak verilen her iki basamaklı sayının özellikleri şu şekilde değerlendirilir:
- **Sayının Kendisi:** Şehrin başlangıç nüfusunu temsil eder.
- **Onlar Basamağı:** Şehirdeki ilçe sayısını temsil eder.
- **Birler Basamağı:** İlçelerdeki mahalle sayısını temsil eder.

### Simülasyon Döngüsü ve İş Mantığı
1. **Veri Dağıtımı:** Mahalle sayısı her ilçeye eşit olarak dağıtılır. Toplam nüfus ise her mahalleye eşit olacak şekilde paylaştırılarak simülasyon başlangıç durumuna getirilir.
2. **Nüfus Artışı:** Her turda şehirlerin nüfusu `Mevcut Nüfus = (Birler Basamağı + Onlar Basamağı) * Mevcut Nüfus` formülüne göre artar. Simülasyondaki kişiler de her turda 1 yıl yaşlanır.
3. **Hiyerarşik Bölünme:** Bir şehrin nüfusu 4 basamaklı sayılara (1000 ve üzeri) ulaştığında hiyerarşik bölünme algoritması tetiklenir. Şehirde birden fazla ilçe varsa; ilçeler tam bölünüyorsa eşit, bölünmüyorsa fazlalık eski şehirde kalacak şekilde, eski şehirdeki ilçeler mahalleleri ve kişileriyle birlikte yeni kurulan şehre aktarılır.
4. **Bölünme Senaryoları:** Algoritma; *Çift Sayıda İlçe, Tek Sayıda İlçe, 1 İlçe Çift Sayıda Mahalle, 1 İlçe Tek Sayıda Mahalle, 1 İlçe 1 Mahalle Çift Nüfus* ve *1 İlçe 1 Mahalle Tek Nüfus* olmak üzere 6 farklı kritik durumu kontrol edecek şekilde tasarlanmıştır.

---

## 🏗 Mimari ve Tasarım Prensipleri

Proje, "Single Responsibility Principle" (SRP) gözetilerek tamamen modüler 5 paket (package) altında yapılandırılmıştır:

- **`araclar/`**: Durum (state) tutmayan, karmaşık hesaplamaları ve girdi dönüşümlerini model ile servislerden soyutlayan statik yardımcı (utility) sınıflar.
- **`main/`**: Programın giriş noktası, global hata kontrolleri ve akış yönetimi.
- **`modeller/`**: Kendi iç verisini yöneten hiyerarşik model sınıfları (`Sehir` -> `Ilce` -> `Mahalle` -> `Kisi`). Nesneler, ortak özellikleri barındıran üst sınıflardan miras almaktadır.
- **`motor/`**: Simülasyon döngüsünü koşturan ana `Oyun` sınıfı ve soyutlama arayüzleri.
- **`servisler/`**: Model nesnelerinin üretim ve yönetim süreçlerini üstlenen, `Oyun` sınıfının yükünü hafifleten alt sistemler (örn. `OyunBaslaticiServis`).

### Uygulanan İleri Seviye Yazılım Pratikleri

* **Tell, Don't Ask:** `Oyun` sınıfı şehir nesnesinden veri alıp dışarıda hesaplama yapmaz. Bölünme ve nüfus artışı gibi tüm iş mantığı verinin doğrudan sahibi olan model sınıflarının kendi metotları içerisinde hiyerarşik olarak çözülür.
* **Dependency Inversion & Loose Coupling:** Çıktı ve analiz süreçleri `IYazdirici` arayüzü (interface) üzerinden soyutlanmıştır. `Oyun` sınıfı hangi yazdırma servisinin çalıştığını bilmez, sadece arayüze bağımlıdır. Bu sayede ödevde istenen standart formatın yanı sıra, detaylı analiz ve hata ayıklama süreçleri için geliştirilen `YazdirTestServis` sisteme `Main` sınıfından dinamik olarak enjekte edilebilmektedir (Dependency Injection).
* **Bellek ve CPU Optimizasyonu:** Simülasyon esnasında on binlerce `Kisi` nesnesi üretilmektedir. `java-faker` kütüphanesinin oluşturacağı I/O ve nesne üretim maliyetini minimuma indirmek amacıyla kişilerin ad ve soyad bilgileri kurucu metotta (constructor) değil, yalnızca ekrana yazdırılmak üzere çağrıldıklarında (lazy loading / on-demand) atanır.

---

## ⚙️ Sistem Gereksinimleri

- Java Development Kit (JDK) 8 veya üzeri
- Apache Maven (Proje ve bağımlılık yönetimi için)

---

## 📦 Bağımlılık Yönetimi (Maven)

Projede rastgele isim ve veri üretimi için kullanılan `java-faker` kütüphanesi Maven aracılığıyla yönetilmektedir. Projeyi yerelinizde derlemeden önce `pom.xml` dosyanızın `<dependencies>` sekmesinde aşağıdaki bağımlılığın yer aldığından emin olun:

```xml
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```

---

## 🚀 Kurulum ve Çalıştırma

Projenizi çalıştırmak için iki farklı alternatif mevcuttur:

### Alternatif A: Derlenmiş Çalıştırılabilir Dosya (Hazır .jar) ile Çalıştırma
1. Jar dosyasını indirin 📥 [indir](https://github.com/ahmetfarukikiz/NufusSimulasyonu/releases/download/v1.0.0/NufusYonetim.jar)
2. Cmd'yi NufusYonetim.jar'ın olduğu dosya yolunda açın.
3. Konsola: ```java -jar NufusYonetim.jar``` yazın.
4. Kararlı bir analiz için tur sayısına 6 dan küçük bir sayı girin (örn: 4)
5. İstenen sayıları "xx xx xx" formatında girin (örn: 21 18 92 41 85 18 49 27)

### Alternatif B: Maven Komut Satırı ile Derleme ve Çalıştırma
Proje kök dizininde terminali açarak aşağıdaki adımları uygulayabilirsiniz:

1. **Projeyi Derlemek ve Paketlemek:**
   ```bash
   mvn clean install
   ```
2. **Projeyi Ana Sınıf Üzerinden Başlatmak:**
   ```bash
   mvn exec:java -Dexec.mainClass="main.Main"
   ```
   *(Not: Projenizin paket yapısına göre ana sınıf yolunu `main.Main` yerine kendi tanımladığınız paket yoluyla güncelleyebilirsiniz.)*

---

## 👨‍💻 Geliştirici

**Ahmet Faruk İKİZ**
Sakarya Üniversitesi - Bilgisayar Mühendisliği (B241210040)
