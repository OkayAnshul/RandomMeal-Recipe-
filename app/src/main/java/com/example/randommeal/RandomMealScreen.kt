package com.example.randommeal

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.sharp.Face
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.dokar.sonner.ToastType
import com.dokar.sonner.Toaster
import com.dokar.sonner.ToasterDefaults
import com.dokar.sonner.rememberToasterState
import com.example.randommeal.ui.theme.PlayFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomMealScreen() {
    val mealViewModel: MealViewModel = viewModel()
    val viewModel by mealViewModel.state
    val localContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Random Meal App",
//                        color = Color.Black,
                        fontFamily = PlayFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                },
                actions = {
                    val toaster = rememberToasterState()
                    Toaster(
                        state = toaster, richColors = true, modifier = Modifier,
                    )
                    IconButton(onClick = {
                        toaster.show(message = "You Got Me!,\nApp Created by Anshul🫡")
                    }) {
                        Icon(
                            Icons.Sharp.Face, contentDescription = null
                        )
                    }
                    IconButton(onClick = { mealViewModel.refreshMeals() }) {
                        Icon(
                            Icons.Sharp.Refresh, contentDescription = null
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
//            Swipe(
//                state = SwipeRefreshState(isRefreshing),
//                onRefresh = {
//                    isRefreshing = true
//                    mealViewModel.refreshMeals() // Implement this method in your ViewModel
//                    isRefreshing = false
//                },
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues)
//            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                when {
                    viewModel.loading -> {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }

                    viewModel.error != null -> {
                        Text(
                            text = "Error Occurred: ${viewModel.error}",
                            Modifier.align(Alignment.Center)
                        )
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)
                                .border(
                                    BorderStroke(2.dp, Color.DarkGray),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        ) {
                            items(viewModel.list) { meal ->
                                ShowItem(meal = meal)
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ShowItem(meal: Meals) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = meal.strMeal,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = rememberAsyncImagePainter(meal.strMealThumb),
                contentDescription = meal.strMeal,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Category: ${meal.strCategory}",
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Area: ${meal.strArea}",
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = meal.strInstructions,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Ingredients:",
                fontWeight = FontWeight.Bold
            )
            meal.strIngredient1?.let { IngredientItem(it, meal.strMeasure1) }
            meal.strIngredient2?.let { IngredientItem(it, meal.strMeasure2) }
            meal.strIngredient3?.let { IngredientItem(it, meal.strMeasure3) }
            meal.strIngredient4?.let { IngredientItem(it, meal.strMeasure4) }
            meal.strIngredient5?.let { IngredientItem(it, meal.strMeasure5) }
            meal.strIngredient6?.let { meal.strMeasure6?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient7?.let { meal.strMeasure7?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient8?.let { meal.strMeasure8?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient9?.let { meal.strMeasure9?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient10?.let { meal.strMeasure10?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient11?.let { meal.strMeasure11?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient12?.let { meal.strMeasure12?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient13?.let { meal.strMeasure13?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient14?.let { meal.strMeasure14?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient15?.let { meal.strMeasure15?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient16?.let { meal.strMeasure16?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient17?.let { meal.strMeasure17?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient18?.let { meal.strMeasure18?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient19?.let { meal.strMeasure19?.let { it1 -> IngredientItem(it, it1) } }
            meal.strIngredient20?.let { meal.strMeasure20?.let { it1 -> IngredientItem(it, it1) } }
        }
    }
}

@Composable
fun IngredientItem(ingredient: String, measure: String) {
    Text(
        text = "$ingredient - $measure",
        modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
    )
}
