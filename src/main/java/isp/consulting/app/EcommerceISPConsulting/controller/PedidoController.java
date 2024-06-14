package isp.consulting.app.EcommerceISPConsulting.controller;

import isp.consulting.app.EcommerceISPConsulting.dto.PedidoRequest;
import isp.consulting.app.EcommerceISPConsulting.service.PedidoService;
import isp.consulting.app.EcommerceISPConsulting.util.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping("/realizar-pedido")
    public ResponseEntity<MensajeResponse> realizarPedido(@RequestBody PedidoRequest request) {

        Boolean respuesta = pedidoService.save(request);
        if (respuesta) {
            return new ResponseEntity<MensajeResponse>(new MensajeResponse(true, "Pedido realizado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<MensajeResponse>(new MensajeResponse(true, "No se pudo realizar pedido"), HttpStatus.OK);
        }

    }


}
