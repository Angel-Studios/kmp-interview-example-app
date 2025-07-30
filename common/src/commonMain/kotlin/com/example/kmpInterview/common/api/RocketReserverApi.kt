package com.example.kmpInterview.common.api

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import com.example.kmpInterview.graphql.rocketreserver.LaunchListQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface RocketReserverApi {
    fun getLaunches(): Flow<Unit> // TODO replace `Unit` with actual data type
}

internal class RocketReserverApiImpl(
    private val apolloClient: ApolloClient
) : RocketReserverApi {
    override fun getLaunches() =
        apolloClient.query(LaunchListQuery(Optional.Present(null)))
            .toFlow()
            .map { response ->
                // TODO capture data from the API to bind to the UI
            }
}
