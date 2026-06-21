package model;

/**
 * Esta clase valida el formato del rut de la persona que se va a registrar.
 */

public class Rut {

    //Atributos de la clase rut
    private String numero;

    /**
     * Constructor de la clase rut:
     *
     * @param numeroRUT rut de la persona.
     */

    public Rut(String numeroRUT) {

        //Validador
        if (!numeroRUT.matches("[0-9]{7,8}-[0-9kK]")) {
            throw new IllegalArgumentException("Formato de rut no valido");
        }
        this.numero = numeroRUT;
    }

    //Metodo get
    public String getNumero() {
        return numero;
    }

    //Metodo set (el rut es un dato sensible que no debe ser modificado fácilmente)

    /**
     * Metodo toString:
     * @return datos del rut de la persona.
     */
    @Override
    public String toString() {
        return "RUT: " + numero;
    }
}
