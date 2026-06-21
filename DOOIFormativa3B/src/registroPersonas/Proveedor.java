package registroPersonas;

import model.Direccion;
import model.Persona;
import model.Rut;

/**
 * Clase que representa a un proveedor.
 * Incluye nombre de la empresa y giro empresarial
 * con sus validadores.
 */

public class Proveedor extends Persona {

    //Atributos de la clase proveedor
    private int idProveedor;
    private String nombreEmpresa;
    private String giroEmpresarial;

    /**
     * Constructor de la clase proveedor.
     *
     * @param idProveedor Número de identificación del proveedor.
     * @param nombre nombre del proveedor.
     * @param rut rut del proveedor.
     * @param nombreEmpresa nombre de la empresa proveedora.
     * @param giroEmpresarial giro de la empresa proveedora.
     * @param telefono teléfono del proveedor.
     * @param correoElectronico correo electrónico del proveedor.
     * @param direccion dirección del proveedor.

     */

    public Proveedor(int idProveedor, String nombre, Rut rut, String nombreEmpresa, String giroEmpresarial, String telefono, String correoElectronico, Direccion direccion) {
        super(nombre, rut, telefono, correoElectronico, direccion);

        //Llamada al validador
        if (validarIdProveedor(idProveedor)) {
            throw new IllegalArgumentException("Ingrese id válido");
        }
       if(validarNombreEmpresa(nombreEmpresa)) {
           throw new IllegalArgumentException("Ingrese nombre de empresa valido.");
       }
       if(validarGiroEmpresarial(giroEmpresarial)) {
           throw new IllegalArgumentException("Ingrese giro empresarial valido.");
       }

        //Asignación de atributos
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.giroEmpresarial = giroEmpresarial;
    }

    //Validadores

    private static boolean validarIdProveedor (int idProveedor) {
        return idProveedor <= 0;
    }

    private static boolean validarNombreEmpresa(String nombreEmpresa) {
        return nombreEmpresa == null || nombreEmpresa.trim().isEmpty();
    }

    private static boolean validarGiroEmpresarial(String giroEmpresarial) {
        return giroEmpresarial == null || giroEmpresarial.trim().isEmpty();
    }

    //Metodos get
    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getGiroEmpresarial() {
        return giroEmpresarial;
    }

    //Metodos set
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setGiroEmpresarial(String giroEmpresarial) {
        this.giroEmpresarial = giroEmpresarial;
    }

    /**
     * Metodo toString:
     * @return datos del proveedor.
     */

    @Override
    public String toString() {
        return  super.toString() +
                "\n--- PROVEEDOR ---" +
                "\nN°: " + idProveedor +
                "\nNombre Empresa: " + nombreEmpresa +
                "\nGiro Empresarial: " + giroEmpresarial;
    }
}


