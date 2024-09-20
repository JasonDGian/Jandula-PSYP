package evalInicial.ejercicio2;

public class App {

	public static void main(String[] args) {
		
		GenericTicket generic = new GenericTicket();
		
		generic.setEntryKm(00);
		
		generic.setKmPrice(1);
		
		generic.setExitKm(2000);
		
		System.out.println( generic.toString() );
		
		System.out.println(generic.fetchDiscount2(0, generic.getTraveledDistance()));
		
		generic.setEntryKm(10);
		
	}

}
