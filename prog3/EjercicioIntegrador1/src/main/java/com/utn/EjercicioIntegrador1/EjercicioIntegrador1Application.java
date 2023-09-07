package com.utn.EjercicioIntegrador1;

import com.utn.EjercicioIntegrador1.entidades.*;
import com.utn.EjercicioIntegrador1.repositorios.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;

import static java.time.LocalTime.now;

@SpringBootApplication
public class EjercicioIntegrador1Application {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioIntegrador1Application.class, args);
	}
	@Bean
	CommandLineRunner init(ConfiguracionGeneralRepository configuracionGeneralRepo,DomicilioRepository domicilioRepo, ClienteRepository clienteRepo,UsuarioRepository usuarioRepo, PedidoRepository pedidoRepo, FacturaRepository facturaRepo, ProductoRepository productoRepo, RubroRepository rubroRepos) {
		return args -> {

			ConfiguracionGeneral configuracionGeneral=ConfiguracionGeneral.builder().cantidadCocineros(5).emailEmpresa("algo@algo").tokerMercadoPago("nosequepoer").build();
			configuracionGeneralRepo.save(configuracionGeneral);
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			//relacion un usuario a muchos pedidos.
			Usuario user1 = Usuario.builder().nombre("joaco").rol("admin").password("salchipapa").build();
			Pedido pedido1= Pedido.builder().fecha("4 de marzo").horaEstimadaEntrega("6").total(500).build();
			Pedido pedido2= Pedido.builder().fecha("6 de marzo").horaEstimadaEntrega("7").total(900).build();
			user1.agregarPedido(pedido1);
			user1.agregarPedido(pedido2);
			usuarioRepo.save(user1);

			//relacion una factura al pedido
			Factura factura= Factura.builder().fecha("hoy").total(22).build();
			pedido1.setFactura(factura);

			//relacion  producto a muchos DetallePedido
			Producto producto= Producto.builder().tipo("arroz").precioVenta(50).receta("cocina 20min").build();

			//relacion muchos productos a un rubro
			Rubro rubro= Rubro.builder().denominacion("no se que va aca").build();

			producto.setRubro(rubro);
			rubroRepos.save(rubro);
			productoRepo.save(producto);

			//relacion un pedido a muchos detalle pedido
			DetallePedido detalleP = DetallePedido.builder().cantidad(4).subtotal(400).build();
			detalleP.setProducto(producto);
			DetallePedido detalleP2 = DetallePedido.builder().cantidad(1).subtotal(800).build();
			detalleP2.setProducto(producto);

			pedido1.agregarDetallePedido(detalleP);
			pedido1.agregarDetallePedido(detalleP2);

			Cliente cliente=Cliente.builder().nombre("pepe").apellido("juancho").build();
			Cliente cliente2=Cliente.builder().nombre("pepe2").apellido("juancho2").build();
			clienteRepo.save(cliente);
			clienteRepo.save(cliente2);

			Domicilio domicilio=Domicilio.builder().calle("eaea").numero("undostres").build();
			Domicilio domicilio2=Domicilio.builder().calle("eaea123123").numero("undostres12312").build();
			Domicilio domicilio3=Domicilio.builder().calle("eaea").numero("undostres").build();

			domicilio2.setCliente(cliente2);
			domicilio2.setCliente(cliente);

			domicilioRepo.save(domicilio);
			domicilioRepo.save(domicilio2);
			domicilioRepo.save(domicilio3);
			pedido1.setCliente(cliente2);
			pedido1.setDomicilio(domicilio2);

			pedido2.setCliente(cliente);
			pedido2.setDomicilio(domicilio3);
			pedidoRepo.save(pedido1);
			pedidoRepo.save(pedido2);


		};

	}
}
