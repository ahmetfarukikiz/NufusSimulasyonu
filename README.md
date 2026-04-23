# Ödevde İstenenler:

* Ödevde bir string dizisi şeklinde alınan 2 basamaklı sayıların kendisi, birler ve onlar basamağı gibi özelliklerinden her biri şehirdeki nüfus (kendisi),
ilçe (onlar) ve mahalle (birler) sayısını temsil etmektedir. Bu sayılar parçalanarak, şu kurallar: 
“Mahalle sayısı, her ilçede eşit olacak şekilde dağılabilir. Toplam nüfus, her mahallede eşit olacak şekilde dağılabilir.” 
garanti edilecek şekilde tekrardan hesaplanarak simülasyonun başlangıcına uygun hale getirilmesi gerekmektedir. Hesaplanan sayılar 
sonucunda java-faker kütüphanesi yardımıyla rastgele değerli Sehir, Ilce, Mahalle, Kisi sınıfları oluşturulacaktır. 

* Ardından başlangıçta kullanıcıdan alınan tur sayısı kadar simülasyon yürütülecektir. Her tur için kişiler 1 yıl yaşlanacaktır 
ve şehrin nüfusu “mevcutNüfus = (birler+onlar) * mevcutNüfus” kuralına göre artacaktır. Her tur sonuna gelindiğinde şehrin 
nüfusu 4 basamaklı olduysa bölünecektir. Şehirde birden çok ilçe varsa; bu ilçeler tam bölünüyorsa eşit, bölünmüyorsa fazlalık 
eski şehirde kalacak şekilde eski şehirdeki ilçeler yeni şehire mahalleleri ve kişileriyle beraber aktarılmalıdır. 

# Ödevde Uyguladığım Yaklaşım:

* Görülebileceği üzere aslında ödev birçok farklı aşamadan meydana gelmektedir. 
Bu aşamaları tek bir sınıfa yığmak kodun yazılışı ve anlaşılmasını epey zorlaştıracaktır. 
Ödevi geliştirirken SRP ve modülerlik açısından pek çok servis ve araç sınıfından yararlandım. 
Modellerin kendi iç hesaplamalarını dışa yansıtmayarak ve yapılan işlemleri hiyerarşik bir şekilde ileterek
Oyun sınıfını daha temiz ve anlaşılabilir kıldım. 

* Ödevde istenen yazdırma formatının yanında programı test etmek ve verileri daha detaylı incelemek için
  YazdirTestServis isminde bir servis daha yazdım. Oyun sınıfını IYazdirici interface'ine bağımlı kılarak
  esnek bir yapı kurdum. Bu loose coupling yapı sayesinde Oyun sınıfı yazdırma servislerini tanımıyor sadece
  kullanacağı metotları biliyor. İstenilen yazdırma sınıfı main sınıfından dependency injection şeklinde aktarılıyor,
  SOLID prensiplerinden DIP'yi başarıyla gerçekleştiriyor.

 ### Modülerlik

*	Araclar: İçerisinde durum tutmayan karışık hesaplamaları ve kodları servis sınıflarından soyutlayan statik metotlara sahip util sınıflarını barındırır.
*	Main: Main sınıfı.
*	Motor: Oyun sınıfını ve bu sınıfın kullanacağı interfaceleri barındırır.
*	Modeller: İçerisinde veri tutan ve kendi iç verilerini yöneten model sınıflarını barındırır.
*	Servisler: Oyun sınıfının görev yükünü hafifleterek mödülerlik sağlayan alt yönetim sınıfları.



# Öğrendiklerim
* Bu ödevde SOLID prensiplerinden özellikle SRP, O/CP ve DIP üzerine pratik yapmış oldum. Ayrıca derste öğrendiğimiz tam sayı bölmesi, dizi indexi hesaplama, modüler döngüsel index arttırma, nesne referans gibi kavramları projede kullanarak pekiştirdim. Ayrıca java.util.list gibi hazır veri yapısı kütüphanelerini gerçek bir projede kullanmış oldum. Ödevi araştırırken simple factory design, tell don’t ask, Dependency Inversion gibi kavramları öğrendim. 
