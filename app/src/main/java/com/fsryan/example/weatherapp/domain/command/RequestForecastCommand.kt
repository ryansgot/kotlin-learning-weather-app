package com.fsryan.example.weatherapp.domain.command

import com.fsryan.example.weatherapp.data.ForecastRequest
import com.fsryan.example.weatherapp.domain.mappers.ForecastDataMapper
import com.fsryan.example.weatherapp.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}