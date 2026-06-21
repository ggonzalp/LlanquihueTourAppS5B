package model;

/**
 * Clase que representa a la persona que puede ser cliente,
 * trabajador o proveedor con sus correpondientes atributos
 * nombre, telefono, correo electronico.
 * Incluye su direccion y su rut.
 * Además continene los validadores de contenido para
 * sus atributos.
 */

public class Persona {

    //Atributos de la persona
    private String nombre;
    private String telefono;
    private String correoElectronico;

    //Componentes de la clase persona. La persona tiene rut y direccion.
    private Rut rut;
    private Direccion direccion;


    /**
     * Constructor de la clase persona
     *
     * @param nombre nombre de la persona.
     * @param rut rut de la persona.
     * @param telefono teléfono de la persona.
     * @param correoElectronico correo electrónico de la persona.
     * @param direccion dirección de residencia de la persona.
     */

    public Persona(String nombre,Rut rut, String telefono, String correoElectronico, Direccion direccion) {

        //LLamada al validador
        if (validarNombre(nombre)) {
            throw new IllegalArgumentException("Ingrese nombre valido.");
        }
        if (validarTelefono(telefono)) {
            throw new IllegalArgumentException("Ingrese telefono valido.");
        }
        if (validarCorreo(correoElectronico)){
            throw new IllegalArgumentException("Ingrese correo electronico valido.");
        }

        //Asignación de atributos
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;

    }
        //Validadores
        private static boolean validarNombre (String nombre){
            return nombre == null || nombre.trim().isEmpty();
        }

        private static boolean validarTelefono (String telefono){
            return telefono == null || telefono.trim().isEmpty();
        }

        private static boolean validarCorreo (String correoElectronico) {
            return correoElectronico == null || !correoElectronico.contains("@");
        }


    //Metodo getter (corresponde al índice y obtiene los datos)
    public String getNombre() {
        return nombre;
    }
    public Rut getRut() {
        return rut;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public Direccion getDireccion() {
        return direccion;
    }

    //Metodo setter permite la modificación de los datos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //setRut: el RUT es un dato sensible que no debería modificarse.

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo toString (sobrescritura):
     * @return Muestra los datos de la persona, inclyendo la direccion.
     */
    @Override
    public String toString() {
        return "\n====  SISTEMA DE REGISTRO  ====" +
                "\n--- Datos de la persona ---" +
                "\n Nombre: " + nombre +
                "| Rut: " + rut +
                "| Telefono: " + telefono +
                "| Correo electronico: " + correoElectronico +
                "|" + direccion;

    }
}
