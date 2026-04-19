/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Ilceye ait verileri tutar ve bu verilere ait iç (bölünme vb) hesaplamaları yapar.
* </p>
*/

package modeller;

import java.util.List;

import araclar.FakeDataUretici;

import java.util.ArrayList;

public class Ilce extends Yerleske {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(35);
		return sb.append("İlçe: ").append(ad).append("-").append("Nüfus: ").append(nufus).toString();
	}

	public List<Mahalle> getMahalleler() {
		return mahalleler;
	}

	private List<Mahalle> mahalleler;

	public Ilce(int nufus) {
		super(FakeDataUretici.getIlceAd(), nufus);
		mahalleler = new ArrayList<Mahalle>();
	}

	public void mahalleEkle(Mahalle mahalle) {
		if (mahalle == null)
			return;
		mahalleler.add(mahalle);
	}

	public void mahalleSil(Mahalle mahalle) {
		if (mahalle == null)
			return;
		mahalleler.remove(mahalle);
	}

	public void yaslandir() {
		for (Mahalle mahalle : mahalleler) {
			mahalle.yaslandir();
		}
	}

	public int nufusArttir(int artisOrani) {
		int yeniNufus = 0;
		for (Mahalle mahalle : mahalleler) {
			yeniNufus += mahalle.nufusArttir(artisOrani);
		}
		nufus = yeniNufus;
		return nufus;
	}

	public void ekranaYazdir() {
		System.out.println(this.toString());
		for (Mahalle mahalle : mahalleler) {
			mahalle.ekranaYazdir();
		}

	}

	public int nufusGuncelle() {
		int toplamNufus = 0;

		// her bir ilçe kendi nüfusunu hesaplar ve döndürür
		for (Mahalle mahalle : mahalleler) {
			toplamNufus += mahalle.nufusGuncelle();
		}

		nufus = toplamNufus; // yeni nüfus
		return nufus;
	}

	public Mahalle popMahalle() {
		if (mahalleler == null || mahalleler.isEmpty()) {
			return null;
		}
		// son elemanı listeden sil ve return et
		return mahalleler.remove(mahalleler.size() - 1);
	}

	//tek ilçe olma durumunda yeni şehirde yeni bir ilçe oluşturup bölüştürme işini yapar
	public Ilce bolun() {
		Ilce yeniIlce = new Ilce(0);
		int mahalleSayisi = this.mahalleler.size();

		// 1 ilçe 1 mahalle:
		if (mahalleSayisi == 1) {
			//tek mahalle varsa ilk mahalledir
			Mahalle yeniMahalle = mahalleler.get(0).bolun();
			yeniIlce.mahalleEkle(yeniMahalle);
		}
		// 1 ilçe 2 veya 2+ mahalle
		else {
			int aktMahSay = mahalleSayisi / 2;
			for (int i = 0; i < aktMahSay; i++) {
				yeniIlce.mahalleEkle(this.popMahalle());
			}
		}
		return yeniIlce;
	}

}
