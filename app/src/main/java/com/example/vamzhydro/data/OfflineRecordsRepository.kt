package com.example.vamzhydro.data

import kotlinx.coroutines.flow.Flow

class OfflineRecordsRepository(private val recordDao: RecordDao) : RecordsRepository {
    override fun getAllRecordsStream(): Flow<List<Record>> = recordDao.getAllRecords()

    override fun getRecordStream(id: Int): Flow<Record?> = recordDao.getRecord(id)

    override suspend fun insertRecord(item: Record) = recordDao.insert(item)

    override suspend fun deleteRecord(item: Record) = recordDao.delete(item)

    override suspend fun updateRecord(item: Record) = recordDao.update(item)
}