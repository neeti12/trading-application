package com.trade.Trading.controller;

import com.trade.Trading.controller.SignalHandlerController;
import com.trade.Trading.external.Algo;
import com.trade.Trading.service.ISignalHandlerService;
import com.trade.Trading.service.SignalHandlerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SignalHandlerControllerTest {

    private MockMvc mvc;

    @InjectMocks
    private SignalHandlerController signalHandlerController;

    @InjectMocks
    private ISignalHandlerService signalhandlerService = new SignalHandlerService();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(signalHandlerController).build();
        setField(signalHandlerController,"signalhandlerService", signalhandlerService);
    }

    @Test
    public void checkControllerForAllsignals() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/algo/1"))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders
                        .post("/algo/2"))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders
                        .post("/algo/3"))
                .andExpect(status().isOk());

        // This will be performed for default type
        mvc.perform(MockMvcRequestBuilders
                        .post("/algo/3455"))
                .andExpect(status().isOk());
    }
}
