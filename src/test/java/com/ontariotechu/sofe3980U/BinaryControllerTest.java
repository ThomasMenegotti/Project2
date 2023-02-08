package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void postAdd2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "+").param("operand2", "11"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    @Test
    public void postAdd3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "+").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1010"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void postMultiply() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "*").param("operand2", "111"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "110001"))
                .andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void postMultiply2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "101").param("operator", "*").param("operand2", "11"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111"))
                .andExpect(model().attribute("operand1", "101"));
    }

    @Test
    public void postMultiply3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "01001").param("operator", "*").param("operand2", "001"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"))
                .andExpect(model().attribute("operand1", "01001"));
    }

    @Test
    public void postOr() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1011").param("operator", "|").param("operand2", "01001"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1011"))
                .andExpect(model().attribute("operand1", "1011"));
    }

    @Test
    public void postOr2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1100").param("operator", "|").param("operand2", "0101"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "1100"));
    }

    @Test
    public void postOr3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1011").param("operator", "|").param("operand2", "11001"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11011"))
                .andExpect(model().attribute("operand1", "1011"));
    }

    @Test
    public void postAnd() throws Exception {
        this.mvc.perform(post("/").param("operand1", "01011").param("operator", "&").param("operand2", "1001"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"))
                .andExpect(model().attribute("operand1", "01011"));
    }

    @Test
    public void postAnd2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "11011").param("operator", "&").param("operand2", "11011"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11011"))
                .andExpect(model().attribute("operand1", "11011"));
    }

    @Test
    public void postAnd3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "01011").param("operator", "&").param("operand2", "11011"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1011"))
                .andExpect(model().attribute("operand1", "01011"));
    }

}