package isp.consulting.app.EcommerceISPConsulting.controller;

import isp.consulting.app.EcommerceISPConsulting.model.Producto;
import isp.consulting.app.EcommerceISPConsulting.service.CRUDJpaService;
import isp.consulting.app.EcommerceISPConsulting.util.MensajeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    CRUDJpaService<Producto> productoService;

    @PostMapping("/guardar")
    public ResponseEntity<MensajeResponse> save(@RequestBody Producto producto) {

        Boolean respuesta = productoService.save(producto);
        if (respuesta) {
            return new ResponseEntity<>(new MensajeResponse(true, "Producto creado"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MensajeResponse(true, "No se pudo crear producto"), HttpStatus.OK);
        }

    }


}
