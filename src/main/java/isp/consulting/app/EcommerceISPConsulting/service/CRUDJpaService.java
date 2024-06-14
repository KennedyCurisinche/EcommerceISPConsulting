package isp.consulting.app.EcommerceISPConsulting.service;

import java.util.List;

public interface CRUDJpaService<T> {

    List<T> findAll();
    Boolean save(T entity);

}
