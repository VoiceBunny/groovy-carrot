/* Author::    Carlos Rodríguez (mailto:carlos.rodriguez@voicebunny.com)
** Copyright:: Copyright (c) 2008 Torrenegra IP, LLC.
** License::   Distributed under Creative Commons CC-BY license http://creativecommons.org/licenses/by/3.0/

** This class handle the connection to the VoiceBunny API
*/

package com.voicebunny.api

import groovyx.net.http.*
import groovy.json.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import static groovyx.net.http.ContentType.*

class VoiceBunny {

    def slurper = new JsonSlurper()
    
    def userId
    
    def token
    
    def http

    VoiceBunny(userId, token, host) {
        this.userId = userId
        this.token = token
        http = new HTTPBuilder(host)
        http.handler.success = success
        http.handler.failure = failure
        http.auth.basic userId, token
    }

    def success = {response, json ->
        def parsed = slurper.parseText(json.toString())
        return parsed
    }
    
    def failure = {response, json ->
        def parsed = slurper.parseText(json.toString())
        def error = parsed.error
        throw new VoiceBunnyException(error.code, error.message)
    }

    def getProjects() {
        return http.get(path: 'projects/', requestContentType: URLENC)
    }

    def getProject(projectId) {
        return http.get(path: 'projects/' + projectId, requestContentType: URLENC)
    }

    def postProject(projectData) {
        return http.post(path: 'projects/add', body: projectData, requestContentType: URLENC)
    }

    def disposeProject(projectId) {
        return http.post(path: 'projects/forceDispose/' + projectId, requestContentType: URLENC)
    }

    def quoteProject(data) {
        return http.post(path: 'projects/quote', body: data, requestContentType: URLENC)
    }

    def getRead(readId) {
        return http.get(path: 'reads/' + readId, requestContentType: URLENC)
    }

    def approveRead(readId) {
        return http.post(path: 'reads/approve/' + readId, requestContentType: URLENC)
    }

    def addRevision(readId, data){
        return http.post(path: 'reads/' + readId + '/revision/add', body: data, requestContentType: URLENC)
    }

    def quoteRevision(readId, data){
        return http.post(path: 'reads/' + readId + '/revision/quote', body: data, requestContentType: URLENC)
    }

    def rejectRead(readId, data) {
        return http.post(path: 'reads/reject/' + readId, body: data, requestContentType: URLENC)
    }

    def getLanguages() {
        return http.get(path: 'languages/', requestContentType: URLENC)
    }

    def getGenderAndAges() {
        return http.get(path: 'genderAndAges/', requestContentType: URLENC)
    }

    def getBalance() {
        return http.get(path: 'balance/', requestContentType: URLENC)
    }

}
