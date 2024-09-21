package evalInicial.ejercicio1.excepciones;

/**
 * Word Exception raised when the word is too large for the table
 * or does not fit due to invalid starting location (coordiantes.)
 * 
 * @see Coordinate
 */
public class WordException extends Exception { 
	
    private static final long serialVersionUID = 1L;

	public WordException(String errorMessage) {
        super(errorMessage);
    }
}
