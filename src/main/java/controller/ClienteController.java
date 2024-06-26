package controller;


/**
 *
 * @author Antonio Sanchez
 */

import dao.ClienteDAO;
import model.Cliente;
import views.ClienteView;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    private ClienteDAO clienteDAO;
    private Scanner scanner;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Clientes ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Leer Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Verificar Cliente");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    leerCliente();
                    break;
                case 3:
                    actualizarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    verificClientes();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    private void crearCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el telefono: ");
        String telefono = scanner.nextLine();
        Cliente cliente = new Cliente(0, nombreCliente, telefono);
        clienteDAO.crearCliente(cliente);
        ClienteView.mostrarMensaje("Cliente creado exitosamente.");
    }

    private void leerCliente() {
        List<Cliente> clientes = clienteDAO.leerClientes();
        ClienteView.mostrarClientes(clientes);
    }

    private void actualizarCliente() {
        leerCliente();
        System.out.print("\nIngrese el ID del cliente que desea actualizar: ");
        int idClient = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nuevo nombre del cliente: ");
        String nuevoNombreCliente = scanner.nextLine();
        System.out.print("Ingrese el nuevo telefono del cliente: ");
        String nuevoTelefono = scanner.nextLine();
        Cliente cliente = new Cliente(idClient, nuevoNombreCliente, nuevoTelefono);
        clienteDAO.actualizarCliente(cliente);
        ClienteView.mostrarMensaje("Categoría actualizada exitosamente.");
    }

    private void eliminarCliente() {
        leerCliente();
        System.out.print("\nIngrese el ID del cliente que desea eliminar: ");
        int idClient = scanner.nextInt();
        clienteDAO.eliminarCliente(idClient);
        ClienteView.mostrarMensaje("Cliente eliminado exitosamente.");
    }

    private void verificClientes() {
        leerCliente();
        System.out.print("\nIngrese el ID del cliente que desea validar: ");
        int idClient = scanner.nextInt();
        int resp = clienteDAO.verificClientes(idClient);
        if (resp == 1) {
            ClienteView.mostrarMensaje("Cliente validado exitosamente.");
        } else {

            ClienteView.mostrarMensaje("Cliente no existe");
        }
    }

}
