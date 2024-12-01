package com.github.tobhor.jenkins.linter.api

import com.github.tobhor.jenkins.linter.JenkinsResponse
import com.github.tobhor.jenkins.linter.LinterResponse
import java.io.Closeable

/**
 * @author Mike Safonov
 */
interface JenkinsServer : Closeable {

    fun checkConnection(): JenkinsResponse

    fun lint(content: String): LinterResponse
}
