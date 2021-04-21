package adq.maha.test.controller

import adq.maha.test.controller.PriceDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class CheckoutControllerTest {

	@Autowired
	lateinit var mockMvc: MockMvc

	@Autowired
	lateinit var objectMapper: ObjectMapper

	@Test
	fun shouldReturnPrice() {
		val request = listOf("001", "001", "001", "001", "001", "002", "002", "002", "002",)
		mockMvc.perform(
			post("/checkout")
				.accept(APPLICATION_JSON)
				.contentType(APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))
		)
		.andExpect(status().isOk)
		.andExpect(content().json(objectMapper.writeValueAsString(PriceDto(1710))))
		.andExpect(content().contentType(APPLICATION_JSON))
	}
}
