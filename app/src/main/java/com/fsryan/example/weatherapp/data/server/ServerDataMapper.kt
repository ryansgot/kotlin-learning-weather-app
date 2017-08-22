package com.fsryan.example.weatherapp.data.server

import com.fsryan.example.weatherapp.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit

import com.fsryan.example.weatherapp.domain.model.Forecast as ModelForecast

class ServerDataMapper {

    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed {i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(), generateUrlIcon(weather[0].icon))
    }

    private fun generateUrlIcon(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}