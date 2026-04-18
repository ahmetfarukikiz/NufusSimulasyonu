/**
*
* @author Ahmet Faruk İkiz faruk.ikiz@ogr.sakarya.edu.tr
* @since 14.04.2026
* <p>
* Ekrana veri yazdırma işlemleri yapan sınıflar için interface.
* Oyun sınıfı doğrudan yazdırma işi yapan sınıfları kullanmak yerine bu interface 
* üzerinden metotları yönetir (Dependency Inversion Principle ve Polymorphism)
* </p>
*/

package motor;

import java.util.List;

import modeller.Sehir;

public interface IYazdirici {
	public void TurYazdir(List<Sehir> sehirler);
	public void detayYazdir(List<Sehir> sehirler, int index);
	public void ekraniTemizle();
}
