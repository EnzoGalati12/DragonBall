package com.example.dragonballgs.presentation.all

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.usecase.GetAllDragonBallUseCase
import com.example.dragonballgs.domain.usecase.GetHistoryDragonBallUseCase
import kotlinx.coroutines.launch


class DragonBallAllViewModel(
    private val getAllDragonBallUseCase: GetAllDragonBallUseCase
) : ViewModel() {

    private val _dragonAll = MutableLiveData<List<DragonBall>>()
    val dragonAllHistory: LiveData<List<DragonBall>> get() = _dragonAll

    fun getAll() {
        viewModelScope.launch {
            val result = getAllDragonBallUseCase()
            _dragonAll.value = result
        }
    }
}
