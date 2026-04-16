package servisler;

import java.util.List;

import modeller.Sehir;

public interface IYazdirici {
	public void TurYazdir(List<Sehir> sehirler);
	public void detayYazdir(List<Sehir> sehirler, int index);
	public void ekraniTemizle();
}
