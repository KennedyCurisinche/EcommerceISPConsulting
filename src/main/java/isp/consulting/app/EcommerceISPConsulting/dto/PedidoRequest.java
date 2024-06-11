package isp.consulting.app.EcommerceISPConsulting.dto;

import isp.consulting.app.EcommerceISPConsulting.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

    private String cliente;
    private String direccion;
    private BigDecimal total;
    private List<ProductoRequest> productos = new ArrayList<>();


}
