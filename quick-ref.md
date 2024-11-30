# Recibir un csv por parametros.
```java
@PostMapping(value = "/movies", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> uploadMovies( @RequestParam("ficheroCSV") MultipartFile ficheroCSV )
	{
		try
		{
			// Control de presencia de fichero.
			if (ficheroCSV == null || ficheroCSV.isEmpty())
			{
				throw new Exception("Fichero vacio o nulo.");
			}
			// Control de tipo fichero.
			if (!(ficheroCSV.getContentType().equalsIgnoreCase("text/csv") ))
			{
				throw new Exception("El fichero no corresponde al tipo esperado.");
			}
			
			// Crea un fichero temporal.
			File tempFile = File.createTempFile("tempFile", ".csv");
			
			ficheroCSV.transferTo(tempFile); // Transfiere al fichero temporal.	
			
			Scanner scanner = new Scanner(tempFile); // Utiliza el nuevo fichero generado.
			
			scanner.nextLine(); // Ignora cabecera.
			
			// Por cada campo encontrado imprimer por pantalla.
			if ( scanner.hasNext() ) {
				String[] campos = scanner.nextLine().split(",");
				for ( String campo : campos ) {
					System.out.println(campo);
				}
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok("Done");
	}
```
