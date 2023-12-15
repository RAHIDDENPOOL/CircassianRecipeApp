package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.domain.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RecipesViewModel :
    BaseViewModel<RecipesContract.Event, RecipesContract.State, RecipesContract.Effect>() {

    /**
     * Create initial State of Views
     */
    override fun createInitialState(): RecipesContract.State {
        return RecipesContract.State(
            RecipesContract.RandomNumberState.Idle,
        )
    }

    /**
     * Handle each event
     */
    override fun handleEvent(event: RecipesContract.Event) {
        when (event) {
            is RecipesContract.Event.OnRecipesCardClicked -> {
                generateRandomNumber() //TODO get Recipe list + Get Card from list
            }

            is RecipesContract.Event.OnCarouselsCardClicked -> {
                setEffect { RecipesContract.Effect.ShowToast } //TODO get Recipe Card from Carousel
            }
        }
    }

    /**
     * Generate a random number
     */
    private fun generateRandomNumber() {
        viewModelScope.launch {
            // Set Loading
            setState { copy(randomNumberState = RecipesContract.RandomNumberState.Loading) }
            try {
                delay(5000)
                val random = (0..10).random()
                if (random % 2 == 0) {
                    setState { copy(randomNumberState = RecipesContract.RandomNumberState.Idle) }
                    throw RuntimeException("Number is even")
                }
                setState { copy(randomNumberState = RecipesContract.RandomNumberState.Success(number = random)) }
            } catch (exception: Exception) {
                setEffect { RecipesContract.Effect.ShowToast }
            }
        }
    }
}