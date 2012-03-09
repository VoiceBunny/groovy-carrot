# Groovy Carrot - VoiceBunny Library

[Groovy Carrot](https://github.com/Voice123/groovy-carrot) is a Groovy library that provides connection to the [VoiceBunny.com](http://voicebunny.com) HTTP RESTful API, using [HTTP Builder](http://groovy.codehaus.org/HTTP+Builder) for the HTTP request/response cycle.
If you need more information on how to use our library check the [installation guide](https://github.com/Voice123/groovy-carrot/wiki/installation) or the [tutorial](https://github.com/Voice123/groovy-carrot/wiki/Use-tutorial).

### Usage

```groovy
// Imports
import com.voicebunny.api.*

// Initialize the library
def vb = new VoiceBunny('userId', 'token', 'https://api.voicebunny.com')

// Get information
def response = vb.languages
println response.languages

// Post project
def projectData = [
    script: "Test project",
    specialInstructions: "Posted from Groovy-Carrot",
    title: "Test Project"
]
response = vb.postProject projectData
println response.project

// Get a project
response = vb.getProject(response.project.id)
println response.projects
```

### Request a VoiceBunny API Key
To use this library you need to request an API Key in the [VoiceBunny.com Developer's Section](http://voicebunny.com/developers/token).

### Don't you like Groovy?
If you're not confortable with the Groovy language, you can also check our other libraries:

* [Python Carrot](https://github.com/Voice123/python-carrot)
* [Ruby Carrot](https://github.com/Voice123/ruby-carrot)

Or why not, build your own library from scratch checking the [API documentation](http://voicebunny.com/developers/index).

### Copyright

Copyright (c) 2008 Torrenegra IP, LLC. Distributed under Creative Commons [CC-BY license](http://creativecommons.org/licenses/by/3.0/).