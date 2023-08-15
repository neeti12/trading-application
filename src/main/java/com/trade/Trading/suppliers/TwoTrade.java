package com.trade.Trading.suppliers;

import com.trade.Trading.external.Algo;

public class TwoTrade implements Trade {
    @Override
    public void DoAlgorithm() {
        Algo algo = new Algo();
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
    }
}
