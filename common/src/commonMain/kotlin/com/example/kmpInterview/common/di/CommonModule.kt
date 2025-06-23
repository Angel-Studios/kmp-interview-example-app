package com.example.kmpInterview.common.di

import com.apollographql.apollo.ApolloClient
import com.example.kmpInterview.common.api.RocketReserverApi
import com.example.kmpInterview.common.api.RocketReserverApiImpl
import org.koin.dsl.module

val commonModule = module {
    single<RocketReserverApi> {
        RocketReserverApiImpl(
            apolloClient = get()
        )
    }

    single<ApolloClient> {
        ApolloClient.Builder()
            .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
            .build()
    }
}