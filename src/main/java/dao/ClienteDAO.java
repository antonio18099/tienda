package dao;

/**
 *
 * @author Antonio Sanchez
 */

import config.ConexionBD;
import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

        
public class ClienteDAO {
    private Connection conexion; //delcara preteterminado de SQL
    private ConexionBD conexionBD; //declara la conexionDB
    
    public ClienteDAO(){
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }
    
    public void crearCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombreCliente, telefono) VALUES (?,?)";//comando a la SQL
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombreCliente());
            statement.setString(2, cliente.getTelefono());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    public List<Cliente> leerClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int idClient = resultSet.getInt("idClient");
                String nombreCliente = resultSet.getString("nombreCliente");
                String telefono = resultSet.getString("telefono");
                Cliente cliente = new Cliente(idClient,nombreCliente,telefono);
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
                System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return listaClientes;
    }
    
    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nombreCliente = ?, telefono = ? WHERE idCliente = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, cliente.getNombreCliente());
            statement.setString(2, cliente.getTelefono());
            statement.setInt(3, cliente.getIdClient());
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }
    
    public void eliminarCliente(int idClient) {
        String sql = "DELETE FROM clientes WHERE idClient = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idClient);
            statement.executeUpdate();
        } catch (SQLException e) {
                System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }
    
    
    public int verificClientes(int idClient) {
                String sql = "SELECT COUNT(*) AS cuenta FROM clientes c WHERE c.idClient =?";
                int resultado = 0;
        try (PreparedStatement statement = conexion.prepareStatement(sql)){
            statement.setInt(1, idClient);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultado = resultSet.getInt("cuenta");
            }
        } catch (SQLException e) {
                System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return resultado;
        }
    
    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
    
}