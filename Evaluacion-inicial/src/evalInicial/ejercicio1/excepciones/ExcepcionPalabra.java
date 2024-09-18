package evalInicial.ejercicio1.excepciones;

public class ExcepcionPalabra extends Exception { 
	
    private static final long serialVersionUID = 1L;

	public ExcepcionPalabra(String errorMessage) {
        super(errorMessage);
    }
}
