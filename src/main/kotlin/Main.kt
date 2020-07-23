package edu.erittenhouse

import kotlinx.coroutines.*
import java.io.IOException

suspend fun main() {
    println("Let's do the census!")
    try {
        doCensus()
    } catch (e: IOException) {
        println("Caught the IO exception!")
    }
    println("All done!")
}

suspend fun doCensus() = withContext(Dispatchers.Default) {
    val allStateInitials = fetchStates()
    coroutineScope {
        for (stateInitials in allStateInitials) {
            launch { fetchCountyPopulationsByState(stateInitials) }
        }
    }
    println("Done fetching states!")
}

suspend fun fetchCountyPopulationsByState(stateInitials: String) {
    val countiesInState = fetchCountiesForState(stateInitials)
    coroutineScope {
        for (county in countiesInState) {
            launch { countyPopulation(county, stateInitials) }
        }
    }
    println("Done fetching populations for $stateInitials!")
}

suspend fun countyPopulation(countyName: String, stateInitials: String) {
    val population = doVolatilePopulationRequest()
    println("Population for $countyName county, $stateInitials is: $population!")
}