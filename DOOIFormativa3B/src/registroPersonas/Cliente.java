package registroPersonas;

import model.Direccion;
import model.Persona;
import model.Rut;

/**
 * Clase que representa a un cliente
 * Incluye edad y nacionalidad con sus validadores.
 */

public class Cliente extends Persona {

    //Atributos de la clase cliente
    private int idCliente;
    private String tipoPersona;
    private int edad;
    private String nacionalidad;

    /**
     * Constructor de la clase cliente
     *
     * @param idCliente Número de identificación del cliente.
     * @param nombre nombre del cliente.
     * @param rut número de rut o pasaporte del cliente.
     * @param tipoPersona tipo de persona (cliente, trabajador, proveedor).
     * @param edad edad del cliente.
     * @param nacionalidad nacionalidad del cliente.
     * @param telefono teléfono del cliente.
     * @param correoElectronico correo electrónico del cliente.
     * @param direccion dirección del cliente.
     */
    public Cliente(int idCliente, String nombre, Rut rut, String tipoPersona, int edad, String nacionalidad, String telefono, String correoElectronico, Direccion direccion) {
        super(nombre, rut, telefono, correoElectronico, direccion);

        //Llamada al validador
        if (validarIdCliente(idCliente)) {
            throw new IllegalArgumentException("Ingrese id válido");
        }
        if (validarTipoPersona(tipoPersona)) {
            throw new IllegalArgumentException("Ingrese tipo de persona válida.");
        }
        if (validarEdad(edad)) {
            throw new IllegalArgumentException("Ingrese edad válida.");
        }
        if (validarNacionalidad(nacionalidad)) {
            throw new IllegalArgumentException("Ingrese nacionalidad válida.");
        }

        this.idCliente = idCliente;
        this.tipoPersona = tipoPersona;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    //Validadores
    private static boolean validarIdCliente (int idCliente) {
        return idCliente < 0;
    }

    private static boolean validarTipoPersona (String tipoPersona) {
        return tipoPersona == null || tipoPersona.trim().isEmpty();
    }

    private static boolean validarEdad(int edad) {
        return edad <= 0;
    }

    private static boolean validarNacionalidad(String nacionalidad) {
        return nacionalidad == null || nacionalidad.trim().isEmpty();
    }

    //Metodos get
    public int getIdCliente() {
        return idCliente;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }


    //Metodos set
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Metodo toString:
     * @return Retorna datos del cliente
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n--- CLIENTE ---" +
                "\nN° " + idCliente +
                "| persona: " + tipoPersona +
                "| Edad: " + edad +
                "| Nacionalidad: " + nacionalidad;
    }

}



