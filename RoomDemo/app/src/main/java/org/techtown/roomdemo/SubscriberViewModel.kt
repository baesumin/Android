package org.techtown.roomdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techtown.roomdemo.db.Subscriber
import org.techtown.roomdemo.db.SubscriberRepository

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {
  val subscribers = repository.subscribers

  val inputName = MutableLiveData<String>()
  val inputEmail = MutableLiveData<String>()

  val saveOrUpdateButtonText = MutableLiveData<String>()
  val clearAllOrDeleteButtonText = MutableLiveData<String>()

  init {
    saveOrUpdateButtonText.value = "Save"
    clearAllOrDeleteButtonText.value = "Clear All"
  }

  fun saveOrUpdate() {
    val name = inputName.value!!
    val email = inputEmail.value!!
    insert(Subscriber(0,name,email))
    inputName.value = ""
    inputEmail.value = ""
  }

  fun clearAllOrDelete() {
    clearAll()
  }

  fun insert(subscriber: Subscriber) {
    viewModelScope.launch {
      repository.insert(subscriber)
    }
  }

  fun update(subscriber: Subscriber) {
    viewModelScope.launch {
      repository.update(subscriber)
    }
  }

  fun delete(subscriber: Subscriber) {
    viewModelScope.launch {
      repository.delete(subscriber)
    }
  }

  fun clearAll() {
    viewModelScope.launch {
      repository.deleteAll()
    }
  }
}