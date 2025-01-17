package com.example.dragonballgs.data.repository

import com.example.dragonballgs.data.local.dao.DragonBallDao
import com.example.dragonballgs.data.remote.api.DragonBallService
import com.example.dragonballgs.domain.model.DragonBall
import com.example.dragonballgs.domain.repository.DragonBallRepository

class DragonBallRepositoryImpl(
    private val dragonBallDao: DragonBallDao,
    private val dragonBallService: DragonBallService
) : DragonBallRepository {

    override suspend fun getDragonBall(dragonBall: Long): DragonBall {
        val cachedDragonBall = dragonBallDao.getDragonBall(dragonBall)
        return if (cachedDragonBall != null) {
            cachedDragonBall.toDragonBall()
        } else {
            val response = dragonBallService.getDragonBall(dragonBall)
            dragonBallDao.insertDragonBall(response.toDragonBallEntity())
            response.toDragonBall()
        }
    }
/*
    override suspend fun getAllDragonBall(): List<DragonBall> {
        return try {
            val apiResponse = dragonBallService.getAllDragonBallsFromApi()
            apiResponse.forEach { dragonBallResponse ->
                dragonBallDao.insertDragonBall(dragonBallResponse.toDragonBallEntity())
            }
            dragonBallDao.getAllDragonBalls().map { it.toDragonBall() }
        } catch (e: Exception) {
            dragonBallDao.getAllDragonBalls().map { it.toDragonBall() }
        }
    }
*/
    override suspend fun getHistoryDragonBall(): List<DragonBall> {
        return dragonBallDao.getHistoryDragonBall().map { it.toDragonBall() }
    }

    override suspend fun deleteItemHistory(dragonBall: Long) {
        val cachedDragonBall = dragonBallDao.getDragonBall(dragonBall)
        cachedDragonBall?.let {
            dragonBallDao.delete(it)
        }
    }

    override suspend fun deleteAllHistory() {
        dragonBallDao.deleteAll()
    }
}
