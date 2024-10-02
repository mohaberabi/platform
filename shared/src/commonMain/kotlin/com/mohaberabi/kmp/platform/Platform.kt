package com.mohaberabi.kmp.platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform