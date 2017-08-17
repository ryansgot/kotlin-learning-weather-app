package com.fsryan.example.weatherapp.domain.command

interface Command<out T> {
    fun execute() : T
}