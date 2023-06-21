plugins {
    java
}

group = "it.aren"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation(project(":Aren-Base"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}