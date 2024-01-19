package com.example.consumirapis.data.remote

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)