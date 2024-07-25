package com.abhishek.openinapp.domian.core

import com.abhishek.openinapp.data.network.FetchStatus

data class Result<T>(val status : FetchStatus, val data: T?)
