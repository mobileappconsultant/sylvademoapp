object Ktor {
    private const val ktorVersion = "2.0.0-rc-1"
    private const val loggingInterceptor = "4.9.2"

    const val core = "io.ktor:ktor-client-core:$ktorVersion"
    const val android = "io.ktor:ktor-client-android:$ktorVersion"

    const val clientSerialization = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
    const val content = "io.ktor:ktor-client-content-negotiation:$ktorVersion"

    const val ios = "io.ktor:ktor-client-darwin:$ktorVersion"
    const val logging = "io.ktor:ktor-client-logging:$ktorVersion"

    const val defaultHeader = "io.ktor:ktor-server-default-headers:$ktorVersion"

    const val okhttp = "io.ktor:ktor-client-okhttp:$ktorVersion"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:$loggingInterceptor"
}
