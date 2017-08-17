package com.fsryan.example.weatherapp.domain.mappers

import com.fsryan.example.weatherapp.data.ForecastResult
import com.fsryan.example.weatherapp.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit

import com.fsryan.example.weatherapp.data.Forecast
import java.text.DateFormat

import com.fsryan.example.weatherapp.domain.model.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult) = ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>) = list.mapIndexed { i, forecast ->
        val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
        convertForecastItemToDomain(forecast.copy(dt = dt))
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = ModelForecast(
            convertDate(forecast.dt),
            forecast.weather[0].description,
            forecast.temp.max.toInt(),
            forecast.temp.min.toInt(),
            generateIconUrl(forecast.weather[0].icon)
    )

    private fun convertDate(date: Long) = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault()).format(date)

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}