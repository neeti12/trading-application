package com.trade.Trading;

import com.trade.Trading.suppliers.*;
import org.junit.Assert;
import org.junit.Test;


public class TradeSupplierTest {

    @Test
    public void checkSuppliers() {
        TradeSupplier playerSupplier = new TradeSupplier();
        Trade tradeAttempt = playerSupplier.supplyTrade(1);
        Assert.assertEquals(tradeAttempt.getClass(), OneTrade.class);

        tradeAttempt = playerSupplier.supplyTrade(2);
        Assert.assertEquals(tradeAttempt.getClass(), TwoTrade.class);

        tradeAttempt = playerSupplier.supplyTrade(3);
        Assert.assertEquals(tradeAttempt.getClass(), ThreeTrade.class);

        // Check default
        tradeAttempt = playerSupplier.supplyTrade(1254);
        Assert.assertEquals(tradeAttempt.getClass(), DefaultTrade.class);
    }
}
