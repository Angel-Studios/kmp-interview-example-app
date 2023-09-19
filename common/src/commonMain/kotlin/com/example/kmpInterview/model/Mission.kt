package com.example.kmpInterview.model

import com.example.kmpInterview.graphql.rocketreserver.LaunchListQuery

data class Mission(
    val name: String?,
    val missionPatch: String?,
)

internal fun LaunchListQuery.Mission.mapToMission() = Mission(
    name = this.name,
    missionPatch = this.missionPatch,
)