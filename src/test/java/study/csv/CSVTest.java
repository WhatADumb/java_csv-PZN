package study.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

public class CSVTest {
    @Test
    void testCreate() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Fadhil", "Firmansyah", 19);
        printer.printRecord("Alpha", "Beta", 19);
        printer.printRecord("Celeron", "Delta", 20);
        printer.flush();

        System.out.println(writer.getBuffer().toString());
    }
}
