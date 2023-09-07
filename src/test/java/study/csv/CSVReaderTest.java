package study.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVReaderTest {
    @Test
    void testReadCSV() throws IOException {
        Path path = Path.of("src/main/resources/sample.csv");
        Writer filesWriter = Files.newBufferedWriter(path);
        Reader filesReader = Files.newBufferedReader(path);

        CSVPrinter printer = new CSVPrinter(filesWriter, CSVFormat.DEFAULT);
        printer.printRecord("Bojard", 20_000, true);
        printer.printRecord("Alova", 100_000, true);
        printer.printRecord("Roger", 500_000, false);
        printer.flush();

        CSVParser parser = new CSVParser(filesReader, CSVFormat.DEFAULT);
        for (CSVRecord record : parser) {
            System.out.println("BOUNTY");
            System.out.println("Name: " + record.get(0));
            System.out.println("Bounty: " + record.get(1));
            System.out.println("Is Alive: " + record.get(2));
            System.out.println("===============================");
        }
    }

    @Test
    void testReadCSVHeader() throws IOException {
        Path path = Path.of("src/main/resources/sample.csv");
        Writer filesWriter = Files.newBufferedWriter(path);
        Reader filesReader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(
                "Name", "Bounty", "Is Alive"
        ).build();
        CSVPrinter printer = new CSVPrinter(filesWriter, format);
        printer.printRecord("Bojard", 20_000, true);
        printer.printRecord("Alova", 100_000, true);
        printer.printRecord("Roger", 500_000, false);
        printer.flush();

        CSVFormat format1 = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser parser = new CSVParser(filesReader, format1);
        for (CSVRecord record : parser) {
            System.out.println("BOUNTY");
            System.out.println("Name: " + record.get("Name"));
            System.out.println("Bounty: " + record.get("Bounty"));
            System.out.println("Is Alive: " + record.get("Is Alive"));
            System.out.println("===============================");
        }
    }

    @Test
    void testReadCSVHeaderTDF() throws IOException {
        Path path = Path.of("src/main/resources/sample_TDF.csv");
        Writer filesWriter = Files.newBufferedWriter(path);
        Reader filesReader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.TDF.builder().setHeader(
                "Name", "Bounty", "Is Alive"
        ).build();
        CSVPrinter printer = new CSVPrinter(filesWriter, format);
        printer.printRecord("Bojard", 20_000, true);
        printer.printRecord("Alova", 100_000, true);
        printer.printRecord("Roger", 500_000, false);
        printer.flush();

        CSVFormat format1 = CSVFormat.TDF.builder().setHeader().build();
        CSVParser parser = new CSVParser(filesReader, format1);
        for (CSVRecord record : parser) {
            System.out.println("BOUNTY");
            System.out.println("Name: " + record.get("Name"));
            System.out.println("Bounty: " + record.get("Bounty"));
            System.out.println("Is Alive: " + record.get("Is Alive"));
            System.out.println("===============================");
        }
    }
}
