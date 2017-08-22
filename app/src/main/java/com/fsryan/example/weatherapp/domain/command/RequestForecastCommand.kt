package com.fsryan.example.weatherapp.domain.command

import com.fsryan.example.weatherapp.data.server.ForecastByZipCodeRequest
import com.fsryan.example.weatherapp.domain.datasource.ForecastProvider
import com.fsryan.example.weatherapp.domain.mappers.ForecastDataMapper
import com.fsryan.example.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}