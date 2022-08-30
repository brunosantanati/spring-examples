package me.brunosantana.repository

class UserRepository {

    fun saveUser(){
        try {
            save()
        }catch (e: IllegalArgumentException){
            throw IllegalStateException("other message", e)
        }
    }

    private fun save(){
        throw IllegalArgumentException("save failed")
    }

}