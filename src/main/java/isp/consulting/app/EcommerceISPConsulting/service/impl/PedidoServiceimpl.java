package isp.consulting.app.EcommerceISPConsulting.service.impl;

import isp.consulting.app.EcommerceISPConsulting.dto.PedidoRequest;
import isp.consulting.app.EcommerceISPConsulting.model.Cliente;
import isp.consulting.app.EcommerceISPConsulting.model.Pedido;
import isp.consulting.app.EcommerceISPConsulting.model.Producto;
import isp.consulting.app.EcommerceISPConsulting.model.ProductoPedido;
import isp.consulting.app.EcommerceISPConsulting.repository.ClienteRepository;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Boolean save(PedidoRequest request) {

        if (request != null) {

            Cliente cliente = clienteRepository.findById(request.getIdcliente()).orElse(null);

            Pedido pedido = pedidoRepository.save(
                    Pedido.builder()
                            .fechaPedido(ClockPE.getClockLima())
                            .totalPedido(request.getTotal())
                            .cliente(cliente)
                            .build()
            );

            request.getProductos().parallelStream().forEach(p -> productoPedidoRepository.save(
                            ProductoPedido.builder()
                                    .totalCompraProductoPedido(p.getCantidad().multiply(p.getPrecio()))
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
                                    .build()
                    )
            );

            return true;

        } else {
            return false;
        }

    }

}
