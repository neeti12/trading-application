package com.trade.Trading.suppliers;

import com.trade.Trading.external.Algo;

public class OneTrade implements Trade {
    @Override
    public void DoAlgorithm() {
        Algo algo = new Algo();
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
    }
}
