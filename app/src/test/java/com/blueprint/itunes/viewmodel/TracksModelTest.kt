package com.blueprint.itunes.viewmodel

import com.blueprint.itunes.datasource.api.RestTrack
import org.junit.Test

import org.junit.Assert.*
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.koin.core.context.GlobalContext.get
import org.mockito.Mock


class TracksModelTest {


    @Mock
    var restTrack : RestTrack? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun getTracks() {

        val model = restTrack?.let { TracksModel(it) }

        assert(model!!.getTracks().value?.size == 0)

    }
}