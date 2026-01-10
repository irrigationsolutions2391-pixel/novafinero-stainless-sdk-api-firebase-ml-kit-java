# Jackson uses reflection and depends heavily on runtime attributes.
-keepattributes Exceptions,InnerClasses,Signature,Deprecated,*Annotation*

# Jackson uses Kotlin reflection utilities, which themselves use reflection to access things.
-keep class kotlin.reflect.** { *; }
-keep class kotlin.Metadata { *; }

# Jackson uses reflection to access enum members (e.g. via `java.lang.Class.getEnumConstants()`).
-keepclassmembers class com.fasterxml.jackson.** extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Jackson uses reflection to access annotation members.
-keepclassmembers @interface com.fasterxml.jackson.annotation.** {
    *;
}

# Jackson uses reified type information to serialize and deserialize our classes (via `TypeReference`).
-keep class com.fasterxml.jackson.core.type.TypeReference { *; }
-keep class * extends com.fasterxml.jackson.core.type.TypeReference { *; }

# Jackson uses reflection to access our class serializers and deserializers.
-keep @com.fasterxml.jackson.databind.annotation.JsonSerialize class com.novafinero_stainless_sdk_api_firebase_ml_kit.api.** { *; }
-keep @com.fasterxml.jackson.databind.annotation.JsonDeserialize class com.novafinero_stainless_sdk_api_firebase_ml_kit.api.** { *; }

# Jackson uses reflection to serialize and deserialize our classes based on their constructors and annotated members.
-keepclassmembers class com.novafinero_stainless_sdk_api_firebase_ml_kit.api.** {
    <init>(...);
    @com.fasterxml.jackson.annotation.* *;
}