package com.voicebunny.api

class VoiceBunnyException extends RuntimeException {
    
    def final code

    def final message

    VoiceBunnyException(int code, String message) {
        super(code + ' ' + message)
        this.code = code
        this.message = message
    }

    def String getMessage() {
        return message.toString()
    }

}