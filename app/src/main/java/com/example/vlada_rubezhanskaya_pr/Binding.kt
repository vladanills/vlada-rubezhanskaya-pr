package com.example.vlada_rubezhanskaya_pr

import android.content.Context

// Метод не используется, можно удалять
fun getRequestMaker(context: Context): RequestMaker = OkHttpRequestMaker(context)