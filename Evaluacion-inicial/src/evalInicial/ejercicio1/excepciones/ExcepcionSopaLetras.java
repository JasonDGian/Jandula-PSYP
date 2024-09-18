package evalInicial.ejercicio1.excepciones;

public class ExcepcionSopaLetras extends Exception { 
	
    private static final long serialVersionUID = 1L;

	public ExcepcionSopaLetras(String errorMessage) {
        super(errorMessage);
    }
}
