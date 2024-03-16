package com.br.receitaschurrasco.extensions

fun String.formatBulletPoints(): String {
    return this.replace(" • ", "\n• ")
}