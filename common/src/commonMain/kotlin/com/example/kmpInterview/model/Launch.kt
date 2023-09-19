package com.example.kmpInterview.model

import com.example.apolloJsLockup.graphql.rocketreserver.LaunchListQuery

data class Launch(
    val id: Int, // TODO change this field to be the rocket name instead
    val site: String?,
    val mission: Mission?,
)

internal fun LaunchListQuery.Launch.toLaunch() = Launch(
    id = this.id.toInt(),
    site = this.site,
    mission = this.mission?.toMission(),
)