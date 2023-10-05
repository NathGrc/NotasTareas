package com.nath.notas_tareas.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * This data class defines a Mars photo which includes an ID, and the image URL.
 */

@Serializable
data class NotaTarea(

    @SerialName("id") val id: Int,
    @SerialName("titulo") val titulo: String,
    @SerialName("contenido") val contenido: String,
    @SerialName("estatus") val estatus: Int,
    @SerialName("tipo") val tipo: Int,
    @SerialName("fecha") val fecha: String,
    @SerialName("fechaModi") val fechaModi: String,
    @SerialName("fechaCum") val fechaCum: String
)

