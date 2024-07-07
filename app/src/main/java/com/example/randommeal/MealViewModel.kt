package com.example.randommeal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {

    private val _state = mutableStateOf(MealState())
    val state: State<MealState> = _state

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val response = MealService.getData()
            try {
                _state.value = _state.value.copy(
                    loading = false,
                    error = null,
                    list = response.meals
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    loading = false,
                    error = e.message,
                )
            }
        }

    }

    fun refreshMeals() {
        fetchData()
    }

    data class MealState(
        val loading: Boolean = true,
        val error: String? = null,
        val list: List<Meals> = emptyList()
    )
}