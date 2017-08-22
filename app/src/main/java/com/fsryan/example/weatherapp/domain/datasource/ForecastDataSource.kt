package com.fsryan.example.weatherapp.domain.datasource

import com.fsryan.example.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}