package registroPersonas;

import model.Direccion;
import model.Persona;
import model.Rut;

/**
 * Clase que representa a un trabajador
 * Incluye cargo y seccion con sus validadores.
 */

public class Trabajador extends Persona {

    //Atributos de la clase trabajador
    private int idTrabajador;
    private String tipoTrabajador;
    private String seccion;

    /**
     * Constructor de la clase trabajador
     *
     * @param idTrabajador Número de identificación del trabajador.
     * @param nombre nombre del trabajador.
     * @param tipoTrabajador cargo del trabajador.
     * @param seccion sección laboral del trabajador.
     * @param rut rut del trabajador.
     * @param telefono teléfono del trabajador.
     * @param correoElectronico correo electrónico del trabajador.
     * @param direccion dirección de residencia del trabajador.
     *
     */

    public Trabajador (int idTrabajador,String tipoTrabajador, String seccion, String nombre, Rut rut, String telefono, String correoElectronico, Direccion direccion) {
        super(nombre, rut, telefono, correoElectronico, direccion);

        //Llamada al validador
        if (validarIdTrabajador(idTrabajador)) {
            throw new IllegalArgumentException("Ingrese id válido");
        }

        if (validarTipoTrabajador(tipoTrabajador)) {
            throw new IllegalArgumentException("Ingrese tipo de persona válida.");
        }

        if (validarSeccion(seccion)) {
            throw new IllegalArgumentException("Ingrese sección válida.");
        }

        //Asignación de atributos
        this.idTrabajador = idTrabajador;
        this.tipoTrabajador = tipoTrabajador;
        this.seccion = seccion;
    }

    //Validadores
    private static boolean validarIdTrabajador (int idTrabajador) {
        return idTrabajador <= 0;
    }
    private static boolean validarTipoTrabajador (String tipoTrabajador) {
        return tipoTrabajador == null || tipoTrabajador.trim().isEmpty();
    }
    private static boolean validarSeccion (String seccion) {
        return seccion ==null || seccion.trim().isEmpty();
    }

    //Metodos get
    public int getIdTrabajador() {
        return idTrabajador;
    }
    public String getTipoTrabajador() {
        return tipoTrabajador;
    }
    public String getSeccion() {
        return seccion;
    }

    //Metodos set
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * Metodo toString:
     * @return datos del trabajador.
     */
    @Override
    public String toString() {
        return  super.toString() +
                "\n--- TRABAJADOR ---" +
                "\nN° " + idTrabajador +
                "\nTipo de trabajador: " + tipoTrabajador +
                "\nSeccion: " + seccion;
    }
}
