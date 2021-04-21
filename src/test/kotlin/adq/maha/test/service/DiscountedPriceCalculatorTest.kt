package adq.maha.test.service

import adq.maha.test.entity.Category
import adq.maha.test.entity.Discount
import adq.maha.test.entity.Product
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DiscountedPriceCalculatorTest {

    @Autowired
    lateinit var calculator: DiscountedPriceCalculator

    @Test
    fun shouldCalculateDiscountedPrice() {
        val product1 = Product("1", "product1", 100, Category.WATCH)
        val product2 = Product("2", "product2", 200, Category.WATCH)
        val counts = mapOf(
            product1 to 19,
            product2 to 8
        )
        val discounts = listOf(
            Discount(1, product1, 5, 50),
            Discount(2, product1, 3, 80),
            Discount(3, product2, 3, 150),
            Discount(4, product2, 2, 170),
        )

        val pair = calculator.calculate(counts, discounts)

        assertEquals(mapOf(product1 to 1), pair.first)
        assertEquals(2230, pair.second)
    }
}