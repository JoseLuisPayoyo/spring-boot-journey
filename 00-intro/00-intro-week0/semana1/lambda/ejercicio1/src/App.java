import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Producto> productos = List.of(
            new Producto("Camiseta", 19.99),
            new Producto("Pantalón", 39.99),
            new Producto("Gorra", 14.99),
            new Producto("Chaqueta", 89.99),
            new Producto("Calcetines", 5.99)
        );
        //mas de 20 euros
        productos.stream().filter(p -> p.getPrecio() > 20);

        //convertir a mayus y devolver lista
        productos.stream()
                    .map(p -> p.getNombre().toUpperCase())
                    .collect(Collectors.toList());

        //

    }
}
