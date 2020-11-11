import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	implementation("khttp:khttp:1.0.0")
	implementation("com.google.code.gson:gson:2.8.6")

	//Unit Tests
	testImplementation("io.mockk:mockk:1.10.0")
	testImplementation("com.ninja-squad:springmockk:2.0.2")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:4.0.5") // for kotest framework
	testImplementation("io.kotest:kotest-assertions-core-jvm:4.0.5") // for kotest core jvm assertions
	testImplementation("io.kotest:kotest-property-jvm:4.0.5") // for kotest property test
	testImplementation("io.kotest:kotest-extensions-spring:4.0.5")
	testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
	testImplementation("com.squareup.okhttp3:mockwebserver:4.0.0")
	testImplementation("com.squareup.okhttp3:okhttp:4.0.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
