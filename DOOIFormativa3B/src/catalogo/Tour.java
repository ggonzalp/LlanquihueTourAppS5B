package catalogo;

/**
 * Clase que representa un tour.
 * Incluye identificación, tipo de tour y precio.
 */

public class Tour {

    //Atributos de la clase tour.
    private int idTour;
    private String tipoTour;
    private String nombreTour;
    private double precio;

    /**
     * Constructor de la clase Tour
     *
     * @param idTour identificación del tour.
     * @param tipoTour tipo de tour.
     * @param nombreTour nombre del tour.
     * @param precio precio del tour.
     */

    //Constructor
    public Tour(int idTour, String tipoTour, String nombreTour, double precio) {

        //Llamada a los validadores
        if(validarIdTour(idTour)) {
            throw new IllegalArgumentException("Ingrese Id válido");
        }

        if(validarTipoTour(tipoTour)) {
            throw new IllegalArgumentException("Ingrese tipo de tour válido");
        }

        if(validarNombreTour(nombreTour)) {
            throw new IllegalArgumentException("Ingrese nombre de tour válido");
        }

        if(validarPrecio(precio)) {
            throw new IllegalArgumentException("Ingrese precio de tour válido");
        }

        //Asignación de atributos
        this.idTour = idTour;
        this.tipoTour = tipoTour;
        this.nombreTour = nombreTour;
        this.precio = precio;
    }

    //Validadores
    private static boolean validarIdTour (int idTour) {
        return idTour <= 0;
    }

    private static boolean validarTipoTour (String tipoTour) {
        return tipoTour == null || tipoTour.trim().isEmpty();
    }

    private static boolean validarNombreTour (String nombreTour) {
        return nombreTour == null || nombreTour.trim().isEmpty();
    }

    private static boolean validarPrecio (double precio) {
        return precio <= 0;
    }


    //Métodos getter
    public int getIdTour() {
        return idTour;
    }

    public String getTipoTour() {
        return tipoTour;
    }

    public String getNombreTour() {
        return nombreTour;
    }

    public double getPrecio() {
        return precio;
    }

    //Métodos setter
    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public void setTipoTour(String tipoTour) {
        this.tipoTour = tipoTour;
    }

    public void setNombreTour(String nombreTour) {
        this.nombreTour = nombreTour;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Metodo toString para mostrar la información del tour
    @Override
    public String toString() {
        return "N°: " + idTour +
                "| Tipo de Tour: " + tipoTour +
                "| Nombre del Tour: " + nombreTour +
                "| Precio: $" + precio;
    }
}
