package isp.consulting.app.EcommerceISPConsulting.controller;

import isp.consulting.app.EcommerceISPConsulting.model.Cliente;
import isp.consulting.app.EcommerceISPConsulting.service.CRUDJpaService;
import isp.consulting.app.EcommerceISPConsulting.util.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    CRUDJpaService<Cliente> clienteService;

    @GetMapping("/listar")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<MensajeResponse> save(@RequestBody Cliente cliente) {

        Boolean respuesta = clienteService.save(cliente);
        if (respuesta) {
            return new ResponseEntity<>(new MensajeResponse(true, "Pedido realizado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MensajeResponse(true, "No se pudo realizar pedido"), HttpStatus.OK);
        }

    }


}
