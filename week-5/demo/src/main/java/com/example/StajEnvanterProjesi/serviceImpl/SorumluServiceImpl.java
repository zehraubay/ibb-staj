package com.example.StajEnvanterProjesi.serviceImpl;

import com.example.StajEnvanterProjesi.entity.Sorumlu;
import com.example.StajEnvanterProjesi.entity.Stajyer;
import com.example.StajEnvanterProjesi.entity.dto.Sorumlu.SorumluResponse;
import com.example.StajEnvanterProjesi.entity.dto.Sorumlu.SorumluRequest;
import com.example.StajEnvanterProjesi.repository.SorumluRepository;
import com.example.StajEnvanterProjesi.service.SorumluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
public class SorumluServiceImpl implements SorumluService {

    @Autowired
    SorumluRepository sorumluRepository;

    private SorumluResponse toResponse(Sorumlu sorumlu) { // toResponse Metodu: Veritabanından Gelen Veriyi Maskeleme
        if (sorumlu == null) return null; //Eğer aradığımız sorumlu veritabanında yoksa kod çökmesin diye  boş dönüyoruz

        SorumluResponse response = new SorumluResponse();
        response.setAd(sorumlu.getAd());
        response.setSoyad(sorumlu.getSoyad());
        response.setEmail(sorumlu.getEmail());
        response.setTelefon(sorumlu.getTelefon());
        return response;
    }

    private Sorumlu toEntity(SorumluRequest request) { // toEntity Metodu: Kullanıcıdan Gelen Veriyi Veritabanı Formatına Çevirme
        if (request == null) return null;

        Sorumlu sorumlu = new Sorumlu();
        sorumlu.setAd(request.getAd());
        sorumlu.setSoyad(request.getSoyad());
        sorumlu.setEmail(request.getEmail());
        sorumlu.setTelefon(request.getTelefon());
        return sorumlu;
    }

    @Override
    public SorumluResponse findById(Long id) {
        Optional<Sorumlu> sorumlu = sorumluRepository.findById(id);
        return sorumlu.map(this::toResponse).orElse(null); //eğer veri bulunduysa, yukarıda anlattığım toResponse çevirmenini çağırır ve veriyi DTO'ya çevirir. Bulunamadıysa null döner.
    }

    @Override
    public List<SorumluResponse> findAll() {
        return sorumluRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SorumluResponse save(SorumluRequest request) {
        Sorumlu sorumlu = toEntity(request);
        Sorumlu kaydedilen = sorumluRepository.save(sorumlu);
        return toResponse(kaydedilen);
    }

    @Override
    public SorumluResponse update(Long id, SorumluRequest request) {
        Optional<Sorumlu> mevcutSorumlu = sorumluRepository.findById(id);
        if (mevcutSorumlu.isPresent()) {
            Sorumlu guncellenecek = mevcutSorumlu.get();
            guncellenecek.setAd(request.getAd());
            guncellenecek.setSoyad(request.getSoyad());
            guncellenecek.setEmail(request.getEmail());
            guncellenecek.setTelefon(request.getTelefon());

            Sorumlu guncellendi = sorumluRepository.save(guncellenecek);
            return toResponse(guncellendi);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Sorumlu> mevcutSorumlu = sorumluRepository.findById(id);
        if (mevcutSorumlu.isPresent()) {
            Sorumlu sorumlu = mevcutSorumlu.get();
            sorumlu.setStatus(false);
            sorumluRepository.save(sorumlu);
        }
    }
}
