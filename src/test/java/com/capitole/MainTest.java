package com.capitole;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTest {

    @Autowired
    private MockMvc mockMvc;

    private final String BASE_URL = "/api/price";

    @Test
    @DisplayName("Test 1 - Petición a las 10:00 del día 14")
    void testPriceAt10AMOn14th() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPrice", is(35.50)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)));
    }

    @Test
    @DisplayName("Test 2 - Petición a las 16:00 del día 14")
    void testPriceAt4PMOn14th() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14T16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPrice", is(25.45)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)));
    }

    @Test
    @DisplayName("Test 3 - Petición a las 21:00 del día 14")
    void testPriceAt9PMOn14th() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPrice", is(35.50)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)));
    }

    @Test
    @DisplayName("Test 4 - Petición a las 10:00 del día 15")
    void testPriceAt10AMOn15th() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-15T10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPrice", is(30.5)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)));
    }

    @Test
    @DisplayName("Test 5 - Petición a las 21:00 del día 16")
    void testPriceAt9PMOn16th() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-16T21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPrice", is(38.95)))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)));
    }

    @Test
    void shouldReturn404WhenResourceNotFound() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("productId", "99999") // Un producto que no existe
                        .param("brandId", "1")
                        .param("date", "2020-06-14T10:00:00"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status", is(404)))
                .andExpect(jsonPath("$.message", containsString("No applicable price found for the given parameters."))); // depende del mensaje que lances
    }

    @Test
    void shouldReturn400WhenInvalidParameter() throws Exception {
        mockMvc.perform(get(BASE_URL)
                        .param("productId", "invalid") // En vez de un número, pasamos texto
                        .param("brandId", "1")
                        .param("date", "2020-06-14T10:00:00"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.message", containsString("Invalid parameter")));
    }

}
