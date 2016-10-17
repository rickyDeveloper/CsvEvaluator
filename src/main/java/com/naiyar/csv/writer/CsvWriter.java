package com.naiyar.csv.writer;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by vikasnaiyar on 17/10/16.
 * Stand alone class to write CSV file
 */
@Slf4j
public class CsvWriter {

    public static final String NEW_LINE_STRING = "\n";

    /**
     * Write data to csv file
     * @param filePath
     * @param data
     * @return
     */
    public boolean writeFile(String filePath, Collection<String> data) {
        boolean dataWrittenSuccessfully = true;
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(filePath));
            StringBuilder sb = new StringBuilder();
            for (String line: data) {
                sb.append(line).append(NEW_LINE_STRING);
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException ex) {
            dataWrittenSuccessfully = true;
            log.error("File not found at path {}" , filePath);
        } finally {
            if(pw != null) {
                    pw.close();
            }
        }

        return dataWrittenSuccessfully;
    }
}
