package com.fsryan.example.weatherapp.domain.command

import com.fsryan.example.weatherapp.data.ForecastRequest
import com.fsryan.example.weatherapp.domain.mappers.ForecastDataMapper
import com.fsryan.example.weatherapp.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute() = ForecastDataMapper().convertFromDataModel(ForecastRequest(zipCode).execute())
}