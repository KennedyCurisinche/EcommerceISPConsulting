package isp.consulting.app.EcommerceISPConsulting.dto;

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

    private Long idcliente;
    private BigDecimal total;
    private List<ProductoRequest> productos = new ArrayList<>();


}
