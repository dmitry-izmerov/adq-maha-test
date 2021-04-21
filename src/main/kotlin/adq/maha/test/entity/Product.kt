package adq.maha.test.entity

import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id val id: String,
    val name: String,
    val price: Int,
    @Enumerated(EnumType.STRING) val category: Category,
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    var discounts: List<Discount> = listOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

enum class Category { WATCH }
