package com.naiyar.csv.reader;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by vikasnaiyar on 17/10/16.
 */
@Slf4j
public class CSVReader {

    /**
     * Read records from file
     * @param csvFile
     * @return
     */
    public Collection<String> readCSVFile(String csvFile) {
        Collection<String> lines = new ArrayList<>();
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                log.info("Reading csv line {}", line);
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
           log.error("Error occured while reading csv file {}", e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lines;
    }

}
