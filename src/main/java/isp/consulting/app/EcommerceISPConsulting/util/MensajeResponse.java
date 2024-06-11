package isp.consulting.app.EcommerceISPConsulting.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajeResponse {

    private Boolean respuesta;
    private String detalle;

}
