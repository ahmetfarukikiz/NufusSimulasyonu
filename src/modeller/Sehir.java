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
	private List<Ilce> ilceler;
	
	public Sehir(int nufus){
		super(FakeDataServis.getSehirAd(),nufus); //Sehir adi atamasi
		ilceler = new ArrayList<Ilce>();
	}
}
