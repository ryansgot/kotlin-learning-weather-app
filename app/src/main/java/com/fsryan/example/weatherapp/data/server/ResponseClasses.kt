package com.fsryan.example.weatherapp.data.server

// The names of the fields must be the same as the names of the fields in the json
/*
{
	"city": {
		"id": 5375480,
		"name": "Mountain View",
		"coord": {
			"lon": -122.0839,
			"lat": 37.3861
		},
		"country": "US",
		"population": 0
	},
	"cod": "200",
	"message": 14.2964771,
	"cnt": 7,
	"list": [{
		"dt": 1502913600,
		"temp": {
			"day": 20.79,
			"min": 9.76,
			"max": 20.79,
			"night": 9.76,
			"eve": 16.43,
			"morn": 20.79
		},
		"pressure": 989.32,
		"humidity": 68,
		"weather": [{
			"id": 800,
			"main": "Clear",
			"description": "sky is clear",
			"icon": "01n"
		}],
		"speed": 1.51,
		"deg": 213,
		"clouds": 0
	}, {
		"dt": 1503000000,
		"temp": {
			"day": 25.51,
			"min": 12.42,
			"max": 25.51,
			"night": 12.42,
			"eve": 20.55,
			"morn": 13.59
		},
		"pressure": 991.31,
		"humidity": 68,
		"weather": [{
			"id": 800,
			"main": "Clear",
			"description": "sky is clear",
			"icon": "01d"
		}],
		"speed": 1.51,
		"deg": 251,
		"clouds": 0
	}, {
		"dt": 1503086400,
		"temp": {
			"day": 26.92,
			"min": 13.64,
			"max": 26.92,
			"night": 13.64,
			"eve": 21.61,
			"morn": 14.62
		},
		"pressure": 989.84,
		"humidity": 67,
		"weather": [{
			"id": 800,
			"main": "Clear",
			"description": "sky is clear",
			"icon": "01d"
		}],
		"speed": 1.41,
		"deg": 262,
		"clouds": 0
	}, {
		"dt": 1503172800,
		"temp": {
			"day": 19.75,
			"min": 12.71,
			"max": 22.01,
			"night": 15.25,
			"eve": 22.01,
			"morn": 12.71
		},
		"pressure": 1007.96,
		"humidity": 0,
		"weather": [{
			"id": 800,
			"main": "Clear",
			"description": "sky is clear",
			"icon": "01d"
		}],
		"speed": 1.46,
		"deg": 201,
		"clouds": 2
	}, {
		"dt": 1503259200,
		"temp": {
			"day": 18.45,
			"min": 12.78,
			"max": 21.03,
			"night": 14.6,
			"eve": 21.03,
			"morn": 12.78
		},
		"pressure": 1005.17,
		"humidity": 0,
		"weather": [{
			"id": 500,
			"main": "Rain",
			"description": "light rain",
			"icon": "10d"
		}],
		"speed": 1.29,
		"deg": 197,
		"clouds": 4
	}, {
		"dt": 1503345600,
		"temp": {
			"day": 18.23,
			"min": 12.28,
			"max": 20.89,
			"night": 14.52,
			"eve": 20.89,
			"morn": 12.28
		},
		"pressure": 1005.14,
		"humidity": 0,
		"weather": [{
			"id": 500,
			"main": "Rain",
			"description": "light rain",
			"icon": "10d"
		}],
		"speed": 1.57,
		"deg": 184,
		"clouds": 6
	}, {
		"dt": 1503432000,
		"temp": {
			"day": 17.8,
			"min": 12.87,
			"max": 20.65,
			"night": 14.67,
			"eve": 20.65,
			"morn": 12.87
		},
		"pressure": 1009.55,
		"humidity": 0,
		"weather": [{
			"id": 500,
			"main": "Rain",
			"description": "light rain",
			"icon": "10d"
		}],
		"speed": 1.45,
		"deg": 196,
		"clouds": 19
	}]
}
 */

data class ForecastResult(val city: City, val list: List<Forecast>)

data class City(val id: Long, val name: String, val coord: Coordinates, val country: String, val population: Int)

data class Coordinates(val long: Float, val lat: Float)

data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int, val weather: List<Weather>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String, val icon: String)