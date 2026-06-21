package ui;

import data.GestorDatos;
import catalogo.Tour;
import model.Direccion;
import model.Rut;
import registroPersonas.Cliente;
import registroPersonas.Proveedor;
import registroPersonas.Trabajador;
import java.util.ArrayList;

/**
 * Clase principal del proyecto LlanquihueTourApp
 * Se encargará de crear las clases que la componen,
 * imprime y guarda los datos en el archivo.
 *
 */

public class Main {

    /**
     * Modo principal donde se ejecuta la aplicación.
     *
     * @param args argumentos de la línea de comandos.
     */

    public static void main(String[] args) {

        //Se crea un objeto de la clase GestorDatos.
        GestorDatos gestor = new GestorDatos();

        //Try lanza la información para aplicar validadores.
        try {

            //=== CLIENTE ===

            Cliente cliente1 = new Cliente(1, "Sakura", new Rut("25498673-0"), "Cliente", 32, "Japonesa", "95764637", "correo@electronico.com", new Direccion("Hashiko", 23, "Tokio", "Japón"));
            Cliente cliente2 = new Cliente(2, "John", new Rut("12856798-9"), "Cliente", 45, "Estadounidense", "95768354", "correo@electronico.com", new Direccion("5th avenue", 8, "New york", "EE.UU"));
            Cliente cliente3 = new Cliente(3, "Pedro", new Rut("12345657-0"), "Cliente", 25, "Mexicana", "98456372", "correo@electronico.com", new Direccion("Santa cecilia", 89, "Guadalajara", "México"));

            //Ruta del archivo de texto para Cliente
            String rutaCliente = "resources/Cliente.txt";

            //Se crea la lista de tours desde el archivo.
            ArrayList<Cliente> listaClientes = new ArrayList<>();

            //Metodo add para agregar tour1 a la lista.
            listaClientes.add(cliente1);
            listaClientes.add(cliente2);
            listaClientes.add(cliente3);

            //Se guardan los datos en el archivo.
            gestor.guardarClientes(rutaCliente, listaClientes, false);

            //Se carga la lista de tours desde el archivo.
            ArrayList<Cliente> clientes = gestor.cargarClientes(rutaCliente);

            //Recorrer una lista de clientes (personas).
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }


            //=== TRABAJADOR ===

            Trabajador trabajador1 = new Trabajador(1, "Guía", "aventura", "Ramón Martínez", new Rut("10387934-k"), "98775867", "rmartinez@correo.cl", new Direccion("Las frutillas", 8, "Llanquihue", "Chile"));
            Trabajador trabajador2 = new Trabajador(2, "Administrativo", "Oficina", "Roberto Monsalve", new Rut("13985674-k"), "45678392", "rgalvez@correo.cl", new Direccion("huilo huilo", 9, "Llanquihue", "Chile"));
            Trabajador trabajador3 = new Trabajador(3, "Guía", "Equestre", "Rodolfa Donoso", new Rut("19456378-0"), "97684657", "rdonoso@correo.cl", new Direccion("puerto", 45, "Llanquihue", "Chile"));

            //Ruta del archivo de texto para trabajador
            String rutaTrabajador = "resources/trabajador.txt";

            //Se crea la lista de tours desde el archivo.
            ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();

            //Metodo add para agregar tour1 a la lista.
            listaTrabajadores.add(trabajador1);
            listaTrabajadores.add(trabajador2);
            listaTrabajadores.add(trabajador3);

            //Se guardan los datos en el archivo.
            gestor.guardarTrabajadores(rutaTrabajador, listaTrabajadores, false);

            //Se carga la lista de tours desde el archivo.
            ArrayList<Trabajador> trabajadores = gestor.cargarTrabajadores(rutaTrabajador);

            //Recorrer una lista de trabajadores (personas).
            for (Trabajador trabajador : trabajadores) {
                System.out.println(trabajador);
            }

            //Filtro para trabajadores guía
            System.out.println("\n--- Guías ---");
            for (Trabajador trabajador : trabajadores) {
                if (trabajador.getTipoTrabajador().equalsIgnoreCase("Guía")) {
                    System.out.println(trabajador);
                }
            }

            //Filtro para trabajadores administrativos
            System.out.println("\n--- Administrativos ---");
            for (Trabajador trabajador : trabajadores) {
                if (trabajador.getTipoTrabajador().equalsIgnoreCase("Administrativo")) {
                    System.out.println(trabajador);
                }
            }


            //=== PROVEEDOR ===

            Proveedor proveedor1 = new Proveedor(1, "Luis Álvarez", new Rut("78564983-0"), "Aventur4x4", "transporte turistico","98576453", "lalvarez@correo.cl", new Direccion("av. el lago", 958, "Puerto Varas", "Chile"));
            Proveedor proveedor2 = new Proveedor(2, "José Miguel", new Rut("14356476-0"), "Cabalgatas experience", "turismo", "985647382", "Jm@correo.com", new Direccion("Los caballos", 45, "Chillán", "Chile"));
            Proveedor proveedor3 = new Proveedor(3, "Hernán Soto", new Rut("12345678-0"), "Dulce recuerdo", "Gastronómico","86757453", "kuchen@electronico.com", new Direccion("los dulces", 25, "Frutillar", "Chile"));

            //Ruta del archivo de texto para Proveedor
            String rutaProveedor = "resources/Proveedor.txt";

            ArrayList<Proveedor> listaProveedores = new ArrayList<>();
            listaProveedores.add(proveedor1);
            listaProveedores.add(proveedor2);
            listaProveedores.add(proveedor3);

            gestor.guardarProveedores(rutaProveedor, listaProveedores, false);

            ArrayList<Proveedor> proveedores = gestor.cargarProveedores(rutaProveedor);

            for(Proveedor proveedor : proveedores) {
                System.out.println(proveedor);
            }


            //=== TOURS ===

            //Catálogo Tours

            Tour tour1 = new Tour(1, "Equestre", "Cabalgata al atardecer", 20000);
            Tour tour2 = new Tour(2, "Aventura", "Canopy", 30000);
            Tour tour3 = new Tour(3, "Gastronómico", "La ruta del kuchen", 50000);
            Tour tour4 = new Tour(4, "Aventura", "Rafting", 85000);
            Tour tour5 = new Tour(5, "Equestre", "Cabalgata al amanecer", 20000);

            //Ruta del archivo de texto para Tour
            String rutaTour = "resources/tours.txt";

            //Se crea la lista de tours desde el archivo.
            ArrayList<Tour> listaTours = new ArrayList<>();

            //Metodo add para agregar tour1 a la lista.
            listaTours.add(tour1);
            listaTours.add(tour2);
            listaTours.add(tour3);
            listaTours.add(tour4);
            listaTours.add(tour5);

            //Se guardan los datos en el archivo.
            gestor.guardarTours(rutaTour, listaTours, false);

            //Se carga la lista de tours desde el archivo.
            ArrayList<Tour> tours = gestor.cargarTours(rutaTour);

            //Mostrar catálogo de tours
            System.out.println("\n" +
                    "=== CATÁLOGO LLANQUIHUE TOURS ===" +
                    "\n");
            //Recorrer una lista de tours (objetos).
            for (Tour tour : tours) {
                System.out.println(tour);
            }
            //Filtro para tours equestres
            System.out.println("\n--- Tours Equestres ---");
            for (Tour tour : tours) {
                if (tour.getTipoTour().equalsIgnoreCase("Equestre")) {
                    System.out.println(tour);
                }
            }

            //Filtro para tours de aventura
            System.out.println("\n---Tours Aventura ---");
            for (Tour tour : tours) {
                if (tour.getTipoTour().equalsIgnoreCase("Aventura")) {
                    System.out.println(tour);
                }
            }
            //Filtro para tours de Gastronómico
            System.out.println("\n---Tours Gastronómicos ---");
            for (Tour tour : tours) {
                if (tour.getTipoTour().equalsIgnoreCase("Gastronómico")) {
                    System.out.println(tour);
                }
            }

            //Catch atrapa el error e imprime mensaje de error.
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}