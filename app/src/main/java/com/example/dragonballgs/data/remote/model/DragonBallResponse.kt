package com.example.dragonballgs.data.remote.model

import com.example.dragonballgs.data.local.entity.DragonBallEntity
import com.example.dragonballgs.domain.model.DragonBall


data class DragonBallResponse(
    val id: Long,
    val name: String,
    val ki: String,
    val maxKi: String,
    val image: String,
    val affiliation: String
) {
    fun toDragonBall(): DragonBall {
        return DragonBall(
            id = id,
            name = name,
            ki = ki,
            maxKi = maxKi,
            image = image,
            affiliation = affiliation
        )
    }

    fun toDragonBallEntity(): DragonBallEntity {
        return DragonBallEntity(
            id = id,
            name = name,
            ki = ki,
            maxKi = maxKi,
            image = image,
            affiliation = affiliation
        )
    }

}