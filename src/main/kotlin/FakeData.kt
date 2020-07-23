package edu.erittenhouse

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import java.io.IOException
import kotlin.random.Random

suspend fun doVolatilePopulationRequest(): Int {
    val randomChance = Random.nextInt(5)

    try {
        delay(Random.nextLong(from = 100, until = 5000))
    } catch (e: CancellationException) {
        println("Volatile request cancelled!")
        throw e
    }

    if (randomChance == 3) {
        throw IOException("Failed to send request!")
    } else {
        return Random.nextInt(1000)
    }
}

suspend fun fetchCountiesForState(state: String): List<String> {
    try {
        delay(Random.nextLong(from = 100, until = 900))
    } catch (e: CancellationException) {
        println("Cancelled county request for $state!")
        throw e
    }

    return when (state) {
        "AL" -> listOf("Autauga", "Baldwin", "Barbour", "Bibb", "Blount")
        "AK" -> listOf("Aleutians East Borough", "Anchorage Borough", "Bristol Bay Borough", "Denali Borough", "Fairbanks North Star Borough")
        "AZ" -> listOf("Apache", "Cochise", "Coconino", "Gila", "Graham")
        "AR" -> listOf("Arkansas", "Ashley", "Baxter", "Benton", "Boone")
        "CA" -> listOf("Alameda", "Alpine", "Amador", "Butte", "Calaveras")
        "CO" -> listOf("Adams", "Alamosa", "Arapahoe", "Archuleta", "Baca")
        "CT" -> listOf("Fairfield", "Hartford", "Litchfield", "Middlesex", "New Haven")
        "DE" -> listOf("Kent", "New Castle", "Sussex")
        "FL" -> listOf("Alachua", "Baker", "Bay", "Bradford", "Brevard")
        "GA" -> listOf("Appling", "Atkinson", "Bacon", "Baker", "Banks")
        "HI" -> listOf("Hawaii", "Honolulu", "Kalawao", "Kauai", "Maui")
        "ID" -> listOf("Ada", "Adams", "Bannock", "Bear Lake", "Benewah")
        "IL" -> listOf("Adams", "Alexander", "Bond", "Boone", "Brown")
        "IN" -> listOf("Adams", "Allen", "Bartholomew", "Benton", "Blackford")
        "IA" -> listOf("Adair", "Adams", "Allamakee", "Appanoose", "Audubon")
        "KS" -> listOf("Allen", "Anderson", "Atchison", "Barber", "Barton")
        "KY" -> listOf("Adair", "Allen", "Anderson", "Ballard", "Barren")
        "LA" -> listOf("Acadia Parish", "Allen Parish", "Ascension Parish", "Assumption Parish", "Avoyelles Parish")
        "ME" -> listOf("Androscoggin", "Aroostook", "Cumberland", "Franklin", "Hancock")
        "MD" -> listOf("Allegany", "Anne Arundel", "Baltimore", "Calvert", "Caroline")
        "MA" -> listOf("Barnstable", "Berkshire", "Bristol", "Dukes", "Essex")
        "MI" -> listOf("Alcona", "Alger", "Allegan", "Alpena", "Antrim")
        "MN" -> listOf("Aitkin", "Anoka", "Becker", "Beltrami", "Benton")
        "MS" -> listOf("Adams", "Alcorn", "Amite", "Attala", "Benton")
        "MO" -> listOf("Adair", "Andrew", "Atchison", "Audrain", "Barry")
        "MT" -> listOf("Beaverhead", "Big Horn", "Blaine", "Broadwater", "Carbon")
        "NE" -> listOf("Adams", "Antelope", "Arthur", "Banner", "Blaine")
        "NV" -> listOf("Carson City", "Churchill", "Clark", "Douglas", "Eiko")
        "NH" -> listOf("Belknap", "Carroll", "Cheshire", "Coos", "Grafton")
        "NJ" -> listOf("Atlantic", "Bergen", "Burlington", "Camden", "Cape May")
        "NM" -> listOf("Bernalillo", "Catron", "Chaves", "Cibola", "Colfax")
        "NY" -> listOf("Albany", "Allegany", "Bronx", "Broome", "Cattaraugus")
        "NC" -> listOf("Alamance", "Alexander", "Alleghany", "Anson", "Ashe")
        "ND" -> listOf("Adams", "Barnes", "Benson", "Billings", "Bottineau")
        "OH" -> listOf("Adams", "Allen", "Ashland", "Ashtabula", "Athens", "Auglaize")
        "OK" -> listOf("Adair", "Alfalfa", "Atoka", "Beaver", "Beckham")
        "OR" -> listOf("Baker", "Benton", "Clackamas", "Clatsop", "Columbia")
        "PA" -> listOf("Adams", "Allegheny", "Armstrong", "Beaver", "Bedford")
        "RI" -> listOf("Bristol", "Kent", "Newport", "Providence", "Washington")
        "SC" -> listOf("Abbeville", "Aiken", "Allendale", "Anderson", "Bamberg")
        "SD" -> listOf("Aurora", "Beadle", "Bennett", "Bon Homme", "Brookings")
        "TN" -> listOf("Anderson", "Bedford", "Benton", "Bledsoe", "Blount")
        "TX" -> listOf("Anderson", "Andrews", "Angelina", "Aransas", "Archer")
        "UT" -> listOf("Beaver", "Box Elder", "Cache", "Carbon", "Daggett")
        "VT" -> listOf("Addison", "Bennington", "Caledonia", "Chittenden", "Essex")
        "VA" -> listOf("Accomack", "Albemarle", "Alleghany", "Amelia", "Amherst")
        "WA" -> listOf("Adams", "Asotin", "Benton", "Chelan", "Clallam")
        "WV" -> listOf("Barbour", "Berkeley", "Boone", "Braxton", "Brooke")
        "WI" -> listOf("Adams", "Ashland", "Barron", "Bayfield", "Brown")
        "WY" -> listOf("Albany", "Big Horn", "Campbell", "Carbon", "Converse")
        else -> emptyList()
    }
}

suspend fun fetchStates(): List<String> {
    delay(Random.nextLong(from = 500, until = 1500))
    return listOf("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY")
}