package com.example.dragonballgs.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dragonballgs.domain.model.DragonBall

@Entity(tableName = "dragon_table")
data class DragonBallEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val ki: String,
    val maxKi: String,
    val image: String,
    val affiliation: String

){
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

}
