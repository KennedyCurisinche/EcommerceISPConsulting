package isp.consulting.app.EcommerceISPConsulting.repository;

import isp.consulting.app.EcommerceISPConsulting.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
