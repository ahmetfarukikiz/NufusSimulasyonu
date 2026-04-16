/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Kisilere ait verileri tutan model sınıfı
* </p>
*/

package modeller;

import araclar.RastgeleSayi;
import servisler.FakeDataServis;

public class Kisi {
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(35);
		return sb.append("\t").append(id).append("-").append(ad).append(soyad).append("-").append(yas).toString();
	}

	public String getAd() {
		return ad;
	}

	public String getSoyad() {
		return soyad;
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
	
	public Kisi(){
		ad = FakeDataServis.getKisiAd();
		soyad = FakeDataServis.getKisiSoyad();
		id = RastgeleSayi.getNextId(); //rastgele id üretir ()
		yas = RastgeleSayi.getNextYas();
	}
	
	public void yaslandir() {
		yas++;
	}

	public void ekranaYazdir() {
		System.out.println(this.toString());
	}
}
