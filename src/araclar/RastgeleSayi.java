/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 13.04.2026
* <p>
* Random kütüphanesini saran wrapper class. Ayrıca benzersiz id üretimi sağlar.
* </p>
*/

package araclar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class RastgeleSayi {
	private static final Set<Integer> IDlist = new HashSet<>();
	
	private static final Random rastgele = new Random();
	
	public static int getNextId() {
		int yeniId;
		
		do {
			yeniId = 1000 + rastgele.nextInt(10000);
		}while(IDlist.contains(yeniId));
		
		IDlist.add(yeniId);
		return yeniId;
	}
	
	public static int getYas() {
		return rastgele.nextInt(101);
	}
}
