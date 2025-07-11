pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "StepUp"
include(":app")
include(":core:common-android")
include(":core:essentials")
include(":feature:auth:domain")
include(":feature:auth:presentation")
include(":feature:init:domain")
include(":feature:init:presentation")
include(":core:theme")
include(":feature:favorite:domain")
include(":feature:favorite:presentation")
include(":feature:cart:domain")
include(":feature:cart:presentation")
