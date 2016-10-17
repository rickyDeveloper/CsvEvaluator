package com.naiyar.csv.cell.evaluator;


/**
 * Created by vikasnaiyar on 17/10/16.
 */
public class HttpDataEvaluator implements CellDataEvaluator {

    private static volatile HttpDataEvaluator INSTANCE = null;

    public static HttpDataEvaluator getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpDataEvaluator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataEvaluator();
                }
            }
        }


        return INSTANCE;
    }

    @Override
    public int evaluate(String data) {
        return 200;
    }
}
