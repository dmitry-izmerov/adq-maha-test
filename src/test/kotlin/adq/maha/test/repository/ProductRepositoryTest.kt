package adq.maha.test.repository

import adq.maha.test.entity.Category
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductRepositoryTest {

	@Autowired
	lateinit var repository: ProductRepository

	@Test
	fun shouldReturnWatchWithDiscounts() {
		val list = repository.findAllByCategoryAndIdIn(Category.WATCH, listOf("001"))

		assertEquals(1, list.size)
		assertEquals(2, list.first().discounts.size)
	}
}
