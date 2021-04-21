package adq.maha.test.controller

import adq.maha.test.entity.Category
import adq.maha.test.service.ProductService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CheckoutController(val productService: ProductService) {

    @PostMapping("/checkout", consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPrice(@RequestBody ids: List<String>): PriceDto {
        val productIds = ids.groupingBy { it }.eachCount()
        return PriceDto(productService.calculatePrice(Category.WATCH, productIds))
    }
}

data class PriceDto(val price: Long)
