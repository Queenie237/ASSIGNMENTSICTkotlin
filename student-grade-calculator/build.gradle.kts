plugins {
    kotlin("jvm") version "1.9.22"
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

javafx {
    version = "17"
    modules = listOf("javafx.controls", "javafx.fxml")
}
dependencies {
    implementation("org.apache.poi:poi-ooxml:5.2.5")
}
dependencies {
    implementation("org.apache.poi:poi:5.2.5")
    implementation("org.apache.poi:poi-ooxml:5.2.5")
    implementation("com.itextpdf:itext7-core:7.2.5")
    implementation("com.itextpdf:itext7-core:7.2.5")
    dependencies {
        implementation("org.apache.poi:poi-ooxml:5.2.5")
        implementation("com.itextpdf:itext7-core:7.2.5")
    }
}

application {
    mainClass.set("com.studentgrade.ui.MainAppKt")
}