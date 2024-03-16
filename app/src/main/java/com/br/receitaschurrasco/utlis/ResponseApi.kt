package com.br.alpunto.utlis

sealed class ResponseApi {
    class Success(var data: Any?) : ResponseApi()
    class Error(val message: Int) : ResponseApi()
}