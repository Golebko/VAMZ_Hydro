package com.example.vamzhydro.data

import kotlinx.coroutines.flow.Flow

class OfflineRecordsRepository(private val recordDao: RecordDao) : RecordsRepository {
    override fun getAllRecordsStream(): Flow<List<RecordItem>> = recordDao.getNewerToOlderRecords()

    override fun getRecordStream(id: Int): Flow<RecordItem?> = recordDao.getRecord(id)

    override suspend fun insertRecord(item: RecordItem) = recordDao.insert(item)

    override suspend fun deleteRecord(item: RecordItem) = recordDao.delete(item)

    override suspend fun updateRecord(item: RecordItem) = recordDao.update(item)
}