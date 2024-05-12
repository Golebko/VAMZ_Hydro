package com.example.vamzhydro.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {

    @Query("SELECT * from records ORDER BY date ASC")
    fun getAllRecords(): Flow<List<Record>>

    @Query("SELECT * from records WHERE id = :id")
    fun getRecord(id: Int): Flow<Record>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Record)

    @Update
    suspend fun update(item: Record)

    @Delete
    suspend fun delete(item: Record)
}