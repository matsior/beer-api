package matsior.api.beer;

import com.fasterxml.jackson.databind.ObjectMapper;
import matsior.api.beer.dto.BeerFullResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetSingleBeer() throws Exception {
        // given

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/beers/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        // then
        BeerFullResponse beer = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), BeerFullResponse.class);
        assertThat(beer).isNotNull();
        assertThat(beer.id()).isEqualTo(1L);
        assertThat(beer.name()).isEqualTo("Y-Solowarm");
        assertThat(beer.producerName()).isEqualTo("browar3");
        assertThat(beer.country()).isEqualTo("Japan");
    }
}