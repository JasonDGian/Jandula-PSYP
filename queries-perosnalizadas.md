# 📌 Queries SQL personalizadas en Spring boot.
En pringboot es posible esscribir queries personalizadas. Esto se hace usando la anotación `@Query`. Esta anotación indica que un método ejecutará una consulta 
personalizada en la base de datos. La consulta está escrita en **JPQL (Java Persistence Query Language)**, que es similar a SQL pero adaptado para trabajar con entidades de Java.


¿Donde se escribe la query personalizada?
Las consultas personalizadas se especifican dentro de las interfaces de repositorio.

¿?




Ejemplo:
```java

@Query(
"SELECT new es.iesjandula.reaktor_printers_server.dto.ResponseDtoPrintAction(p.id, p.user, p.printer, p.status, p.fileName, "   +
       "p.copies, p.color, p.orientation, p.sides, " +
       "p.date, p.errorMessage, p.fileSizeInKB, "    + 
       "p.numeroPaginasPdf, p.hojasTotales) "        +
       "FROM PrintAction p " +
       "WHERE " +
       "(:user IS NULL OR p.user = :user) AND " +
       "(:printer IS NULL OR p.printer = :printer) AND " +
       "(:status IS NULL OR p.status = :status) AND " +
       "(:startDate IS NULL OR p.date >= :startDate) AND " +
       "(:endDate IS NULL OR p.date <= :endDate) " +
       "ORDER BY p.date DESC"
)


```
