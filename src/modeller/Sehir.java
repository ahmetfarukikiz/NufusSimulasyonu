/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Sehre ait verileri tutan model sınıfı
* </p>
*/


package modeller;

import java.util.List;

import servisler.FakeDataServis;

import java.util.ArrayList;

public class Sehir extends Yerleske {
	
	//nüfus artışı = onlar + birler 
	private int getNufusArtisOrani() {
		short onlar, birler;
		onlar = (short) ((nufus % 100) / 10);
		birler = (short) (nufus % 10);
		return onlar + birler; 
	}
	
	
	public int getMahalleNufusu() {
		 return ilceler.get(0).getMahalleler().get(0).getKisiler().size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(35);
		return sb.append("Şehir: ").append(ad).append("-").append("Nüfus: ").append(nufus).toString();
	}


	private List<Ilce> ilceler;
	
	public List<Ilce> getIlceler() {
		return ilceler;
	}


	public Sehir(int nufus){
		super(FakeDataServis.getSehirAd(),nufus); //Sehir adi nufusu atamasi
		ilceler = new ArrayList<Ilce>();
	}
	
	
	public void ilceEkle(Ilce ilce) {
		if(ilce == null) return;
		ilceler.add(ilce);
	}
	
	public void ilceSil(Ilce ilce) {
		if(ilce == null) return;
		ilceler.remove(ilce);
	}
	
	public void yaslandir() {
		for(Ilce ilce : ilceler) {
			ilce.yaslandir();
		}
	}

	public void nufusArttir() {
		int toplamNufus = 0;
		int artisOrani = getNufusArtisOrani();
		
		//her bir ilçe kendi nüfusunu hesaplar ve döndürür
		for(Ilce ilce : ilceler) {
			toplamNufus += ilce.nufusArttir(artisOrani);
		}
		
		nufus = toplamNufus; //yeni nüfus
	}	
	
	public void ekranaYazdir() {
		System.out.println(this.toString());
		for(Ilce ilce : ilceler) {
			ilce.ekranaYazdir();
		}
	}

}
