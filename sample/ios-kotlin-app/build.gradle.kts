/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    kotlin("multiplatform")
    id("dev.icerock.mobile.multiplatform-resources")
    id("detekt-convention")
}

kotlin {
    val iosArm64 = iosArm64()
    val iosSimulatorArm64 = iosSimulatorArm64()
    val iosX64 = iosX64()
    configure(listOf(iosArm64, iosSimulatorArm64, iosX64)) {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val iosMain by creating {
            dependsOn(commonMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
    }
}

dependencies {
    commonMainImplementation(projects.sample.mppLibrary)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.icerockdev.app"
}
