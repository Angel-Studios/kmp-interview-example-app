package com.example.kmpInterview.api

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.apolloJsLockup.graphql.rocketreserver.LaunchListQuery
import com.example.kmpInterview.model.Launch
import com.example.kmpInterview.model.mapToLaunch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface RocketReserverApi {
    fun getLaunches(): Flow<List<Launch>>
}

internal class RocketReserverApiImpl(
    private val apolloClient: ApolloClient
) : RocketReserverApi {
    override fun getLaunches() =
        apolloClient.query(LaunchListQuery(Optional.Present(null)))
            .toFlow()
            .map { response ->
                response.data?.launches?.launches?.filterNotNull()?.map { it.mapToLaunch() }.orEmpty()
            }
}