package com.example.StajEnvanterProjesi.serviceImpl;

import com.example.StajEnvanterProjesi.MessageHelper;
import com.example.StajEnvanterProjesi.exception.BaseException;
import com.example.StajEnvanterProjesi.entity.Sorumlu;
import com.example.StajEnvanterProjesi.entity.dto.Stajyer.StajyerGunKalanResponse;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.example.StajEnvanterProjesi.entity.Stajyer;
import com.example.StajEnvanterProjesi.entity.StajyerApplication;
import com.example.StajEnvanterProjesi.repository.SorumluRepository;
import com.example.StajEnvanterProjesi.repository.StajyerApplicationRepository;
import com.example.StajEnvanterProjesi.repository.StajyerRepository;
import com.example.StajEnvanterProjesi.service.StajyerApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StajyerApplicationServiceImpl implements StajyerApplicationService {


    @Autowired
    private StajyerApplicationRepository stajyerApplicationRepository;

    @Autowired
    private StajyerRepository stajyerRepository;

    @Autowired
    private SorumluRepository sorumluRepository;

    @Autowired
    private MessageHelper messageHelper;

    @Override
    public StajyerApplication findById(Long id) {
        return stajyerApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<StajyerApplication> findAll() {
        return stajyerApplicationRepository.findAll();
    }



    // En son kaydın bitiş tarihi bugünden büyük mü

    private void tarihKontrol(Stajyer stajyer) {
        Optional<StajyerApplication> sonKayit =
                stajyerApplicationRepository.findTopByStajyersOrderByIdDesc(stajyer);

        if (sonKayit.isPresent()) {
            LocalDate bitisTarihi = sonKayit.get().getStajyers().getStajBitisTarihi();
            LocalDate bugun = LocalDate.now();

        }
    }

    // ana kayıt metodumuz

    @Override
    public StajyerApplication stajyerKaydet(Long stajyerId, Long sorumluId) {

        Stajyer stajyer = stajyerRepository.findById(stajyerId)
                .orElseThrow(() -> new BaseException(messageHelper.get("error.stajyer.bulunamadi", stajyerId)));

        Sorumlu sorumlu = sorumluRepository.findById(sorumluId)
                .orElseThrow(() -> new BaseException(messageHelper.get("error.sorumlu.bulunamadi", sorumluId)));

        StajyerApplication stajyerApplication = stajyerApplicationRepository.findByStatusTrueAndStajyers_Id(stajyerId);

        if (stajyerApplication != null && Boolean.TRUE.equals(stajyerApplication.getAsilMi())) {
            throw new BaseException(messageHelper.get("error.stajyer.asil.atanmis"));
        }
        tarihKontrol(stajyer);

        // Her iki kontrol geçildiyse yeni kayıt oluştur
        StajyerApplication yeniKayit = new StajyerApplication();
        yeniKayit.setStajyers(stajyer);
        yeniKayit.setSorumlus(sorumlu);
        yeniKayit.setAsilMi(true); // ilk atanan direkt asil olur
        yeniKayit.setStatus(true);

        return stajyerApplicationRepository.save(yeniKayit);
    }

    //sorumlu ayrilirsa

    @Override
    public StajyerApplication sorumluAyril(Long stajyerId) {

        Stajyer stajyer = stajyerRepository.findById(stajyerId)
                .orElseThrow(() -> new BaseException(messageHelper.get("error.stajyer.bulunamadi", stajyerId)));

        // Asil sorumluyu bul ve pasife al
        StajyerApplication asilSorumlu = stajyerApplicationRepository.findByStajyersAndAsilMiTrueAndStatusTrue(stajyer);

        if (asilSorumlu == null) {
            throw new BaseException(messageHelper.get("error.sorumlu.atanmis"));
        }

        asilSorumlu.setAsilMi(false);
        return stajyerApplicationRepository.save(asilSorumlu);

        // Yedek yoksa manuel atama bekliyouz hata vermiyoruz
    }


    // yeni sorumlu atama

    @Override
    public StajyerApplication yeniSorumluAta(Long stajyerId, Long sorumluId) {

        Stajyer stajyer = stajyerRepository.findById(stajyerId)
                .orElseThrow(() -> new BaseException(messageHelper.get("error.stajyer.bulunamadi", stajyerId)));

        Sorumlu sorumlu = sorumluRepository.findById(sorumluId)
                .orElseThrow(() -> new BaseException(messageHelper.get("error.sorumlu.bulunamadi", sorumluId)));

        // halihazırda aktif asil sorumlu var mı bakıyoruz
        StajyerApplication mevcutAsil = stajyerApplicationRepository
                .findByStajyersAndAsilMiTrueAndStatusTrue(stajyer);


        StajyerApplication yeniSorumlu = new StajyerApplication();
        yeniSorumlu.setStajyers(stajyer);
        yeniSorumlu.setSorumlus(sorumlu);
        yeniSorumlu.setAsilMi(true);
        yeniSorumlu.setStatus(true);

        return stajyerApplicationRepository.save(yeniSorumlu);
    }


    @Override
    public StajyerApplication yedekSorumluEkle(Long stajyerId, Long sorumluId) {

        Stajyer stajyer = stajyerRepository.findById(stajyerId).orElseThrow(() ->
                new RuntimeException(messageHelper.get("error.stajyer.bulunamadi", stajyerId)));

        Sorumlu sorumlu = sorumluRepository.findById(sorumluId).orElseThrow(() ->
                new RuntimeException(messageHelper.get("error.sorumlu.bulunamadi", sorumluId)));

        StajyerApplication yedek = new StajyerApplication();
        yedek.setStajyers(stajyer);
        yedek.setSorumlus(sorumlu);
        yedek.setAsilMi(false);
        yedek.setStatus(true);

        return stajyerApplicationRepository.save(yedek);
    }

    @Override
    public List<StajyerGunKalanResponse> gunKalanHesapla() {
        LocalDate bugun = LocalDate.now();
        LocalDate besGunSonra = bugun.plusDays(5);

        List<Stajyer> stajyerler = stajyerRepository
                .findByDurumAndStatusTrueAndStajBitisTarihiBetween(
                        "Devam Ediyor",
                        bugun,
                        besGunSonra
                );

        List<StajyerGunKalanResponse> sonuc = new java.util.ArrayList<>();

        for (Stajyer stajyer : stajyerler) {
            long gunKalan = ChronoUnit.DAYS.between(bugun, stajyer.getStajBitisTarihi());
            sonuc.add(new StajyerGunKalanResponse(
                    stajyer.getAd(),
                    stajyer.getSoyad(),
                    stajyer.getStajBitisTarihi(),
                    gunKalan
            ));
        }

        return sonuc;
    }


        // soft delete yani komple silmiyoruz
        @Override
        public void delete (Long id){
            Optional<StajyerApplication> mevcut =
                    stajyerApplicationRepository.findById(id);
            if (mevcut.isPresent()) {
                mevcut.get().setStatus(false);
                stajyerApplicationRepository.save(mevcut.get());
            }
        }

    }



