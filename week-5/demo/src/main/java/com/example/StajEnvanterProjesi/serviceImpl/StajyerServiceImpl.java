package com.example.StajEnvanterProjesi.serviceImpl;

import com.example.StajEnvanterProjesi.MessageHelper;
import com.example.StajEnvanterProjesi.exception.BaseException;
import com.example.StajEnvanterProjesi.entity.Stajyer;
import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerResponse;
import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerRequest;
import com.example.StajEnvanterProjesi.repository.StajyerRepository;
import com.example.StajEnvanterProjesi.service.StajyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
public class StajyerServiceImpl implements StajyerService {

    @Autowired
    private StajyerRepository stajyerRepository;

    @Autowired
    private MessageHelper messageHelper;

    private StajyerResponse toResponse(Stajyer stajyer) {
        if (stajyer == null) return null;

        StajyerResponse response = new StajyerResponse();
        response.setId(stajyer.getId());
        response.setAd(stajyer.getAd());
        response.setSoyad(stajyer.getSoyad());
        response.setUniversite(stajyer.getUniversite());
        response.setBolum(stajyer.getBolum());
        response.setSinif(stajyer.getSinif());
        response.setStajBaslangicTarihi(stajyer.getStajBaslangicTarihi());
        response.setStajBitisTarihi(stajyer.getStajBitisTarihi());
        response.setDurum(stajyer.getDurum());
        response.setStatus(stajyer.getStatus());
        return response;
    }

    private Stajyer toEntity(Stajyer request) {
        if (request == null) return null;

        Stajyer stajyer = new Stajyer();
        stajyer.setAd(request.getAd());
        stajyer.setSoyad(request.getSoyad());
        stajyer.setEmail(request.getEmail());
        stajyer.setTelefon(request.getTelefon());
        stajyer.setUniversite(request.getUniversite());
        stajyer.setBolum(request.getBolum());
        stajyer.setSinif(request.getSinif());
        stajyer.setStajBaslangicTarihi(request.getStajBaslangicTarihi());
        stajyer.setStajBitisTarihi(request.getStajBitisTarihi());
        stajyer.setDurum(request.getDurum());
        return stajyer;
    }

    @Override
    public StajyerResponse findById(Long id) {
        Optional<Stajyer> stajyer = stajyerRepository.findById(id);
        return stajyer.map(this::toResponse).orElse(null);
    }

    @Override
    public List<StajyerResponse> findAll() {
        return stajyerRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

//    @Override
//    public Stajyer save(Stajyer request) {
//
//        if ("Devam Ediyor".equalsIgnoreCase(request.getDurum())) {
//            request.setStatus(true);
//        } else {
//            request.setStatus(false);
//        }
//
//        return stajyerRepository.save(request);
//    }

    @Override
    public Stajyer save(Stajyer request) {
        // mail kontrolü
        Optional<Stajyer> mevcutAktif = stajyerRepository
                .findByEmailAndStatusTrue(request.getEmail());
        if (mevcutAktif.isPresent()) {
            throw new BaseException(messageHelper.get("error.mail.mevcut"));

        }

        if ("Devam Ediyor".equalsIgnoreCase(request.getDurum())) {
            request.setStatus(true);
        } else {
            request.setStatus(false);
        }

        return stajyerRepository.save(request);
    }


    @Override
    public StajyerResponse update(Long id, StajyerRequest request) {
        Optional<Stajyer> mevcutStajyer = stajyerRepository.findById(id);
        if (mevcutStajyer.isPresent()) {
            Stajyer guncellenecek = mevcutStajyer.get();

            //yeni kod eklendi
            if (!guncellenecek.getEmail().equals(request.getEmail())) {
                Optional<Stajyer> mailKontrol = stajyerRepository
                        .findByEmailAndStatusTrue(request.getEmail());
                if (mailKontrol.isPresent()) {
                    throw new BaseException(messageHelper.get("error.mail.baska.stajyer"));
                }
            }

            guncellenecek.setAd(request.getAd());
            guncellenecek.setSoyad(request.getSoyad());
            guncellenecek.setEmail(request.getEmail());
            guncellenecek.setTelefon(request.getTelefon());
            guncellenecek.setUniversite(request.getUniversite());
            guncellenecek.setBolum(request.getBolum());
            guncellenecek.setSinif(request.getSinif());
            guncellenecek.setStajBaslangicTarihi(request.getStajBaslangicTarihi());
            guncellenecek.setStajBitisTarihi(request.getStajBitisTarihi());
            guncellenecek.setDurum(request.getDurum());

            if ("Devam Ediyor".equalsIgnoreCase(request.getDurum())) {
                guncellenecek.setStatus(true);
            } else {
                guncellenecek.setStatus(false);
            }

            Stajyer guncellendi = stajyerRepository.save(guncellenecek);
            return toResponse(guncellendi);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Stajyer> mevcutStajyer = stajyerRepository.findById(id);
        if (mevcutStajyer.isPresent()) {
            Stajyer stajyer = mevcutStajyer.get();
            stajyer.setStatus(false);
            stajyerRepository.save(stajyer);
        }
    }
}
