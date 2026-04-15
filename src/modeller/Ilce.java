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

	private List<Mahalle> mahalleler;
	
	public Ilce(int nufus) {
		super(FakeDataServis.getIlceAd(),nufus);
		mahalleler = new ArrayList<Mahalle>();
	}
}
