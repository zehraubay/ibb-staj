package org.example;

import java.io.Serializable;

@Service //bu bir iş katmanıdır demek için
// iş kuralları
public class CityManager implements ICityService {

    private ICityDal cityDal;

    @Autowired //otomatik olarak git bak ve bu ICityDal'a uygun bir şey varsa onu ver
    public CityManager(ICityDal cityDal) {
        this.cityDal = cityDal;
    }


    @Override
    @Transactional //neden buraya da koyduk zaten DataAcsess te vardı çünkü siz data acsess te data acsess için yapıyorsunuz ama burda da bazı operasyonlarımız iki operasyonu birden gerçekleştirebilir business'ın transactional'ı
    public List<City> getAll() {

        return this.cityDal.getAll();
    }

    @Override
    @Transactional
    public void add(City city) {
        //business kodu
        this.cityDal.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        this.cityDal.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.cityDal.delete(city);
    }

    @Override
    @Transactional
    public City getById(int id){
        return this.cityDal.getById(id);
    }

}
