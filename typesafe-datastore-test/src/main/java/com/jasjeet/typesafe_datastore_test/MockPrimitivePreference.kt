package com.jasjeet.typesafe_datastore_test

import com.jasjeet.typesafe_datastore.preferences.PrimitivePreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> MockPrimitivePreference(mockValue: T, success: Boolean = true): PrimitivePreference<T> =
    object : PrimitivePreference<T> {
        override suspend fun get(): T = mockValue
        
        override fun getFlow(): Flow<T> = flow { emit(mockValue) }
        
        override suspend fun getAndUpdate(update: (T) -> T) =
            if (success) Result.success(Unit) else Result.failure(Exception())
        
        override suspend fun set(value: T): Result<Unit> =
            if (success) Result.success(Unit) else Result.failure(Exception())
    }