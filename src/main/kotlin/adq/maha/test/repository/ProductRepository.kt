package adq.maha.test.repository

import adq.maha.test.entity.Category
import adq.maha.test.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {
    fun findAllByCategoryAndIdIn(category: Category, ids: Collection<String>): List<Product>
}
