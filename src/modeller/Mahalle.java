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
    private List<Kisi> kisiler;

    public Mahalle(int nufus) {
    	super(FakeDataServis.getMahalleAd(),nufus);
        this.kisiler = new ArrayList<Kisi>(); 
    }
}
