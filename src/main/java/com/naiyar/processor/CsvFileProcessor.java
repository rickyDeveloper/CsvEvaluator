package com.naiyar.processor;

import com.naiyar.csv.reader.CSVReader;
import com.naiyar.csv.writer.CsvWriter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by vikasnaiyar on 17/10/16.
 * <p>
 * This class has been implemented as decorator pattern.
 */
@Slf4j
public class CsvFileProcessor implements InputProcessor {

    public static final String RESULT_FILE_PATH = "/Users/vikasnaiyar/dev/CsvEvaluator/src/main/resources/result.csv";

    private CSVReader csvReader;

    private CsvWriter csvWriter;

    // This is sort of decorator pattern
    // where we are delegating work to other processor.
    private InputProcessor processor;

    public CsvFileProcessor(InputProcessor processor) {
        this.processor = processor;
        csvReader = new CSVReader();
        csvWriter = new CsvWriter();
    }

    public String process(String filePath) {
        // commands/steps are required to
        Collection<String> lines = readFile(filePath);
        //  Delegate the work to other processor
        Collection<String> resultLines = processLines(lines);
        // Write the file path
        writeFile(resultLines);

        return RESULT_FILE_PATH;
    }

    /**
     * Read the csv file
     * @param filePath
     * @return
     */
    private Collection<String> readFile(String filePath) {
        return csvReader.readCSVFile(filePath);
    }

    /**
     * Process line one by one.
     * <p>
     * //TODO lines can be processed in parallel also.
     *
     * @param lines
     * @return
     */
    private Collection<String> processLines(Collection<String> lines) {
        Collection<String> resultLines = new ArrayList<>(lines.size());
        if (lines != null && !lines.isEmpty()) {
            // Process each line of csv
            lines.stream().forEach(line -> {
                log.info("Processing line {}", line);
                resultLines.add(processor.process(line));
            });
        } else {
            log.info("No lines found in csv file");
        }

        return resultLines;
    }


    /**
     * Write data to CSV file
     *
     * @param lines
     * @return
     */
    private boolean writeFile(Collection<String> lines) {
        log.info("Wring result to file {}", RESULT_FILE_PATH);
        return csvWriter.writeFile(RESULT_FILE_PATH, lines);
    }
}
