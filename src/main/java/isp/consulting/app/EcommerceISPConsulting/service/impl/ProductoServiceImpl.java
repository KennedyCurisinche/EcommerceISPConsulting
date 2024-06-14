package isp.consulting.app.EcommerceISPConsulting.service.impl;

import isp.consulting.app.EcommerceISPConsulting.model.Producto;
import isp.consulting.app.EcommerceISPConsulting.repository.ProductoRepository;
import isp.consulting.app.EcommerceISPConsulting.service.CRUDJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoServiceImpl implements CRUDJpaService<Producto> {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Boolean save(Producto producto) {
        productoRepository.save(producto);
        return true;
    }

}
