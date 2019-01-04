# Jackson
-dontwarn com.fasterxml.jackson.databind.**
-keep @com.fasterxml.jackson.annotation.JsonIgnoreProperties class * { *; }
-keep @com.fasterxml.jackson.annotation.JsonCreator class * { *; }
-keep @com.fasterxml.jackson.annotation.JsonValue class * { *; }
-keep class com.fasterxml.** { *; }
-keep class org.codehaus.** { *; }
-keepnames class com.fasterxml.jackson.** { *; }
-keepclassmembers public final enum com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility {
    public static final com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility *;
}

# General
-keepattributes SourceFile,LineNumberTable,*Annotation*,EnclosingMethod,Signature,Exceptions,InnerClasses



# Jackson
-keepattributes *Annotation*,EnclosingMethod,Signature
-keepnames class com.fasterxml.jackson.** { *; }
-dontwarn com.fasterxml.jackson.databind.**
-keep class org.codehaus.** { *; }
-keepclassmembers public final enum org.codehaus.jackson.annotate.JsonAutoDetect$Visibility {
public static final org.codehaus.jackson.annotate.JsonAutoDetect$Visibility *; }
-keep public class your.class.** {
  *;
}

# Kotlin
-keepclassmembers class **$WhenMappings {
    <fields>;
}

#Kotlin reflect
-keep class kotlin.Metadata { *; }

-keep class kotlin.reflect.** {
  public protected private *;
}

-keepclassmembers public class com.ycengine.post.data.dto.** {
    public synthetic <methods>;
}

-keep class org.jetbrains.kotlin.** { *; }
-keep class org.jetbrains.annotations.** { *; }
-keepclassmembers class ** {
  @org.jetbrains.annotations.ReadOnly public *;
}


-dontwarn kotlin.reflect.**
-keep class kotlin.** { *; }