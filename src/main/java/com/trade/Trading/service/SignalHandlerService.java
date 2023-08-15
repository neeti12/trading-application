package com.trade.Trading.service;


import com.trade.Trading.external.Algo;
import com.trade.Trading.suppliers.Trade;
import com.trade.Trading.suppliers.TradeSupplier;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerService implements ISignalHandlerService {
    public void handleSignal(int signal) {

        TradeSupplier playerSupplier = new TradeSupplier();
        Trade tradeAttempt = playerSupplier.supplyTrade(signal);
        tradeAttempt.DoAlgorithm();
    }
}

