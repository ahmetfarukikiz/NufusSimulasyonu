/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Mahalleye ait verileri tutar ve bu verilere ait iç hesaplamaları yapar.
* </p>
*/

package modeller;

import java.util.ArrayList;
import java.util.List;

import araclar.FakeDataUretici;

public class Mahalle extends Yerleske {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(35);
		return sb.append("Mahalle: ").append(ad).append("-").append("Nüfus: ").append(nufus).toString();
	}

	public List<Kisi> getKisiler() {
		return kisiler;
	}

	private List<Kisi> kisiler;

	public Mahalle(int nufus) {
		super(FakeDataUretici.getMahalleAd(), nufus);
		this.kisiler = new ArrayList<Kisi>();
	}

	public void kisiEkle(Kisi kisi) {
		if (kisi == null)
			return;
		kisiler.add(kisi);
	}

	public void kisiSil(Kisi kisi) {
		if (kisi == null)
			return;
		kisiler.remove(kisi);
	}

	public void yaslandir() {
		for (Kisi kisi : kisiler) {
			kisi.yaslandir();
		}
	}

	public void ekranaYazdir() {
		System.out.println(this.toString());
		System.out.println("Kişiler:");
		for (Kisi kisi : kisiler) {
			kisi.ekranaYazdir();
		}
	}

	public int nufusArttir(int artisOrani) {
		int eklenecekKisiSayisi, yeniNufus;
		if (artisOrani == 0) {
			eklenecekKisiSayisi = 1;
			yeniNufus = nufus + 1;
		} else {
			int eskiNufus = nufus;
			yeniNufus = artisOrani * nufus;
			eklenecekKisiSayisi = yeniNufus - eskiNufus;
		}

		// TODO
//		if (kisiler instanceof ArrayList) {
//		    ((ArrayList<Kisi>) kisiler).ensureCapacity(yeniNufus);
//		}

		for (int i = 0; i < eklenecekKisiSayisi; i++) {
			kisiler.add(new Kisi());
		}

		nufus = yeniNufus;
		return nufus;
	}

	public int nufusGuncelle() {
		nufus = kisiler.size(); // yeni nüfus
		return nufus;
	}

}
