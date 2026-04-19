/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Sehre ait verileri tutar ve bu verilere ait iç hesaplamaları (bölünme vb) yapar.
* </p>
*/

package modeller;

import java.util.List;

import araclar.FakeDataUretici;

import java.util.ArrayList;

public class Sehir extends Yerleske {

	// nüfus artışı = onlar + birler
	private int getNufusArtisOrani() {
		short onlar, birler;
		onlar = (short) ((nufus % 100) / 10);
		birler = (short) (nufus % 10);
		return onlar + birler;
	}

	private List<Ilce> ilceler;

	public List<Ilce> getIlceler() {
		return ilceler;
	}

	public Sehir(int nufus) {
		super(FakeDataUretici.getSehirAd(), nufus); // Sehir adi nufusu atamasi
		ilceler = new ArrayList<Ilce>();
	}

	public void ilceEkle(Ilce ilce) {
		if (ilce == null)
			return;
		ilceler.add(ilce);
	}

	public void ilceSil(Ilce ilce) {
		if (ilce == null || ilceler.isEmpty())
			return;
		ilceler.remove(ilce);
	}

	// son elemanı siler ve return eder
	public Ilce popIlce() {
		if (ilceler == null || ilceler.isEmpty()) {
			return null;
		}
		// son elemanı listeden sil ve return et
		return ilceler.remove(ilceler.size() - 1);
	}

	public void yaslandir() {
		for (Ilce ilce : ilceler) {
			ilce.yaslandir();
		}
	}

	// artış oranına göre hesaplaması için bir alt sınıfın metodunu çağırır dönen
	// değerleri toplar
	public void nufusArttir() {
		int toplamNufus = 0;
		int artisOrani = getNufusArtisOrani();

		// her bir ilçe kendi nüfusunu hesaplar ve döndürür
		for (Ilce ilce : ilceler) {
			toplamNufus += ilce.nufusArttir(artisOrani);
		}

		nufus = toplamNufus; // yeni nüfus
	}

	// ilçelerinin nüfuslarını toplar ve yeni nüfusu hesaplar
	public void nufusGuncelle() {
		int toplamNufus = 0;

		// her bir ilçe kendi nüfusunu hesaplar ve döndürür
		for (Ilce ilce : ilceler) {
			toplamNufus += ilce.nufusGuncelle();
		}

		nufus = toplamNufus; // yeni nüfus
	}

	// her sınıf kendi toString() metodunu ekrana bastırır sonra bir altındakini
	// çağırır.
	public void ekranaYazdir() {
		System.out.println(this.toString());
		for (Ilce ilce : ilceler) {
			ilce.ekranaYazdir();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(35);
		return sb.append("Şehir: ").append(ad).append("-").append("Nüfus: ").append(nufus).toString();
	}

	public boolean dortBasamakli() {
		return (nufus >= 1000 && nufus < 10000);
	}

	// Yeni bir şehir oluşturup eski şehiri verilen kurala göre bölüştürür
	public Sehir bolun() {
		Sehir yeniSehir = new Sehir(0);
		int ilceSayisi = ilceler.size();

		// 1 ilçe
		if (ilceSayisi == 1) {
			Ilce yeniIlce = ilceler.get(0).bolun();
			yeniSehir.ilceEkle(yeniIlce);
		}

		// 2 veya 2+ ilçe
		else {
			int aktIlceSay = ilceSayisi / 2;

			for (int i = 0; i < aktIlceSay; i++) {
				yeniSehir.ilceEkle(this.popIlce());
			}
		}

		yeniSehir.nufusGuncelle();
		nufusGuncelle();

		return yeniSehir;
	}

}
