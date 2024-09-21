package evalInicial.ejercicio1.excepciones;

/**
 * Exception that provides a control flow for wordsearch.
 * Raised when the word search size is invalid.
 */
public class WordSearchSizeException extends Exception { 
	
    private static final long serialVersionUID = 1L;

	public WordSearchSizeException(String errorMessage) {
        super(errorMessage);
    }
}
