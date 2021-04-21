package adq.maha.test.service

import adq.maha.test.entity.Product
import org.springframework.stereotype.Service

interface PriceCalculator {
    fun calculate(products: Map<Product, Int>): Long
}

@Service
class PriceCalculatorImpl : PriceCalculator {
    override fun calculate(products: Map<Product, Int>): Long {
        return products.entries.fold(0L) { acc, e -> acc + e.key.price * e.value }
    }
}
