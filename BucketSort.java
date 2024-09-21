import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(String[] arr) {
        int n = arr.length;

        // Crear n buckets vacíos
        ArrayList<ArrayList<String>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Colocar los elementos en los buckets correspondientes
        for (int i = 0; i < n; i++) {
            int bucketIndex = arr[i].charAt(0) - 'a'; // Usar la primera letra para definir el bucket
            buckets.get(bucketIndex).add(arr[i]);
        }

        // Ordenar los buckets individualmente
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets.get(i));
        }

        // Concatenar los buckets ordenados
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (String word : buckets.get(i)) {
                arr[index++] = word;
            }
        }
    }

    public static void main(String[] args) {
        // Cargar los datos de prueba aquí
        String[] data = { "apple", "orange", "banana", "grape", "cherry" };

        long startTime = System.nanoTime();
        bucketSort(data);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime); // Medición en nanosegundos
        System.out.println("Tiempo de ejecución (nanosegundos): " + duration);
        System.out.println("Datos ordenados: " + java.util.Arrays.toString(data));
    }
}