package com.br.alpunto.model.tips

data class Pagination(
    val page: Int,
    val pageCount: Int,
    val pageSize: Int,
    val total: Int
)