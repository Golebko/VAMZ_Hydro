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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(record: RecordItem)

    @Update
    suspend fun update(record: RecordItem)

    @Delete
    suspend fun delete(record: RecordItem)

    @Query("SELECT * from records ORDER BY date DESC")
    fun getNewerToOlderRecords(): Flow<List<RecordItem>>

    @Query("SELECT * from records WHERE id = :id")
    fun getRecord(id: Int): Flow<RecordItem>

}