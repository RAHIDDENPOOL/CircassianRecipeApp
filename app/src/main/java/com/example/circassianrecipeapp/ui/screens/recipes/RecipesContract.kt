package com.example.circassianrecipeapp.ui.screens.recipes

import com.example.circassianrecipeapp.domain.state.UiEffect
import com.example.circassianrecipeapp.domain.state.UiEvent
import com.example.circassianrecipeapp.domain.state.UiState

class RecipesContract {

    sealed class Event : UiEvent {
        object OnRecipesCardClicked : Event()
        object OnCarouselsCardClicked : Event()

        // TODO object NavigateByTopAppBar : Event()
        // TODO object NavigateByBottomAppBar : Event()
    }

    data class State(
        val randomNumberState: RandomNumberState,
    ) : UiState

    sealed class RandomNumberState {
        object Idle : RandomNumberState()
        object Loading : RandomNumberState()
        data class Success(val number: Int) : RandomNumberState()
    }

    sealed class Effect : UiEffect {

        object ShowToast : Effect()
    }
}