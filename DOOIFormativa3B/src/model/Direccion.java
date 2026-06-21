package model;

/**
 * Clase que representa la direccion de la persona que se va a registrar.
 * Incluye calle, número, ciudad y pais con sus validadores.
 */

public class Direccion {

    //Atributos de la clase direccion
    private String calle;
    private String ciudad;
    private String pais;
    private int numero;

    /**
     * Constructor de la clase direccion:
     * @param calle calle de la residencia de la persona.
     * @param numero numero de la residencia de la persona.
     * @param ciudad ciudad de residencia de la persona.
     * @param pais pais de residencia de la persona.
     */

    public Direccion (String calle, int numero, String ciudad, String pais) {

        //Llamada al validador
        if (validarCalle(calle)) {
            throw new IllegalArgumentException("Ingrese calle valida.");
        }

        if (validarNumero(numero)) {
            throw new IllegalArgumentException("Ingrese número mayor a 0.");
        }

        if (validarCiudad(ciudad)) {
            throw new IllegalArgumentException("Ingrese ciudad valida.");
        }

        if (validarPais(pais)) {
            throw new IllegalArgumentException("Ingrese pais valido.");
        }

        //Asignación de atributos
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    //Validadores
    private static boolean validarCalle(String calle) {
        return calle == null || calle.trim().isEmpty();
    }

    private static boolean validarNumero(int numero) {
        return numero < 0;
    }

    private static boolean validarCiudad(String ciudad) {
        return ciudad == null || ciudad.trim().isEmpty();
    }

    private static boolean validarPais(String pais) {
        return pais == null || pais.trim().isEmpty();
    }

    //Metodos get
    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    //Metodos set
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Metodo toString:
     * @return muestra la dirección completa de la persona en la persona.
     */
    @Override
    public String toString(){
        return  "\n--- Direccion ---" +
                "\nCalle : " + calle +
                "| Numero: #" + numero +
                "| Ciudad: " + ciudad +
                "| Pais: " + pais;
    }

}



