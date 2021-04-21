package adq.maha.test.service

import adq.maha.test.entity.Category
import adq.maha.test.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    val repository: ProductRepository,
    val discountedPriceCalc: DiscountedPriceCalculator,
    val priceCalc: PriceCalculatorImpl,
) {

    fun calculatePrice(category: Category, productIds: Map<String, Int>): Long {
        val productList = repository.findAllByCategoryAndIdIn(category, productIds.keys)
        val productCounts = productIds.mapKeys { e ->
            productList.find { it.id == e.key } ?: throw RuntimeException("Product with id: ${e.key} not found")
        }
        val pair = discountedPriceCalc.calculate(productCounts, productList.flatMap { it.discounts } )
        val price = priceCalc.calculate(pair.first)
        return price + pair.second
    }
}