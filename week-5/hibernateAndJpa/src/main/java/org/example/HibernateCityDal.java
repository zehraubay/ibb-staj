package org.example;


@Repository
public class HibernateCityDal implements ICityDal{

    private EntityManager entityManager;


    @Autowired //spring framework te entityManager'ın implementasyou nedir diyerek gerekli olan injection'u yapacak
    //Constructor injection
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


   //AOP - Aspect Oriented Programming
    @Override
    @Transactional
    public List<City> getAll() {
        //return null;
        //hibernite kurulumu;
        Session session = entityManager.unwrap(Session.class); //jpa bizim için hibernate ile ilgili olan gerekli bütün injection'ları gerçekleştiriyor
    List<City> cities = session.createQuery("from City", City.class).getResultList();
    return cities;

    }

    //session u kapatıp açmamız unit of work tasarım deseni dir
    @Override
    public void add(City city) {
        //return null;
        Session session = entityManager.unwrap(Session.class);
        //veritabanına eklemek
        //city'nin id si varsa onu güncelleyecektir, yoksa onu ekleyecektir
        session.saveOrUpdate(city);
    }

    @Override
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        City cityToDelete = session.get(City.class, city.getId);
        session.delete(cityToDelete);
    }

    @Override
    public City getById(int id){
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id);
        return city;
    }

    //tek bir şehri getirme işlemi

    // Hibernate session factory ve session nesnesi jpa yı kullanarak otomatik olarak injection ile oluşacak
    //JPA: standart bir veri erişim tekniği

    /*

    EntityManager JPA’nin standart veritabanı yönetim arayüzüdür.
    Hibernate ise bunun implementasyonlarından biridir.
    entityManager.unwrap(Session.class) ifadesi, EntityManager içindeki gerçek
    Hibernate Session nesnesine erişmek için kullanılır

     EntityManager = JPA standardı
      Session = Hibernate özel API’si


    Mikroservice, uygulamanın bağımsız çalışan küçük servislere bölündüğü yazılım mimarisidir.
     Her servis kendi işinden sorumludur ve bağımsız deploy edilebilir.

     Dependency Injection, bir sınıfın bağımlılıklarının kendi içinde oluşturulmayıp dışarıdan verilmesidir.

Unit of Work, birden fazla veritabanı işlemini tek bir transaction altında yöneten tasarım desenidir.
Amaç işlemlerin tamamının başarılı olması, hata durumunda ise rollback yapılmasıdır.



Transaction, veritabanındaki bir grup işlemin:
ya tamamen başarılı olması
ya da tamamen geri alınması mantığıdır.
Yani: “Hepsi olacak ya da hiçbiri olmayacak.”

Bu annotation:
transaction başlatır
hata varsa rollback yapar
başarılıysa commit eder

Commit
İşlemleri kalıcı kaydeder.

Rollback
İşlemleri geri alır.

     */
}
