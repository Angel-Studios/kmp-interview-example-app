package com.example.kmpInterview.di

import com.apollographql.apollo3.ApolloClient
import com.example.kmpInterview.api.RocketReserverApi
import com.example.kmpInterview.api.RocketReserverApiImpl
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