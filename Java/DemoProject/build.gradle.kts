plugins {
    id("java")
}

group = "pitam"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.oracle.database.jdbc:ojdbc8-production:19.7.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.mysql:mysql-connector-j:8.4.0")
}

tasks.test {
    useJUnitPlatform()
}