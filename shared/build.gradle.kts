import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.vanniktech.maven.publish") version "0.28.0"

}


val mohab = "mohaberabi"


mavenPublishing {
    coordinates(
        groupId = "io.github.$mohab",
        artifactId = "platform",
        version = "0.2.0"
    )

    pom {
        name.set("KMP Library for saving data to the clipboard")
        description.set("This library can be used by Android and iOS targets for the shared functionality of knowing the platform")
        inceptionYear.set("2024")
        url.set("https://github.com/$mohab/platform.git")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set(mohab)
                name.set(mohab)
                email.set("moohaberabii98@gmail.com")
            }
        }

        scm {
            url.set("https://github.com/$mohab/platform")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()
}

kotlin {
    group = "com.$mohab"
    version = "0.1.0"
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.mohaberabi.kmp.platform"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
