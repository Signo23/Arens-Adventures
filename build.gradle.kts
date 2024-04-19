plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building a CLI application
    // You can run your app via task "run": ./gradlew run
    application

    /*
     * Adds tasks to export a runnable jar.
     * In order to create it, launch the "shadowJar" task.
     * The runnable jar will be found in build/libs/projectname-all.jar
     */
    id("com.github.johnrengelman.shadow") version "7.0.0"
}
version = "1.0.4"
repositories {
    mavenCentral()
}


val supportedPlatforms = listOf("linux", "mac", "win") // All required for OOP


val jUnitVersion = "5.8.2"

dependencies {
    // Example library: Guava. Add what you need (and remove Guava if you don't use it)
    // implementation("com.google.guava:guava:28.1-jre")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation(project(":Aren-Game"))
    implementation(project(":Aren-Base"))


    // JUnit API and testing engine
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    // Enables JUnit 5 Jupiter module
    useJUnitPlatform()
}


application {
    // Define the main class for the application
    mainClass.set("it.aren.App")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
