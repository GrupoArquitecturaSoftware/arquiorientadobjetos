package com.arqui.arquiorienobj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;
@SpringBootApplication
public class ArquiOrienObjApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Creación de algunos productos
		Producto producto1 = new Producto(1, "Camisa", 25.99, 50);
		Producto producto2 = new Producto(2, "Pantalón", 35.50, 30);

		// Creación de usuarios
		Usuario usuario1 = new Usuario("Ejemplo Usuario", "usuario@example.com");

		int opcion;
		do {
			System.out.println("\nMenú:");
			System.out.println("1. Agregar producto al carrito");
			System.out.println("2. Quitar producto del carrito");
			System.out.println("3. Ver carrito");
			System.out.println("4. Finalizar compra");
			System.out.println("5. Salir");
			System.out.print("Ingrese la opción deseada: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer del scanner

			switch (opcion) {
				case 1:
					System.out.println("\nProductos disponibles:");
					System.out.println("1. " + producto1.getNombre() + " - Precio: $" + producto1.getPrecio());
					System.out.println("2. " + producto2.getNombre() + " - Precio: $" + producto2.getPrecio());
					System.out.print("Ingrese el número del producto que desea agregar al carrito: ");
					int productoSeleccionado = scanner.nextInt();
					scanner.nextLine(); // Limpiar el buffer del scanner

					if (productoSeleccionado == 1) {
						usuario1.agregarAlCarrito(producto1);
						System.out.println("Producto agregado al carrito: " + producto1.getNombre());
					} else if (productoSeleccionado == 2) {
						usuario1.agregarAlCarrito(producto2);
						System.out.println("Producto agregado al carrito: " + producto2.getNombre());
					} else {
						System.out.println("Opción inválida");
					}
					break;

				case 2:
					System.out.println("\nCarrito actual:");
					List<Producto> carrito = usuario1.getCarrito().getProductos();
					if (carrito.isEmpty()) {
						System.out.println("El carrito está vacío");
					} else {
						System.out.println("Productos en el carrito:");
						for (Producto producto : carrito) {
							System.out.println("- " + producto.getNombre());
						}
						System.out.print("Ingrese el nombre del producto que desea quitar del carrito: ");
						String nombreProductoQuitar = scanner.nextLine();

						// Buscar el producto en el carrito y quitarlo si está presente
						boolean productoEncontrado = false;
						for (Producto producto : carrito) {
							if (producto.getNombre().equalsIgnoreCase(nombreProductoQuitar)) {
								usuario1.quitarDelCarrito(producto);
								System.out.println("Producto quitado del carrito: " + nombreProductoQuitar);
								productoEncontrado = true;
								break;
							}
						}
						if (!productoEncontrado) {
							System.out.println("Producto no encontrado en el carrito");
						}
					}
					break;

				case 3:
					System.out.println("\nCarrito actual:");
					List<Producto> carritoProductos = usuario1.getCarrito().getProductos();
					if (carritoProductos.isEmpty()) {
						System.out.println("El carrito está vacío");
					} else {
						System.out.println("Productos en el carrito:");
						for (Producto producto : carritoProductos) {
							System.out.println("- " + producto.getNombre() + " - Precio: $" + producto.getPrecio());
						}
					}
					break;

				case 4:
					double totalCompra = usuario1.finalizarCompra();
					System.out.println("\nCompra finalizada. Total a pagar: $" + totalCompra);
					break;

				case 5:
					System.out.println("Saliendo del programa...");
					break;

				default:
					System.out.println("Opción inválida");
					break;
			}
		} while (opcion != 5);

		scanner.close();
	}
}

