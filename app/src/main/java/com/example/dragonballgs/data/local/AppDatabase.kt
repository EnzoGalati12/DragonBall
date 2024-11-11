package com.example.dragonballgs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dragonballgs.data.local.dao.DragonBallDao
import com.example.dragonballgs.data.local.entity.DragonBallEntity

@Database(entities = [DragonBallEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dragonBallDao(): DragonBallDao
}