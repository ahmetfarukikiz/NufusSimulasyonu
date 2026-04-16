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
import java.util.Scanner;

import modeller.Sehir;
import servisler.IYazdirici;
import servisler.OyunBaslaticiServis;

public class Oyun {
	private OyunBaslaticiServis oyunBaslaticiServis;
	private IYazdirici yazdirici;
	private int turSayisi;
	private String sayilarString;
	private List<Sehir> sehirler;

	public Oyun(int turSayisi, String sayilarString, IYazdirici yazdirici) {
		this.turSayisi = turSayisi;
		this.sayilarString = sayilarString;
		sehirler = new ArrayList<Sehir>();
		oyunBaslaticiServis = new OyunBaslaticiServis();
		this.yazdirici = yazdirici; //gelen yazdırma nesnesine göre test amaçlı veya gerçek formatta çıktı üretilebilir
		
	}

	public void baslat() {
		sehirler = oyunBaslaticiServis.stringtenYerleskeOlustur(sayilarString);
		
		System.out.println("Başlangıç Durumu:");
		yazdirici.TurYazdir(sehirler);

		// ana loop
		for (int i = 0; i < turSayisi; i++) {
			
			
			
			
			//herkesin yaşını 1 arttırır.
			for(Sehir sehir : sehirler) {
				sehir.yaslandir();
			}
		
		
			System.out.println(i + 1 + ".tur sonu:");
			yazdirici.TurYazdir(sehirler);
			yazdirici.ekraniTemizle();
		}
		
		System.out.println("oyun sonu:");
		yazdirici.TurYazdir(sehirler);
		
		oyunSonuSatirSutunSor();
		
	}
	
	
	
	
	private void oyunSonuSatirSutunSor() {

		Scanner input = new Scanner(System.in);

		int satir, sutun, index;
		
		while(true) {
			System.out.println("Satır Girin:");
			satir = input.nextInt();
			System.out.println("Sütun Girin:");
			sutun = input.nextInt();
			
			index = satir * 5 + sutun; //her satırda 5 eleman var 
			
			if(index < 0 || index >= sehirler.size()) {
				System.out.println("Hatalı index tekrar deneyin.");
				continue;
			}
			
			break;
		}
		
		yazdirici.detayYazdir(sehirler, index);
	}
}
