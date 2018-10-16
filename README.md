### Udacity Android Developer Nanodegree Program
#### 5th Project
# BuildItBigger App

### Project Overview
In this project, you will create an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app will consist of four modules:

A Java library that provides jokes
A Google Cloud Endpoints (GCE) project that serves those jokes
An Android Library containing an activity for displaying jokes
An Android app that fetches jokes from the GCE module and passes them to the Android Library for display
Why this Project?
As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity.

What Will I Learn?
You will learn the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity. You'll learn to:

Add free and paid flavors to an app, and set up your build to share code between them
Factor reusable functionality into a Java library
Factor reusable Android functionality into an Android library
Configure a multi-project build to compile your libraries and app
Use the Gradle App Engine plugin to deploy a backend
Configure an integration test suite that runs against the local App Engine development server

### Screenshot
<img src="https://github.com/simonoppowa/BuildItBiggerApp/blob/master/screens/screenshot1.png?raw=true" alt="alt text" width="400"> &nbsp;&nbsp; <img src="https://github.com/simonoppowa/BuildItBiggerApp/blob/master/screens/screenshot2.png?raw=true" alt="alt text" width="400">

### Libraries used
* [Timber](https://github.com/JakeWharton/timber)
* [Butterknife](https://github.com/JakeWharton/butterknife)

### License
```
Copyright 2018 Simon Oppowa

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```