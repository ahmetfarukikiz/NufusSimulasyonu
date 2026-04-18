/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Kisiye ait verileri tutar ve bu verilere ait iç hesaplamaları yapar.
* </p>
*/

package modeller;

import araclar.FakeDataUretici;
import araclar.IDGenerator;

public class Kisi {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(35);
		return sb.append("\t").append(id).append("-").append(getAd()).append(getSoyad()).append("-").append(yas)
				.toString();
	}

	// ad ve soyad değerleri sadece kullanılacağı zaman atanıyor (performans için)
	public String getAd() {
//		if (this.ad == null) {
//	        this.ad = FakeDataServis.getKisiAd();
//	    }
		return this.ad;
	}

	public String getSoyad() {
//		if (this.soyad == null) {
//	        this.soyad = FakeDataServis.getKisiSoyad();
//	    }
		return this.soyad;
	}

	public int getYas() {
		return yas;
	}

	public int getId() {
		return id;
	}

	private String ad;
	private String soyad;
	private int yas;
	private int id;

	public Kisi() {
		ad = FakeDataUretici.getKisiAd();
		soyad = FakeDataUretici.getKisiSoyad();
		id = IDGenerator.getNextId(); // rastgele id üretir ()
		yas = FakeDataUretici.getKisiYas();
	}

	public void yaslandir() {
		yas++;
	}

	public void ekranaYazdir() {
		System.out.println(this.toString());
	}
}
