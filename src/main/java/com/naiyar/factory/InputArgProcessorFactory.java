package com.naiyar.factory;

import com.naiyar.processor.CsvFileProcessor;
import com.naiyar.processor.CsvLineProcessor;
import com.naiyar.processor.InputProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * Created by vikasnaiyar on 17/10/16.
 */
@Slf4j
public class InputArgProcessorFactory {

    public static final String CSV_EXTENSION = ".csv";

    public static final String COMMA_STRING = ",";

    public static InputProcessor getInputProcessor(String argument) {

        log.info("Creating input processor for argument {}", argument);
        InputProcessor inputProcessor = null;

        if (!StringUtils.isEmpty(argument)) {
            if (argument.contains(COMMA_STRING)) {
                inputProcessor = new CsvLineProcessor();
            } else if (argument.endsWith(CSV_EXTENSION)) {
                inputProcessor = new CsvFileProcessor(new CsvLineProcessor());
            }
        }

        return inputProcessor;
    }

}
