package com.trade.Trading.suppliers;

import com.trade.Trading.external.Algo;

public class ThreeTrade implements Trade {
    @Override
    public void DoAlgorithm() {
        Algo algo = new Algo();
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }
}
