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
		super(FakeDataServis.getSehirAd(),nufus); //Sehir adi atamasi
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


	public void ekranaYazdir() {
		System.out.println(this.toString());
		for(Ilce ilce : ilceler) {
			ilce.ekranaYazdir();
		}
	}	
}
