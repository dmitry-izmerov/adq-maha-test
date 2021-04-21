package adq.maha.test.service

import adq.maha.test.entity.Discount
import adq.maha.test.entity.Product
import org.springframework.stereotype.Service

interface DiscountedPriceCalculator {
    fun calculate(productCounts: Map<Product, Int>, discounts: List<Discount>): Pair<Map<Product, Int>, Long>
}

@Service
class DiscountedPriceCalculatorImpl : DiscountedPriceCalculator {
    override fun calculate(productCounts: Map<Product, Int>, discounts: List<Discount>): Pair<Map<Product, Int>, Long> {
        val map = mutableMapOf<Product, Int>()
        var discountedPrice = 0L

        discounts.groupBy { it.product }
            .mapValues { e -> e.value.sortedByDescending { it.number } }
            .forEach { (p, list) ->
                var numberOfProducts = productCounts[p] ?: 0
                for (discount in list) {
                    if (numberOfProducts >= discount.number) {
                        val times = numberOfProducts / discount.number
                        val discounted = discount.number * times
                        discountedPrice += discounted * discount.price
                        numberOfProducts -= discounted
                    }
                }
                if (numberOfProducts > 0) {
                    map[p] = numberOfProducts
                }
            }

        return Pair(map, discountedPrice)
    }
}


