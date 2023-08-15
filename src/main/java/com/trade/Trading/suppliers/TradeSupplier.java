package com.trade.Trading.suppliers;

import java.util.function.Supplier;
import java.util.*;

public class TradeSupplier {

    private static final Map<Integer, Supplier<Trade>> TRADE_SUPPLIER;

    static {
        final Map<Integer, Supplier<Trade>> players = new HashMap<>();
        players.put(1, OneTrade::new);
        players.put(2, TwoTrade::new);
        players.put(3, ThreeTrade::new);

        TRADE_SUPPLIER = Collections.unmodifiableMap(players);
    }

    public Trade supplyTrade(int tradeType) {
        Supplier<Trade> player = TRADE_SUPPLIER.get(tradeType);

        if (player == null) {
            return DefaultTrade::new;
        }
        return player.get();
    }
}
