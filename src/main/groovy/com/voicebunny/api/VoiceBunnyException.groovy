package com.voicebunny.api

class VoiceBunnyException extends RuntimeException {
	
	def final code

	def final message

	VoiceBunnyException(code, message) {
		super(code + ' ' + message)
		this.code = code
		this.message = message
	}
}