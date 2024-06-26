package views;

/**
 *
 * @author Antonio Sanchez
 */

import model.Cliente;
import java.util.List;

public class ClienteView {
    public static void mostrarClientes(List<Cliente> clientes){
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes disponibles.");
            } else {
                System.out.println("\n--- Lista de Clientes ---");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente.getIdClient() + ". " + cliente.getNombreCliente() + ". " + cliente.getTelefono());
            }
        }
    }
    
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}