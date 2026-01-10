# Specify the entrypoint where ProGuard starts to determine what's reachable.
-keep class com.novafinero_stainless_sdk_api_firebase_ml_kit.api.proguard.** { *; }

# For the testing framework.
-keep class org.junit.** { *; }

# Many warnings don't apply for our testing purposes.
-dontnote
-dontwarn