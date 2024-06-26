/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

/**
 *
 * @author Antonio Sanchez
 */

import model.Producto;
import java.util.List;

public class ProductoView {
     public static void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("\n--- Lista de Productos ---");
            for (Producto producto : productos) {
                System.out.println(producto.getId() + ". " + producto.getNombre() + " - Precio: " + producto.getPrecio() + " - ID Categoria: " + producto.getCategoria());
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
