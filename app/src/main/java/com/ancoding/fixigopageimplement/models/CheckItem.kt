package com.ancoding.fixigopageimplement.models

data class CheckItem(
    var name: String? = null,
    val quantity: Int? = null,
    val price: Int? = null,
    var isSelected: Boolean = false,
    var date: String? = null,
    var comment: String? = null
) : java.io.Serializable

