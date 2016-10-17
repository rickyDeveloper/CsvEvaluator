package com.naiyar.processor;

import com.naiyar.csv.cell.evaluator.CellDataEvaluator;
import com.naiyar.factory.CellDataEvaluatorFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by vikasnaiyar on 17/10/16.
 * <p>
 * // TODO, class can be made singleton
 */
@Slf4j
public class CsvLineProcessor implements InputProcessor {

    // TODO String constants can be moved to a standalone util class
    public static final String COMMA_STRING = ",";

    /**
     * Process each cell of the row
     *
     * @param line
     * @return
     */
    public String process(String line) {

        log.info("Processing input line {}", line);

        StringBuilder resultBuilder = new StringBuilder();

        String[] cellData = line.split(COMMA_STRING);

        if (cellData != null) {
            // Fetch the evaluator factory
            CellDataEvaluatorFactory evaluationFactory = CellDataEvaluatorFactory.getInstance();
            for (int i = 0; i < cellData.length; i++) {
                String data = cellData[i];
                // fetc the corresponding evaluator
                CellDataEvaluator evaluator = evaluationFactory.getCellDataEvaluator(data);
                if (evaluator != null) { // capture the result and store it
                    int result = evaluator.evaluate(data);
                    resultBuilder.append(result);
                }

                if (i != cellData.length - 1) { // Append comma if required
                    resultBuilder.append(COMMA_STRING);
                }
            }
        }

        log.info("Evaulated result is line is {}", resultBuilder.toString());

        return resultBuilder.toString();
    }

}
