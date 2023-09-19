package com.example.kmpInterview.model

import com.example.apolloJsLockup.graphql.rocketreserver.LaunchListQuery

data class Mission(
    val name: String?,
    val missionPatch: String?,
)

internal fun LaunchListQuery.Mission.toMission() = Mission(
    name = this.name,
    missionPatch = this.missionPatch,
)