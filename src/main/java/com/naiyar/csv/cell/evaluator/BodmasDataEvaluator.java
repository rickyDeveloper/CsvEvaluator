package com.naiyar.csv.cell.evaluator;

/**
 * Created by vikasnaiyar on 17/10/16.
 */
public class BodmasDataEvaluator implements CellDataEvaluator {

    private static volatile BodmasDataEvaluator INSTANCE = null;

    public static BodmasDataEvaluator getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpDataEvaluator.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BodmasDataEvaluator();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public int evaluate(String data) {
        return 25;
    }
}
