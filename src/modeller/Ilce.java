/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Ilceye ait verileri tutan model sınıfı
* </p>
*/

package modeller;

import java.util.List;
import java.util.ArrayList;
import servisler.FakeDataServis;

public class Ilce extends Yerleske {
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(35);
		return sb.append("İlçe: ").append(ad).append("-").append("Nüfus: ").append(nufus).toString();
	}

	public List<Mahalle> getMahalleler() {
		return mahalleler;
	}

	private List<Mahalle> mahalleler;
	
	public Ilce(int nufus) {
		super(FakeDataServis.getIlceAd(),nufus);
		mahalleler = new ArrayList<Mahalle>();
	}
	
	public void mahalleEkle(Mahalle mahalle) {
		if(mahalle == null) return;
		mahalleler.add(mahalle);
	}
	
	public void mahalleSil(Mahalle mahalle) {
		if(mahalle == null) return;
		mahalleler.remove(mahalle);
	}
	
	public void yaslandir() {
		for(Mahalle mahalle : mahalleler) {
			mahalle.yaslandir();
		}
	}

	public void ekranaYazdir() {
		System.out.println(this.toString());
		for(Mahalle mahalle : mahalleler) {
			mahalle.ekranaYazdir();
		}
		
	}
	
}
