package com.example.vlada_rubezhanskaya_pr.di

import android.content.Context
import com.example.vlada_rubezhanskaya_pr.request.OkHttpRequestMaker
import com.example.vlada_rubezhanskaya_pr.request.RequestMaker

// Метод не используется, можно удалять
fun getRequestMaker(context: Context): RequestMaker =
    OkHttpRequestMaker(context)