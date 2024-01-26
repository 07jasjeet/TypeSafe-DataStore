package com.jasjeet.type_safedatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.jasjeet.type_safedatastore.DataStoreSerializers.stringListSerializer
import com.jasjeet.typesafe_datastore.TypeSafeDataStore
import com.jasjeet.typesafe_datastore.preferences.ComplexPreference
import com.jasjeet.typesafe_datastore_gson.AutoTypedDataStore

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

class MyPreferences(context: Context): TypeSafeDataStore(context.dataStore) {
    companion object {
        val key = stringPreferencesKey("key")
    }
    
    val preference: ComplexPreference<List<String>>
        get() = createComplexPreference(key, stringListSerializer)
    
}

class MyAutoTypedPreferences(context: Context): AutoTypedDataStore(context.dataStore) {
    companion object {
        val key = stringPreferencesKey("key")
    }
    
    val listPreference: ComplexPreference<List<String>>
        get() = createListPreference(key)
    
}