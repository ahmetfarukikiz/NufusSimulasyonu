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
		if (sehirler == null || sehirler.isEmpty())
			return;

		System.out.println("--- Yaş Artış TESTI ---");

		Sehir ilkSehir = sehirler.get(0);

		List<Ilce> ilceler = ilkSehir.getIlceler();
		if (ilceler != null && !ilceler.isEmpty()) {

			List<Mahalle> mahalleler = ilceler.get(0).getMahalleler();
			if (mahalleler != null && !mahalleler.isEmpty()) {

				List<Kisi> kisiler = mahalleler.get(0).getKisiler();

				int gosterilecekSayi = Math.min(10, kisiler.size());
				for (int i = 0; i < gosterilecekSayi; i++) {
					Kisi k = kisiler.get(i);
					System.out.println((i + 1) + ". Kişi (ID: " + k.getId() + ") Güncel Yaşı: " + k.getYas());
				}
			}
		}
		System.out.println("-----------------------");
	}

	@Override
	public void detayYazdir(List<Sehir> sehirler, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ekraniTemizle() {
		// TODO Auto-generated method stub

	}

}
