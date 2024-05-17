import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("POGRAMACION FUNCIONAL");

        // 1. Filtrar los elementos de una lista(impares) [4, 1, 2, 3, 5] = [1,3,5]
        List<Integer> nums = Arrays.asList(4, 1, 2, 3, 5);
        System.out.println(nums);

        List<Integer> nums_impares = nums.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        // List<Integer> nums_impares = nums.stream().filter(n -> n % 2 != 0).toList();
        System.out.println(nums_impares);


        // 2. Convertir una lista de cadenas a mayusculas ["maria", "pedro",...]
        List<String> cadenas = Arrays.asList("maria", "pedro", "luis", "paulo", "lourdes");

        List<String> nombres_corregidos = cadenas.stream()
                .map(String::toUpperCase) // el :: hace referencia a culquier funcion por defecto del JDK
                .toList();
        System.out.println(nombres_corregidos); // [1, 3, 5]


        // 3. Sumar todos los elementos de una lista [4, 1, 2, 3, 5] = 15
        List<Integer> nums2 = Arrays.asList(4, 1, 2, 3, 5);

        Integer suma = nums2.stream()
                .reduce(0, Integer::sum);
        //.reduce(0, (n1, n2) -> n1+n2);
        System.out.println("La suma es: "+ suma); // La suma es 15


        // 4. Encontrar el maximo valor en una lista [4, 1, 2, 3, 5] = 5
        List<Integer> nums3 = Arrays.asList(4, 1, 2, 3, 5);
        Optional<Integer> mayor = nums3.stream().max(Integer::compareTo);
//        OptionalInt mayor = nums3.stream()
//                .mapToInt(Integer::intValue)
//                .max();
        System.out.println(mayor); //5


        // 5. Encontrar las palbras que empiezan en una letra especifica
        List<String> nombres = Arrays.asList("maria", "pedro", "luis", "paulo", "lourdes");
        // System.out.println("adf".startsWith("ag"));
        // System.out.println("paulo".charAt(0));

        List<String> nombres_filtrados = nombres.stream()
                .filter(p -> p.startsWith("l"))
                .collect(Collectors.toList());
        System.out.println(nombres_filtrados);

        // 6. Concatenar una lista de palabras["Java", "es", "un", "lenguaje", "robusto"] = "Java es un lenguaje robusto"
        List<String> palabras = Arrays.asList("Java", "es", "un", "lenguaje", "robusto");
        String frase = palabras.stream()
                .reduce((a, b) -> a + " " + b)
                .orElse(""); // en caso de que la lista quede vacia y no tenga un par para seguir con la operacion de reduccion

        System.out.println(frase);

        // 7. Eliminar duplicados en una lista de numeros
        List<Integer> nums4 = Arrays.asList(1, 4, 3, 4, 1, 2, 4, 5, 3);
        List<Integer> nums_no_duplicados = nums4.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(nums_no_duplicados);


        // 8. Crea una lista con los cuadrados de los elementos de una lista
        List<Integer> nums5 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> cuadrados = nums5.stream()
                .map(numero -> numero*numero) //Math.pow(numero, 2)
                .collect(Collectors.toList());
        System.out.println(cuadrados);

    }
}