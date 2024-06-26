package Base;

import controller.CategoriaController;
import controller.ProductoController;
import controller.ClienteController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Antonio Sanchez
 */
public class BaseDatos {

    public static void main(String[] args) {
         
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.mostrarMenu();
        
        ProductoController productoController = new ProductoController();
        productoController.mostrarMenu();
        
        ClienteController ClienteController = new ClienteController();
        ClienteController.mostrarMenu(); 
    }
}
                