package com.example.vamzhydro.data

import kotlinx.coroutines.flow.Flow


interface RecordsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllRecordsStream(): Flow<List<RecordItem>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getRecordStream(id: Int): Flow<RecordItem?>

    /**
     * Insert item in the data source
     */
    suspend fun insertRecord(item: RecordItem)

    /**
     * Delete item from the data source
     */
    suspend fun deleteRecord(item: RecordItem)

    /**
     * Update item in the data source
     */
    suspend fun updateRecord(item: RecordItem)
}