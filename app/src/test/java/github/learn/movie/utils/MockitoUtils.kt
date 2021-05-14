package github.learn.movie.utils

import org.mockito.Mockito

inline fun <reified T> mock() = Mockito.mock(T::class.java)