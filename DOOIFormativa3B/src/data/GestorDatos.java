package data;

import catalogo.Tour;
import model.Direccion;
import model.Rut;
import registroPersonas.Cliente;
import registroPersonas.Proveedor;
import registroPersonas.Trabajador;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Clase que representa al gestor de datos, encargada de leer y escribir los datos desde un archivo de texto.
 */

public class GestorDatos {

    //===CLIENTE===

    /**
     * Metodo que recibe la ruta del archivo.
     *
     * @param rutaCliente ruta del archivo Cliente.txt
     * @return retorna la lista de clientes.
     */

    public ArrayList<Cliente> cargarClientes (String rutaCliente) {

        //Lista dinámica donde se almacenará a las personas.
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {

            //Apertura del archivo para la lectura.
            BufferedReader lector = new BufferedReader(new FileReader(rutaCliente));

            //Lectura línea por línea.
            String linea;

            //Lectura del archivo línea por línea
            while ((linea = lector.readLine()) != null) {

                //Se separan los atributos usando split (;).
                String[] atributos = linea.split(";");

                //Se valida que la línea tenga la cantidad de campos necesaria.
                if (atributos.length == 12) {

                    try {
                        int idCliente = Integer.parseInt(atributos[0]);
                        String nombre = atributos[1];
                        Rut rut = new Rut(atributos[2]);
                        String tipoPersona = atributos[3];
                        int edad = Integer.parseInt(atributos [4]);
                        String nacionalidad = atributos[5];
                        String telefono = atributos[6];
                        String correoElectronico = atributos[7];
                        Direccion direccion = new Direccion(atributos[8], Integer.parseInt(atributos[9]), atributos[10], atributos[11]);

                        Cliente cliente = new Cliente (idCliente, nombre, rut, tipoPersona, edad, nacionalidad, telefono, correoElectronico, direccion);

                        listaClientes.add(cliente);

                    } catch (NumberFormatException e) {
                        System.out.println("Línea inválida, se omite: " + e.getMessage());
                    }
                }
            }

            //Cierre del lector
            lector.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return listaClientes;
    }

    /**
     * Metodo que carga los datos desde el archivo Cliente.txt
     *
     * @param rutaCliente ruta del archivo Cliente.txt
     * @param listaClientes lista de clientes.
     * @param apend controla si el archivo se sobreescribe.
     */

    public void guardarClientes(String rutaCliente, ArrayList<Cliente> listaClientes, boolean apend) {

        //Apertura del archivo para la escritura.
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCliente, apend))) {

            //Metodo for recorre la lista y escribe cada tour.
            for (Cliente c : listaClientes) {
                String linea =  c.getIdCliente() + ";" +
                                c.getNombre() + ";" +
                                c.getRut().getNumero() + ";" +
                                c.getTipoPersona() + ";" +
                                c.getEdad() + ";" +
                                c.getNacionalidad() + ";" +
                                c.getTelefono() + ";" +
                                c.getCorreoElectronico() + ";" +
                                c.getDireccion().getCalle()  + ";" +
                                c.getDireccion().getNumero()  + ";" +
                                c.getDireccion().getCiudad()  + ";" +
                                c.getDireccion().getPais();

                escritor.write(linea);
                escritor.newLine();
            }

            //Cierre del escritor
            escritor.close();

            System.out.println("Datos guardados correctamente en " + rutaCliente);

        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }


//=== TRABAJADOR ===

/**
 * Metodo que recibe la ruta del archivo.
 * @param rutaTrabajador ruta del archivo Trabajador.txt
 * @return retorna lista de trabajadores.
 */

public ArrayList<Trabajador> cargarTrabajadores (String rutaTrabajador) {

    //Lista dinámica donde se almacenará a los trabajadores.
    ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();

    try {
        //Apertura del archivo para la lectura.
        BufferedReader lector = new BufferedReader(new FileReader(rutaTrabajador));

        //Lectura línea por línea.
        String linea;

        //Lectura del archivo línea por línea
        while ((linea = lector.readLine()) != null) {

            //Se separa usando split (;).
            String[] atributos = linea.split(";");

            //Se valida que la línea tenga la cantidad de campos necesaria.
            if (atributos.length == 11) {

                try {
                    int idTrabajador = Integer.parseInt(atributos[0]);
                    String tipoTrabajador = atributos[1];
                    String seccion = atributos[2];
                    String nombre = atributos[3];
                    Rut rut = new Rut(atributos[4]);
                    String telefono = atributos[5];
                    String correoElectronico = atributos[6];
                    Direccion direccion = new Direccion(atributos[7], Integer.parseInt(atributos[8]), atributos[9], atributos[10]);

                    Trabajador trabajador = new Trabajador (idTrabajador, tipoTrabajador, seccion, nombre, rut, telefono, correoElectronico, direccion);

                    listaTrabajadores.add(trabajador);

                } catch (NumberFormatException e) {
                    System.out.println("Línea inválida, se omite: " + e.getMessage());
                }
            }
        }
        //Cierre del lector
        lector.close();

    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());

    }
    return listaTrabajadores;
}

    /**
     * Metodo para guardar la lista trabajadores.
     * @param rutaTrabajador ruta del archivo Trabajador.txt
     * @param listaTrabajadores Lista de los trabajadores de la agencia
     * @param apend controla si el archivo se sobreescribe.
     */
    public void guardarTrabajadores (String rutaTrabajador, ArrayList<Trabajador> listaTrabajadores, boolean apend) {

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaTrabajador, apend))) {

            //Recorre la lista y escribe cada tour
            for (Trabajador t : listaTrabajadores) {
                String linea =  t.getIdTrabajador() + ";" +
                        t.getTipoTrabajador() + ";" +
                        t.getSeccion() + ";" +
                        t.getNombre() + ";" +
                        t.getRut().getNumero() + ";" +
                        t.getTelefono() + ";" +
                        t.getCorreoElectronico() + ";" +
                        t.getDireccion().getCalle()  + ";" +
                        t.getDireccion().getNumero()  + ";" +
                        t.getDireccion().getCiudad()  + ";" +
                        t.getDireccion().getPais();

                escritor.write(linea);
                escritor.newLine();
            }

            //Cierre del escritor
            escritor.close();

            System.out.println("Datos guardados correctamente en " + rutaTrabajador);

        } catch (IOException e) {

            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }


//=== PROVEEDOR ===

    /**
     * Metodo para cargar la lista de proveedores.
     * @param rutaProveedor ruta del archivo Proveedor.txt
     * @return retorna la lista de proveedores de la agencia.
     */

    public ArrayList<Proveedor> cargarProveedores(String rutaProveedor) {

        //Lista dinámica que almacenará a los proveedores.
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();

        try {
            //Apertura del archivo para lectura.
            BufferedReader lector = new BufferedReader(new FileReader(rutaProveedor));

            //Lectura línea por línes.
            String linea;

            //Lectura del archivo línea por línea.
            while ((linea = lector.readLine()) != null) {

                //Se separa usando split(;).
                String[] atributos = linea.split(";");

                //Se valida que la línea tenga la cantidad de datos necesaria.
                if (atributos.length == 11) {
                    try {
                        int idProveedor = Integer.parseInt(atributos[0]);
                        String nombre = atributos[1];
                        Rut rut = new Rut(atributos[2]);
                        String nombreEmpresa = atributos[3];
                        String giroEmpresarial = atributos[4];
                        String telefono = atributos[5];
                        String correoElectronico = atributos[6];
                        Direccion direccion = new Direccion(atributos[7], Integer.parseInt(atributos[8]), atributos[9], atributos[10]);

                        Proveedor proveedor = new Proveedor(idProveedor, nombre, rut, nombreEmpresa, giroEmpresarial, telefono, correoElectronico, direccion);

                        listaProveedores.add(proveedor);
                    } catch (NumberFormatException e) {
                        System.out.println("Línea inválida, se omite: " + e.getMessage());
                    }
                }

            }
            //Cierre del lector
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return listaProveedores;
    }

    /**
     * Metodo para guardar la lista de proveedores.
     * @param rutaProveedor ruta del archivo proveedor.txt
     * @param listaProveedores lista de proveedores
     * @param apend controla si el archivo se sobreescribe.
     */

    public void guardarProveedores(String rutaProveedor, ArrayList<Proveedor> listaProveedores, boolean apend) {

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaProveedor, apend))) {

            for (Proveedor p : listaProveedores) {
                String linea = p.getIdProveedor() + ";" +
                        p.getNombre() + ";" +
                        p.getRut().getNumero() + ";" +
                        p.getNombreEmpresa() + ";" +
                        p.getGiroEmpresarial() + ";" +
                        p.getTelefono() + ";" +
                        p.getCorreoElectronico() + ";" +
                        p.getDireccion().getCalle() + ";" +
                        p.getDireccion().getNumero() + ";" +
                        p.getDireccion().getCiudad() + ";" +
                        p.getDireccion().getPais();

                escritor.write(linea);
                escritor.newLine();
            }
            //Cierre del escritor
            escritor.close();

            System.out.println("Datos guardados correctamente en " + rutaProveedor);

        }catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }




//=== TOURS ===

    /**
     * Metodo para cargar lista de tours.
     * @param rutaCatalogo ruta del archivo Catalogo.txt
     * @return retorna la lista del catálogo de tours de la agencia.
     */

    public ArrayList<Tour> cargarTours(String rutaCatalogo) {

        //Lista dinámica donde se almacenarán los tours.
        ArrayList<Tour> listaTours = new ArrayList<>();

        try {
            //Apertura del archivo para la lectura.
            BufferedReader lector = new BufferedReader(new FileReader(rutaCatalogo));

            //Lectura línea por línea
            String linea;

            //Lectura del archivo línea por línea.
            while ((linea = lector.readLine()) != null) {

                //Se separa la línea usando split (;)
                String[] partes = linea.split(";");

                //Se valida que la línea tenga 4 datos.
                if (partes.length == 4) {

                    try {
                        //Se convierten los datos al formato entregado.
                        int id = parseInt(partes[0]);
                        String tipoTour = partes[1];
                        String nombreTitulo = partes[2];
                        double precio = Double.parseDouble(partes[3]);

                        //Se crea un objeto Tour con los datos leídos.
                        Tour tour = new Tour(id, tipoTour, nombreTitulo, precio);

                        //Se captura el objeto a la salida.
                        listaTours.add(tour);
                    } catch (NumberFormatException e) {
                        System.out.println("Línea inválida, se omite: " + e.getMessage());
                    }

                }
            }

            //Cierre del lector
            lector.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }


        //Se retorna la lista con los tours cargados
        return listaTours;
    }

    /**
     * Metodo para guardar la lista de tours en el archivo Catalogo.txt
     * @param rutaArchivo ruta del archivo Catalogo.txt
     * @param listaTours lista de tours.
     * @param apend controla si el archivo se sobreescribe.
     */
    public void guardarTours(String rutaArchivo, ArrayList<Tour> listaTours, boolean apend) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo, apend))) {
            //Recorre la lista y escribe cada tour
            for (Tour t : listaTours) {
                String linea = t.getIdTour() + ";" + t.getTipoTour() + ";" + t.getNombreTour() + ";" + t.getPrecio();
                escritor.write(linea);
                escritor.newLine();
            }

            //Cierre del escritor
            escritor.close();

            System.out.println("Datos guardados correctamente en " + rutaArchivo);

        } catch (IOException e) {

            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}






