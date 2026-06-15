package com.example.StajEnvanterProjesi.serviceImpl;

import com.example.StajEnvanterProjesi.entity.Sorumlu;
import com.example.StajEnvanterProjesi.entity.Stajyer;
import com.example.StajEnvanterProjesi.entity.StajyerApplication;
import com.example.StajEnvanterProjesi.repository.SorumluRepository;
import com.example.StajEnvanterProjesi.repository.StajyerApplicationRepository;
import com.example.StajEnvanterProjesi.repository.StajyerRepository;
import com.example.StajEnvanterProjesi.service.StajyerApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StajyerApplicationServiceImpl
        implements StajyerApplicationService {

    @Autowired
    private StajyerApplicationRepository stajyerApplicationRepository;

    @Autowired
    private StajyerRepository stajyerRepository;

    @Autowired
    private SorumluRepository sorumluRepository;

    @Override
    public StajyerApplication findById(Long id) {
        return stajyerApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<StajyerApplication> findAll() {
        return stajyerApplicationRepository.findAll();
    }

    // 1.metotumuz status=true aktif kaydı var mı
//    private void aktifKayitKontrol(Stajyer stajyer) {
//        Optional<StajyerApplication> aktifKayit =
//                stajyerApplicationRepository.findByStajyersAndStatusTrue(stajyer);
//
//        if (aktifKayit.isPresent()) {
//            throw new RuntimeException(
//                    "Bu stajyerin zaten aktif devam eden bir stajı bulunmaktadır."
//            );
//        }
//    }

    // 2. metot En son kaydın bitiş tarihi bugünden büyük mü

    private void tarihKontrol(Stajyer stajyer) {
        Optional<StajyerApplication> sonKayit =
                stajyerApplicationRepository.findTopByStajyersOrderByIdDesc(stajyer);

        if (sonKayit.isPresent()) {
            LocalDate bitisTarihi = sonKayit.get().getStajyers().getStajBitisTarihi();
            LocalDate bugun = LocalDate.now();

//            if (bitisTarihi != null && bitisTarihi.isAfter(bugun)) {
//                throw new RuntimeException(
//                        "Bu stajyerin mevcut staj bitiş tarihi henüz geçmemiştir: " + bitisTarihi);
//            }
        }
    }

    // ana kayıt metodumuz

    @Override
    public StajyerApplication stajyerKaydet(Long stajyerId, Long sorumluId) throws Exception  {

        Stajyer stajyer = stajyerRepository.findById(stajyerId)
                .orElseThrow(() -> new RuntimeException("Stajyer bulunamadı: " + stajyerId));

        Sorumlu sorumlu = sorumluRepository.findById(sorumluId)
                .orElseThrow(() -> new RuntimeException("Sorumlu bulunamadı: " + sorumluId));

        StajyerApplication stajyerApplication = stajyerApplicationRepository.findByStatusTrueAndStajyers_Id(stajyerId);

        if (stajyerApplication != null && Boolean.TRUE.equals(stajyerApplication.getAsilMi())) {
            throw new Exception("Bu stajyer zaten asil olarak atanmış");
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
    public String sorumluAyril(Long stajyerId) {

        Stajyer stajyer = stajyerRepository.findById(stajyerId)
                .orElseThrow(() -> new RuntimeException("Stajyer bulunamadı: " + stajyerId));

        // Asil sorumluyu bul ve pasife al
        StajyerApplication asilSorumlu = stajyerApplicationRepository
                .findByStajyersAndAsilMiTrueAndStatusTrue(stajyer)
                .orElseThrow(() -> new RuntimeException("Aktif asil sorumlu bulunamadı."));

        asilSorumlu.setStatus(false);
        stajyerApplicationRepository.save(asilSorumlu);

        // Yedek var mı
        Optional<StajyerApplication> yedek = stajyerApplicationRepository
                .findByStajyersAndAsilMiFalseAndStatusTrue(stajyer);

        if (yedek.isPresent()) {
            yedek.get().setAsilMi(true);
            stajyerApplicationRepository.save(yedek.get());
            return "Yedek sorumlu asile terfi etti.";
        }
        // Yedek yoksa manuel atama bekliyouz hata vermiyoruz
        return "Uyarı: Bu stajyerin sorumlusu kalmadı. Lütfen yeni sorumlu atayınız.";
    }


    // yeni sorumlu atama

    @Override
    public StajyerApplication yeniSorumluAta(Long stajyerId, Long sorumluId) {

        Stajyer stajyer = stajyerRepository.findById(stajyerId)
                .orElseThrow(() -> new RuntimeException("Stajyer bulunamadı: " + stajyerId));

        Sorumlu sorumlu = sorumluRepository.findById(sorumluId)
                .orElseThrow(() -> new RuntimeException("Sorumlu bulunamadı: " + sorumluId));

        // halihazırda aktif asil sorumlu var mı bakıyoruz
        Optional<StajyerApplication> mevcutAsil = stajyerApplicationRepository
                .findByStajyersAndAsilMiTrueAndStatusTrue(stajyer);

        if (mevcutAsil.isPresent()) {
            throw new RuntimeException("Zaten aktif bir asil sorumlu var.");
        }

        StajyerApplication yeniSorumlu = new StajyerApplication();
        yeniSorumlu.setStajyers(stajyer);
        yeniSorumlu.setSorumlus(sorumlu);
        yeniSorumlu.setAsilMi(true);
        yeniSorumlu.setStatus(true);

        return stajyerApplicationRepository.save(yeniSorumlu);
    }


    @Override
    public StajyerApplication yedekSorumluEkle(Long stajyerId, Long sorumluId) {

        Stajyer stajyer = stajyerRepository.findById(stajyerId)
                .orElseThrow(() -> new RuntimeException(
                        "Stajyer bulunamadı: " + stajyerId));

        Sorumlu sorumlu = sorumluRepository.findById(sorumluId)
                .orElseThrow(() -> new RuntimeException(
                        "Sorumlu bulunamadı: " + sorumluId));

        // Zaten yedek var mı
        Optional<StajyerApplication> mevcutYedek = stajyerApplicationRepository
                .findByStajyersAndAsilMiFalseAndStatusTrue(stajyer);
        if (mevcutYedek.isPresent()) {
            throw new RuntimeException(
                    "Bu stajyerin zaten bir yedek sorumlusu bulunmaktadır.");
        }

//        // Asil sorumlu var mı
//        Optional<StajyerApplication> mevcutAsil = stajyerApplicationRepository
//                .findByStajyersAndAsilMiTrueAndStatusTrue(stajyer);
//        if (!mevcutAsil.isPresent()) {
//            throw new RuntimeException(
//                    "Yedek eklemeden önce asil sorumlu atanmalıdır.");
//        }

        StajyerApplication yedek = new StajyerApplication();
        yedek.setStajyers(stajyer);
        yedek.setSorumlus(sorumlu);
        yedek.setAsilMi(false);
        yedek.setStatus(true);

        return stajyerApplicationRepository.save(yedek);
    }

    // soft delete yani komple silmiyoruz

    @Override
    public void delete(Long id) {
        Optional<StajyerApplication> mevcut =
                stajyerApplicationRepository.findById(id);
        if (mevcut.isPresent()) {
            mevcut.get().setStatus(false);
            stajyerApplicationRepository.save(mevcut.get());
        }
    }
}

