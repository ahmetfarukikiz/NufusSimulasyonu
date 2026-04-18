/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 11.04.2026
* <p>
* Yerlesim birimleriyle ilgili ortak bilgileri tutan model sınıf.
* </p>
*/

package modeller;

public abstract class Yerleske {

	protected String ad;
	protected int nufus;

	Yerleske(String ad, int nufus) {
		this.ad = ad;
		this.nufus = nufus;
	}

	public String getAd() {
		return ad;
	}

	public int getNufus() {
		return nufus;
	}

}
