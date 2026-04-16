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
	private String ad;
	private String soyad;
	private int yas;
	private int id;
	
	public Kisi(){
		ad = FakeDataServis.getKisiAd();
		soyad = FakeDataServis.getKisiSoyad();
		id = RastgeleSayi.getNextId(); //rastgele id üretir ()
		yas = RastgeleSayi.getYas();
	}
}
