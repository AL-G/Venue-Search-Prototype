
# Venue-Search-Prototype

A prototype app that uses the user location to display nearby coffee retailers. Uses latitude and longitude data with the Foursquare places API.

https://developer.foursquare.com/docs/api-reference/venues/explore/

<h3>Api Credentials</h3>

<p>Replace the YOUR_CLIENT_ID and YOUR_CLIENT_SECRET values with your own in the module build.gradle</p>

<p>
<code>
buildConfigField "String", "CLIENT_ID", "\"YOUR_CLIENT_ID\""
</code>
</br>
<code>
buildConfigField "String", "CLIENT_SECRET", "\"YOUR_CLIENT_SECRET\""
</code>
</p>

<h3>Overview</h3>

Kotlin + MVVM + Clean Architecture + Koin + Retrofit2 + Coroutines + Mockito

![CleanArchitecture](https://user-images.githubusercontent.com/15722971/109943441-1eb12d80-7ccd-11eb-9e41-c94689473c80.png)
