/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Oyun döngüsünü ve servis sınıflarını yöneten motor sınıfı
* </p>
*/

package motor;

import servisler.OyunBaslaticiServis;

public class Oyun {
	private OyunBaslaticiServis oyunBaslaticiServis;
	private int turSayisi;
	private String sayilarString;
	
	public Oyun(int turSayisi, String sayilarString){
		this.turSayisi = turSayisi;
		this.sayilarString = sayilarString;
		oyunBaslaticiServis =  new OyunBaslaticiServis();
	}
	
	
	public void baslat() {
		//Oyunun başlangıç kurallarına göre string içindeki sayıları alır organize eder ve modelleri oluşturur ve sehir listesi döndürür
		oyunBaslaticiServis.stringtenYerleskeOlustur(sayilarString);
	}
}
