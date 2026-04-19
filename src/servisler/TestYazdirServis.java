/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 17.04.2026
* <p>
* Programın geliştirme aşamasında farklı çıktılarını gözlemleyerek debug sürecini hızlandırması 
* için yazılmış bir test sınıfıdır. 
* maindeki Oyun() constructorına parametre olarak gönderilerek test aşaması başlatılabilir
* Gerçek simülasyon sırasında KULLANILMAMALIDIR. 
* </p>
*/

package servisler;

import java.util.List;

import modeller.*;
import motor.IYazdirici;

public class TestYazdirServis implements IYazdirici {

	@Override
	public void TurYazdir(List<Sehir> sehirler) {
        System.out.printf("%-15s | %-8s | %-6s | %-6s\n", "Şehir Adı", "Nüfus", "İlçe", "Mahalle");
        System.out.println("--------------------------------------------------");

        for (Sehir sehir : sehirler) {
            int toplamMahalle = 0;
            for (Ilce ilce : sehir.getIlceler()) {
                toplamMahalle += ilce.getMahalleler().size();
            }

            // Şehir özeti: Nüfus, ilçe sayısı ve toplam mahalle sayısı
            System.out.printf("%-15s | %-8d | %-6d | %-6d\n", 
                sehir.getAd(), 
                sehir.getNufus(), 
                sehir.getIlceler().size(), 
                toplamMahalle);
        }
        System.out.println("=====================================\n");
	}

	@Override
	public void detayYazdir(List<Sehir> sehirler, int index) {
		Sehir sehir = sehirler.get(index);
        System.out.println(">>> SEÇİLEN ŞEHİR DERİN ANALİZİ <<<");
        System.out.println("Şehir: " + sehir.getAd() + " (Toplam Nüfus: " + sehir.getNufus() + ")");
        
        for (Ilce ilce : sehir.getIlceler()) {
            System.out.println("  └── [İlçe] " + ilce.getAd() + " (Nüfus: " + ilce.getNufus() + ")");
            for (Mahalle mahalle : ilce.getMahalleler()) {
                System.out.println("      └── [Mahalle] " + mahalle.getAd() + 
                                   " (Nüfus/Kişi: " + mahalle.getKisiler().size() + ")");
                
                // Eğer nüfus çok azsa (test aşamasında) kişileri de görmek istersen:
                if (mahalle.getKisiler().size() <= 10) {
                    mahalle.ekranaYazdir();
                }
            }
        }
	}

	@Override
	public void ekraniTemizle() {
		// turların gözükebilmesi için ekran temizlenmiyor.
	}

}
