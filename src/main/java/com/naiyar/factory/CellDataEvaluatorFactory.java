package com.naiyar.factory;

import com.naiyar.csv.cell.evaluator.BodmasDataEvaluator;
import com.naiyar.csv.cell.evaluator.CellDataEvaluator;
import com.naiyar.csv.cell.evaluator.HttpDataEvaluator;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by vikasnaiyar on 17/10/16.
 */
@Slf4j
public class CellDataEvaluatorFactory {

    private static final CellDataEvaluatorFactory CELL_DATA_EVALUATOR_FACTORY_INSTANCE = new CellDataEvaluatorFactory();

    public static  CellDataEvaluatorFactory getInstance(){
        return  CELL_DATA_EVALUATOR_FACTORY_INSTANCE;
    }


    /**
     * Create evaluators to process result
     * @param data
     * @return
     */
    public CellDataEvaluator getCellDataEvaluator(String data) {
        CellDataEvaluator evaluator = null;

        if(data.startsWith("http")) {
            evaluator =  HttpDataEvaluator.getInstance();
        } else {
            evaluator = BodmasDataEvaluator.getInstance();
        }

        return evaluator;
    }

}
