/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 16.04.2026
* <p>
* Aldığı sehir sınıfının verilerini uygun formatta yazdıran servis sınıfı
* </p>
*/

package servisler;

import java.util.List;

import modeller.Sehir;

public final class YazdirServis implements IYazdirici {

	// her tur sonu şehirlerin nüfusunu ekrana [xx]-[xx] formatında basar
	@Override
	public void TurYazdir(List<Sehir> sehirler) {

		int kapasite = sehirler.size() * 10;
		StringBuilder sb = new StringBuilder(kapasite);

		int i = 1; // sütun sayacı
		for (Sehir sehir : sehirler) {
			sb.append("[").append(sehir.getNufus()).append("]");

			// satır sonu veya eleman sonu değilse - koy
			if (i % 5 != 0 && i != sehirler.size())
				sb.append("-");
			// 5 eleman sonra alt satıra geç
			if (i % 5 == 0)
				sb.append("\n");

			i++;
		}

		System.out.println(sb.toString());
	}

	// oyun sonu seçilen satır ve sütuna göre ekrana yazma işlemi yapar
	@Override
	public void detayYazdir(List<Sehir> sehirler, int index) {
		// TODO oyun sonu seçilen satır ve sütuna göre ekrana yazma işlemi yapılacak
		while(true) {			
			sehirler.get(index).ekranaYazdir();
			break;
		}
	}

	//windows cmd için ekranı temizleyen metot
	@Override
	public void ekraniTemizle() {
		try {
			// ekranı temizle (cmd için)
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
		}
	}

}
