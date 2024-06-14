package isp.consulting.app.EcommerceISPConsulting.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "producto_pedido")
public class ProductoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductoPedido;
    private BigDecimal totalCompraProductoPedido;
    private BigDecimal totalCantidadProductoPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_producto",
            nullable = false
    )
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_pedido",
            nullable = false
    )
    private Pedido pedido;

}
