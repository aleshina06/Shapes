import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static void readFile(String inputFilePath, Cache cache) throws FileNotFoundException {

        try (Scanner scanner = new Scanner(new File(inputFilePath))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                cache.put(line);
            }
        }
    }

    public static void main(String[] args) {

        try {
            Cache cache = new Cache();
            int cacheSize = requestCacheSize();
            cache.setCashSize(cacheSize);
            String inputFilePath = "C:\\Users\\alesh_000.VAIO\\Documents\\Работа\\Code\\T2_Cash\\src\\File.txt";

            readFile(inputFilePath, cache);
            cache.print();
        } catch (FileNotFoundException e) {
            System.err.println("The file is not found.");
        } catch (InputMismatchException e1) {
            System.err.println("Wrong size of cache.");
        }
    }

    private static int requestCacheSize() throws InputMismatchException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter size of cache: ");
            return scanner.nextInt();
        }
    }
}
