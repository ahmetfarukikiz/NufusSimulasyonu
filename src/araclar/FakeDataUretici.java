/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 13.04.2026
* <p>
* Faker kütüphanesini saran ve gerekli bilgileri sınıflara sağlayan wrapper class.
* </p>
*/

package araclar;

import com.github.javafaker.Faker;
import java.util.Locale;

public final class FakeDataUretici {
	private static final Faker faker = new Faker(Locale.of("us"));

	public static String getKisiAd() {
		return faker.name().firstName();
	}

	public static String getKisiSoyad() {
		return faker.name().lastName();
	}

	public static String getSehirAd() {
		return faker.address().state();
	}

	public static String getIlceAd() {
		return faker.address().city();
	}

	public static String getMahalleAd() {
		return faker.address().streetName();
	}

	public static int getKisiYas() {
		return faker.number().numberBetween(0, 51);
	}

}
