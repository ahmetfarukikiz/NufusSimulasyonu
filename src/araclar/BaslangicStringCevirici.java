/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 18.04.2026
* <p>
* Kullanıcıdan alınan string verisini OyunBaşlatıcıServis'in kullanabileceği int[] türüne dönüştürür.
* </p>
*/

package araclar;

public final class BaslangicStringCevirici {

	// string halinde gelen veriyi sayı dizisine çevirir
	public static int[] stringiSayiyaCevir(String sayilarString) {
		String[] sayiStDizi = sayilarString.split(" ");

		// üzerinde hesaplama yapacağımız sayı dizisi
		int[] sayiDizi = new int[sayiStDizi.length];

		for (int i = 0; i < sayiStDizi.length; i++) { // stringleri sayılara çevirme 12 43 21
			sayiDizi[i] = Integer.parseInt(sayiStDizi[i]);
		}
		return sayiDizi;
	}

}
