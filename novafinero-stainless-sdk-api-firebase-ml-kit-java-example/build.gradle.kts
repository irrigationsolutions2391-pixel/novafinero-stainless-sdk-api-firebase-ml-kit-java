plugins {
    id("novafinero-stainless-sdk-api-firebase-ml-kit.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":novafinero-stainless-sdk-api-firebase-ml-kit-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :novafinero-stainless-sdk-api-firebase-ml-kit-java-example:run` to run `Main`
    // Use `./gradlew :novafinero-stainless-sdk-api-firebase-ml-kit-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.novafinero_stainless_sdk_api_firebase_ml_kit.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
