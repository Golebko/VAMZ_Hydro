package com.example.vamzhydro.data

import android.content.Context

interface Container {
    val recordsRepository: RecordsRepository
}

class DataContainer(private val context: Context) : Container {

    override val recordsRepository: RecordsRepository by lazy {
        OfflineRecordsRepository(HydroDatabase.getDatabase(context).recordDao())
    }
}