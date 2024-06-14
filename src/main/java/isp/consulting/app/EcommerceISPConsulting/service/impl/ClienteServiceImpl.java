package isp.consulting.app.EcommerceISPConsulting.service.impl;

import isp.consulting.app.EcommerceISPConsulting.model.Cliente;
import isp.consulting.app.EcommerceISPConsulting.repository.ClienteRepository;
import isp.consulting.app.EcommerceISPConsulting.service.CRUDJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteServiceImpl implements CRUDJpaService<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Boolean save(Cliente cliente) {
        clienteRepository.save(cliente);
        return true;
    }

}
