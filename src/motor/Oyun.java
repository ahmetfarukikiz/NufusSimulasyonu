/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Oyun döngüsünü ve servis sınıflarını yöneten motor sınıfı
* </p>
*/

package motor;

import java.util.ArrayList;
import java.util.List;

import modeller.Ilce;
import modeller.Sehir;
import servisler.OyunBaslaticiServis;
import servisler.YazdirServis;

public class Oyun {
	private OyunBaslaticiServis oyunBaslaticiServis;
	private int turSayisi;
	private String sayilarString;
	private List<Sehir> sehirler;

	public Oyun(int turSayisi, String sayilarString) {
		this.turSayisi = turSayisi;
		this.sayilarString = sayilarString;
		sehirler = new ArrayList<Sehir>();
		oyunBaslaticiServis = new OyunBaslaticiServis();
	}

	public void baslat() {
		sehirler = oyunBaslaticiServis.stringtenYerleskeOlustur(sayilarString);
		
		//ana loop
		for(int i = 0; i < turSayisi; i++)	{
			YazdirServis.TurYazdir(sehirler);
		}
	}
}
