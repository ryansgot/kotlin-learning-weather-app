package com.fsryan.example.weatherapp.domain.command

import com.fsryan.example.weatherapp.data.server.ForecastRequest
import com.fsryan.example.weatherapp.domain.mappers.ForecastDataMapper
import com.fsryan.example.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {
    override fun execute() = ForecastDataMapper().convertFromDataModel(zipCode, ForecastRequest(zipCode).execute())
}