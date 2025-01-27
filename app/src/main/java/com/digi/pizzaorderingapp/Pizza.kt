package com.digi.pizzaorderingapp

enum class PizzaType {
    VEG, NON_VEG
}

data class Pizza(
    val title: String,
    val image: Int,
    val price: Double,
    val pizzaType: PizzaType,
)

data class Topping(
    val title: String,
    val price: Double,
    var isChecked: Boolean = false,
)

fun dummyPizzaRepository(): List<Pizza> {
    return listOf(
        Pizza(
            "Farmhouse Pizza",
            R.drawable.farm_pizza,
            299.00,
            PizzaType.VEG
        ),
        Pizza(
            pizzaType = PizzaType.VEG,
            title = "Mushroom Pizza",
            image = R.drawable.mushroom_pizza,
            price = 349.00,
        ),
        Pizza(
            title = "Pepperoni Pizza",
            image = R.drawable.pepporoni_pizza,
            price = 399.00,
            pizzaType = PizzaType.NON_VEG
        ),
        Pizza(
            title = "Veg Surprise Pizza",
            image = R.drawable.veg_surprise_pizza,
            price = 299.00,
            pizzaType = PizzaType.VEG
        ),
    )
}

fun topicRepository(): List<Topping> {
    return listOf(
        Topping("Cheese", 100.00),
        Topping("Tomato", 50.00),
        Topping("Onion", 50.00),
        Topping("Capsicum", 50.00),
        Topping("Mushroom", 50.00),
        Topping("Olive", 100.00),
        Topping("Paneer", 100.00),
    )
}