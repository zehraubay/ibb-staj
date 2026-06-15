package org.example;

public interface IEntityRepository<T extends IEntity> {

    void add(T entity);
    void delete(T entity);
    void update(T entity);
}

//customer ile product veritabanı nesnesi ama veritabanıyla akalı olmayan class'ı generic ksımına yazılmaması için kısıt kullanılması gerek: interface ekleyip (IEntity) orada alakalı olan (IEntityRepository) classları belirtiyoruz