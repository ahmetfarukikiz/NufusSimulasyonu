/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 18.04.2026
* <p>
* Aldığı sayıyı başlangıç kuralına göre hesaplayıp döndüren sınıf
* </p>
*/

package araclar;

public final class BaslangicKuralHesaplayici {
	// Mahalleleri ilçelere eşit dağılabilir hale getirir
	public static int gercekSayiHesapla(int sayi) {
		int gercekSayi = sayi;
		short onlar, birler;
		onlar = (short) ((sayi % 100) / 10);
		birler = (short) (sayi % 10);

		while (birler == 0 || birler % onlar != 0) {
			birler = (short) ((birler + 1) % 10);
		}

		gercekSayi = (onlar * 10) + birler;
		return gercekSayi;
	}

	// toplam nüfus sayıyı mahalle sayısına dağılabilir (bölünebilir hale getirir)
	// örn: 18->24 24 % 4 == 0
	public static int gercekNufusHesapla(int nufus, int mahalleSayisi) {
		int gercekNufus = nufus;

		while (gercekNufus % mahalleSayisi != 0) {
			gercekNufus++;
		}

		return gercekNufus;
	}
}
