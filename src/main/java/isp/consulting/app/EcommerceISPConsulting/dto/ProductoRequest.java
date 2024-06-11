package isp.consulting.app.EcommerceISPConsulting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    private Long id;
    private String nombre;
    private BigDecimal cantidad;
    private BigDecimal precio;
}
