package com.digi.pizzaorderingapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digi.pizzaorderingapp.Pizza
import com.digi.pizzaorderingapp.PizzaType
import com.digi.pizzaorderingapp.R
import com.digi.pizzaorderingapp.dummyPizzaRepository

@Composable
fun PizzaSelectionScreen(
    modifier: Modifier = Modifier,
    onConfirm: () -> Unit, // code hoisting
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(dummyPizzaRepository()){
                PizzaItem(pizza = it)
            }
        }
        FloatingActionButton(onClick = { onConfirm() }) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Done"
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaItem(
    modifier: Modifier = Modifier,
    pizza: Pizza,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = pizza.image),
                contentDescription = pizza.title,
                modifier = Modifier.size(200.dp)
            )
            Column(
                modifier
                    .height(200.dp)
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,

                ) {
                Text(
                    text = pizza.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.basicMarquee()
                )
                Text(
                    text = "$ ${pizza.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Blue.copy(alpha = .6f)
                )
                Box(
                    modifier = Modifier
                        .background(Color.Gray)
                        .padding(4.dp),
                ) {
                    Text(
                        text = pizza.pizzaType.name,
                        color = when (pizza.pizzaType) {
                            PizzaType.VEG -> Color.Green
                            PizzaType.NON_VEG -> Color.Red
                        },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PizzaItemPreview() {
    PizzaItem(
        pizza = Pizza(
            title = "Farmhouse Pizza",
            image = R.drawable.pepporoni_pizza,
            price = 299.00,
            pizzaType = PizzaType.VEG
        )
    )
}