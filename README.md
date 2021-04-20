# MTLS issue in Quarkus

Steps to reproduce: 
* `./gradlew build`

* `docker build -f src/main/docker/Dockerfile.jvm -t quarkus/rest-kotlin-quickstart-jvm .`

* `docker run -i --rm -e QUARKUS_PROFILE=e0 -p 8443:8443 quarkus/rest-kotlin-quickstart-jvm`

* make a `GET` request with a client certificate (the truststore password is just '`password`', or you can make your own) to 
  https://localhost:8443/greeting
    * you should see "`Hello, `" (where you'd expect to see the certificate identity after the comma)

Then, you can remove `%issue` from the `quarkus.http.ssl.client-auth` property in `application.properties` and attempt again (don't forget to `./gradlew build` again), and you should see the 
identity show in the response. You can verify that the profile is loading by adding another `%issue` property (like
changing the truststore to an invalid directory to force an error)
