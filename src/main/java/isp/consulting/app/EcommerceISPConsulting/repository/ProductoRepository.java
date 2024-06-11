package isp.consulting.app.EcommerceISPConsulting.repository;

import isp.consulting.app.EcommerceISPConsulting.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
