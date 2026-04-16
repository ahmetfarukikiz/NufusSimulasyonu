/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Mahalleye ait verileri tutan model sınıfı
* </p>
*/



package modeller;

import java.util.ArrayList;
import java.util.List;

import servisler.FakeDataServis;

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
    	super(FakeDataServis.getMahalleAd(),nufus);
        this.kisiler = new ArrayList<Kisi>(); 
    }
    
    public void kisiEkle(Kisi kisi) {
		if(kisi == null) return;
		kisiler.add(kisi);
	}
	
	public void kisiSil(Kisi kisi) {
		if(kisi == null) return;
		kisiler.remove(kisi);
	}
	
	public void yaslandir() {
		for(Kisi kisi : kisiler) {
			kisi.yaslandir();
		}
	}

	public void ekranaYazdir() {
		System.out.println(this.toString());
		System.out.println("Kişiler:");
		for(Kisi kisi : kisiler) {
			kisi.ekranaYazdir();
		}		
	}
}
