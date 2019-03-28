package com.example.vlada_rubezhanskaya_pr

import android.content.Context

fun getrequestMaker(context: Context): RequestMaker = OkHttpRequestMaker(context)