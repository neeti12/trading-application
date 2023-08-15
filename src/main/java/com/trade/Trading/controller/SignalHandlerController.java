package com.trade.Trading.controller;


import com.trade.Trading.service.ISignalHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignalHandlerController {

    @Autowired
    private ISignalHandlerService signalhandlerService;

    //mapping the getSignal() method to /signal
    @RequestMapping(value = "/algo/{signal}", method = RequestMethod.POST)
    public void getAlgo(@PathVariable(value = "signal") int signal) {
        signalhandlerService.handleSignal(signal);
    }
}

