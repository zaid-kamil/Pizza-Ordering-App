package com.digi.pizzaorderingapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digi.pizzaorderingapp.Topping
import com.digi.pizzaorderingapp.dummyPizzaRepository
import com.digi.pizzaorderingapp.topicRepository

@Composable
fun ToppingSelectionScreen(modifier: Modifier = Modifier, pizzaId: Int) {
    val pizza = dummyPizzaRepository()[pizzaId]
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column {
            Text(
                text = "Select Toppings",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp)
            )
            Text(text = "${pizza.title} selected", modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.padding(8.dp))
            LazyColumn(
                contentPadding = PaddingValues(vertical = 16.dp),
            ) {
                items(topicRepository()) {
                    ToppingItem(topping = it)
                }
            }
        }
    }
}

@Composable
fun ToppingItem(modifier: Modifier = Modifier, topping: Topping) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Checkbox(checked = topping.isChecked,
                onCheckedChange = { topping.isChecked = it }
            )
            Text(text = topping.title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$${topping.price}")
        }
    }
}

@Preview
@Composable
private fun ToppingItemPreview() {
    ToppingItem(topping = Topping("Cheese", 100.00))
}

@Preview(showSystemUi = true)
@Composable
private fun TSSPreview() {
    ToppingSelectionScreen(pizzaId = 0)
}