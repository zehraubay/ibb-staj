package org.example;

//İş katmanı
public interface ICityService {
    List<City> getAll(); //bütün şehirleri listeleyecek kod
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);
    //madem aynı operasyonları kullanıyoruz neden ICityDal'ı kullanmıyoruz çünkü business'da sırf iş kurallarını kontrol etmek için ekleme yaparken true,false değeri göndeririz
    // ama bunun veritabanıyla alakası yok o yüzden business katmanındaki operasyonlar zamanla signature'lar değişebiliyor o yüzden birbirinden ayırıyoruz

}
