package adq.maha.test.service

import adq.maha.test.entity.Category
import adq.maha.test.entity.Product
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PriceCalculatorTest {

    @Autowired
    lateinit var priceCalculator: PriceCalculator

    @Test
    fun calculate() {
        val counts = mapOf(
            Product("1", "product1", 100, Category.WATCH) to 1,
            Product("2", "product2", 200, Category.WATCH) to 2,
            Product("3", "product3", 300, Category.WATCH) to 3,
        )
        val price = priceCalculator.calculate(counts)

        assertEquals(1400, price)
    }
}