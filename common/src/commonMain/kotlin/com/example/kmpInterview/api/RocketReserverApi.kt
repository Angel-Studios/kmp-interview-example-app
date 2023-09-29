package com.example.kmpInterview.api

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.kmpInterview.graphql.rocketreserver.LaunchListQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface RocketReserverApi {
    fun getLaunches(): Flow<Unit>
}

internal class RocketReserverApiImpl(
    private val apolloClient: ApolloClient
) : RocketReserverApi {
    override fun getLaunches() =
        apolloClient.query(LaunchListQuery(Optional.Present(null)))
            .toFlow()
            .map { response -> }
}