package com.utn.EjercicioIntegrador1;

import com.utn.EjercicioIntegrador1.entidades.*;
import com.utn.EjercicioIntegrador1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjercicioIntegrador1Application {
	@Autowired
	public RubroRepository rubroRepository;
	@Autowired
	public ProductoRepository productoRepository;
	@Autowired
	public UsuarioRepository usuarioRepository;
	@Autowired
	public DomicilioRepository domicilioRepository;
	@Autowired
	public ClienteRepository clienteRepository;
	@Autowired
	public PedidoRepository pedidoRepository;
	@Autowired
	public DetallePedidoRepository detallePedidoRepository;
	@Autowired
	public FacturaRepository facturaRepository;
	public static void main(String[] args) {
		SpringApplication.run(EjercicioIntegrador1Application.class, args);
	}
	@Bean
	CommandLineRunner init(ConfiguracionGeneralRepository configuracionGeneralRepo,DomicilioRepository domicilioRepo, ClienteRepository clienteRepo,
						   UsuarioRepository usuarioRepo, PedidoRepository pedidoRepo, FacturaRepository facturaRepo, ProductoRepository productoRepo,
						   RubroRepository rubroRepos) {
		return args -> {

			ConfiguracionGeneral configuracionGeneral=ConfiguracionGeneral.builder().cantidadCocineros(5).emailEmpresa("algo@algo").
					tokerMercadoPago("nosequepoer").build();
			configuracionGeneralRepo.save(configuracionGeneral);
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			//relacion un usuario a muchos pedidos.
			Usuario user1 = Usuario.builder().nombre("joaco").rol("admin").password("salchipapa").build();
			Usuario user2 = Usuario.builder().nombre("igna").rol("repartidor").password("repartipapa").build();
			usuarioRepo.save(user1);
			usuarioRepo.save(user2);
			Cliente cliente=Cliente.builder().nombre("pepe").apellido("juancho").build();
			Cliente cliente2=Cliente.builder().nombre("pepe2").apellido("juancho2").build();
			clienteRepo.save(cliente);
			clienteRepo.save(cliente2);
			Domicilio domicilio=Domicilio.builder().cliente(cliente).calle("eaea").numero("undostres").build();
			Domicilio domicilio2=Domicilio.builder().cliente(cliente).calle("eaea123123").numero("undostres12312").build();
			Domicilio domicilio3=Domicilio.builder().cliente(cliente2).calle("dom3").numero("3434").build();
			domicilioRepo.save(domicilio);
			domicilioRepo.save(domicilio2);
			domicilioRepo.save(domicilio3);
			Pedido pedido1= Pedido.builder().fecha("4 de marzo").horaEstimadaEntrega("6").estado(Pedido.Estado.INICIADO).tipoEnvio(Pedido.TipoEnvio.DELIVERY).total(500).build();
			Pedido pedido2= Pedido.builder().fecha("6 de marzo").horaEstimadaEntrega("7").estado(Pedido.Estado.PREPARACION).tipoEnvio(Pedido.TipoEnvio.DELIVERY).total(900).build();
			Pedido pedido3= Pedido.builder().fecha("6 de marzo").horaEstimadaEntrega("8").estado(Pedido.Estado.PREPARACION).tipoEnvio(Pedido.TipoEnvio.RETIRA).total(200).build();


			//relacion una factura al pedido
			Factura factura= Factura.builder().formaPago(Factura.FormaPago.EFECTIVO).fecha("hoy").total(22).build();
			pedido1.setFactura(factura);

			//relacion  producto a muchos DetallePedido
			Producto producto= Producto.builder().tipo(Producto.Tipo.INSUMO).precioCompra(20).precioVenta(50).receta("cocinar 20min").tiempoEstimadoCocina(56).stockActual(5).stockMinimo(0).build();
			Producto producto2= Producto.builder().tipo(Producto.Tipo.INSUMO).precioCompra(30).precioVenta(70).receta("cocinar 6min").tiempoEstimadoCocina(6).stockActual(7).stockMinimo(2).build();
			Producto producto3= Producto.builder().tipo(Producto.Tipo.INSUMO).precioCompra(3).precioVenta(10).receta("cocinar 60min").tiempoEstimadoCocina(56).stockActual(53).stockMinimo(1).build();
			//relacion muchos productos a un rubro
			Rubro rubro= Rubro.builder().denominacion("pasta").build();
			Rubro rubro2= Rubro.builder().denominacion("carne").build();

			rubro.agregarProducto(producto);
			rubro.agregarProducto(producto3);
			rubro2.agregarProducto(producto2);
			rubroRepos.save(rubro);
			rubroRepos.save(rubro2);

			//relacion un pedido a muchos detalle pedido
			DetallePedido detalleP = DetallePedido.builder().cantidad(4).subtotal(400).build();
			detalleP.setProducto(producto);

			DetallePedido detalleP2 = DetallePedido.builder().cantidad(1).subtotal(800).build();
			detalleP2.setProducto(producto);

			pedido1.agregarDetallePedido(detalleP);
			pedido1.agregarDetallePedido(detalleP2);
			pedidoRepo.save(pedido1);
			pedidoRepo.save(pedido2);
			pedidoRepo.save(pedido3);




			user2.agregarPedido(pedido1);
			user2.agregarPedido(pedido2);
			user2.agregarPedido(pedido3);
			domicilio.agregarPedido(pedido1);
			domicilio.agregarPedido(pedido2);
			domicilio3.agregarPedido(pedido3);
			cliente.agregarPedido(pedido1);
			cliente2.agregarPedido(pedido2);
			usuarioRepo.save(user1);
			usuarioRepo.save(user2);
			clienteRepo.save(cliente);
			clienteRepo.save(cliente2);
			domicilioRepo.save(domicilio);
			domicilioRepo.save(domicilio2);
			domicilioRepo.save(domicilio3);








		};

	}
}
