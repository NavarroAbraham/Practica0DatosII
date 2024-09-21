import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void bucketSort(String[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        ArrayList<ArrayList<String>> buckets = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (String word : arr) {
            int bucketIndex = word.length() % n;
            buckets.get(bucketIndex).add(word);
        }

        for (ArrayList<String> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (String word : buckets.get(i)) {
                arr[index++] = word;
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Abraham\\Downloads\\palabras.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return;
        }

        int maxWords = 247047;

        List<String> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int wordCount = 0;
            while ((line = br.readLine()) != null && wordCount < maxWords) {
                dataList.add(line);
                wordCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] data = dataList.toArray(new String[0]);

        long startTime = System.nanoTime();
        bucketSort(data);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        double durationInSeconds = duration / 1_000_000_000.0;

        System.out.println("Tiempo de ejecución (segundos): " + durationInSeconds);
        System.out.println("Número de palabras organizadas: " + data.length);
    }
}