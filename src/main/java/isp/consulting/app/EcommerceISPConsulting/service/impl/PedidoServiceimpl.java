package isp.consulting.app.EcommerceISPConsulting.service.impl;

import isp.consulting.app.EcommerceISPConsulting.dto.PedidoRequest;
import isp.consulting.app.EcommerceISPConsulting.model.Cliente;
import isp.consulting.app.EcommerceISPConsulting.model.Direccion;
import isp.consulting.app.EcommerceISPConsulting.model.Pedido;
import isp.consulting.app.EcommerceISPConsulting.model.Producto;
import isp.consulting.app.EcommerceISPConsulting.model.ProductoPedido;
import isp.consulting.app.EcommerceISPConsulting.repository.PedidoRepository;
import isp.consulting.app.EcommerceISPConsulting.repository.ProductoPedidoRepository;
import isp.consulting.app.EcommerceISPConsulting.service.PedidoService;
import isp.consulting.app.EcommerceISPConsulting.util.ClockPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceimpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    @Override
    public Boolean save(PedidoRequest request) {

        if (request != null) {

            Pedido pedido = pedidoRepository.save(
                    Pedido.builder()
                            .fechaPedido(ClockPE.getClockLima())
                            .totalPedido(request.getTotal())
                            .cliente(
                                    Cliente.builder()
                                            .nombreCliente(request.getCliente())
                                            .direccion(
                                                    Direccion.builder()
                                                            .completaDireccion(request.getDireccion())
                                                            .build()
                                            )
                                            .build()
                            )
                            .build()
            );

            request.getProductos().forEach(p -> {
                        ProductoPedido productoPedido = ProductoPedido.builder()
                                .totalCompraProductoPedido(p.getCantidad().multiply(p.getCantidad()))
                                .totalCantidadProductoPedido(p.getCantidad())
                                .producto(
                                        Producto.builder()
                                                .idProducto(p.getId())
                                                .build()
                                )
                                .pedido(
                                        Pedido.builder()
                                                .idPedido(pedido.getIdPedido())
                                                .build()
                                )
                                .build();
                        productoPedidoRepository.save(productoPedido);
                    }
            );

            return true;

        } else {
            return false;
        }

    }

}
