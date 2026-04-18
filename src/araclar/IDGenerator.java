/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 13.04.2026
* <p>
* Benzersiz id üretimi sağlar.
* </p>
*/

package araclar;

public final class IDGenerator {
	private static int NextId = 100;

	public static int getNextId() {
		return NextId++; // değeri döner sonra 1 arttırır
	}

}
