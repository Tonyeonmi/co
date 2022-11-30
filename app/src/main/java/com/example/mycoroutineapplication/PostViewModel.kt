package com.example.mycoroutineapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _numPosts = MutableLiveData<Int>(0)
    val numPosts : LiveData<Int> get() = _numPosts

    fun retrievePosts() {
        viewModelScope.launch {
            val posts = repository.readPosts()
            _numPosts.value = posts?.length() ?: 0
        }  //launch와 withcontext가 어떤 개념인지 1. 기다리지않고 2. 컨테스트 하에서 일이 다 끝날때까지 반환되지 않는것
    }
}
