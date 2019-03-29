package com.example.vlada_rubezhanskaya_pr

import android.content.Context

fun getRequestMaker(context: Context): RequestMaker = OkHttpRequestMaker(context)