package adq.maha.test.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CheckoutController {

    @PostMapping("/checkout", consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPrice(@RequestBody ids: List<String>): PriceDto {
        return PriceDto(100)
    }
}

data class PriceDto(val price: Long)
