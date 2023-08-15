package com.trade.Trading.suppliers;

import com.trade.Trading.external.Algo;

public class DefaultTrade implements Trade{
    @Override
    public void DoAlgorithm() {
        Algo algo = new Algo();
        algo.cancelTrades();
    }
}
