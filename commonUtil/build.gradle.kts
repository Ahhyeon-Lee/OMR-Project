plugins {
    id("omr.android.library")
    id("omr.android.hilt")
}

android {
    namespace = "com.lok.dev.commonUtil"
}

dependencies {

    implementation(libs.bundles.android)
    implementation(libs.bundles.androidx)
    implementation(libs.bundles.junit)

    implementation(project(":commonModel"))

}