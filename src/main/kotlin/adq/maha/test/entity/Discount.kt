package adq.maha.test.entity

import javax.persistence.*

@Entity
@Table(name = "discounts")
data class Discount(
    @Id @GeneratedValue val id: Long,
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product,
    val number: Int,
    val price: Int,
) {
    override fun toString(): String {
        return "Discount(id=$id, product=${product.id}, number=$number, price=$price)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Discount

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
