package me.brunosantana.repository

import com.sun.nio.sctp.IllegalUnbindException
import java.nio.charset.MalformedInputException
import java.util.IllegalFormatException

class UserRepository {

    fun saveUser(){
        try {
            save()
        }catch (e: IllegalCallerException){
            throw IllegalStateException("other message", e)
        }
    }

    private fun save(){
        try{
            throw IllegalArgumentException("save failed")
        }catch (e: IllegalArgumentException){
            throw IllegalCallerException("another message", e)
        }
    }

}