package com.fsryan.example.weatherapp.domain.datasource

import com.fsryan.example.weatherapp.data.db.ForecastDb
import com.fsryan.example.weatherapp.data.server.ForecastServer
import com.fsryan.example.weatherapp.domain.model.ForecastList
import com.fsryan.example.weatherapp.extensions.firstResult

class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {

    companion object {
        val DAY_IN_MILLIS = 24 * 60 * 60 * 1000
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = sources.firstResult { requestSource(it, days, zipCode) }

    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}