package com.arqui.arquiorienobj;

class Usuario {
    private String nombre;
    private String email;
    private Carrito carrito;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.carrito = new Carrito();
    }

    public void agregarAlCarrito(Producto producto) {
        carrito.agregarProducto(producto);
    }

    public void quitarDelCarrito(Producto producto) {
        carrito.quitarProducto(producto);
    }

    public double finalizarCompra() {
        double total = carrito.calcularTotal();
        // Lógica para el proceso de compra, por ejemplo, pago, actualización de inventario, etc.
        // Aquí se simularía solo el vaciado del carrito al finalizar la compra
        carrito.getProductos().clear();
        return total;
    }

    public Carrito getCarrito() {
        return carrito;
    }
}
