package com.example.myapplication.shared.cache

import comexamplemyapplicationsharedcache.Launch

/**
 * This class wraps the AppDatabase class and contain caching logic.
 *
 * This class's visibility is set to internal, which means it is only accessible from within the multiplatform module.
 */
internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun getAllLaunches(flightNumber: Int): List<Launch> {
        return dbQuery.getAllLaunches(flightNumber = flightNumber.toLong()).executeAsList()
    }

}