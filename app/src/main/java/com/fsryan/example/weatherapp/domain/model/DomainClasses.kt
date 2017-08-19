package com.fsryan.example.weatherapp.domain.model

data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    fun size() = dailyForecast.size
    operator fun get(position: Int) = dailyForecast[position]
}
data class Forecast(val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)