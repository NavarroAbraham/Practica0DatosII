import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
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
        bubbleSort(data);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        double durationInSeconds = duration / 1_000_000_000.0;

        System.out.println("Tiempo de ejecución (segundos): " + durationInSeconds);
        System.out.println("Número de palabras organizadas: " + data.length);
    }

    public static void bubbleSort(String[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    String temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}