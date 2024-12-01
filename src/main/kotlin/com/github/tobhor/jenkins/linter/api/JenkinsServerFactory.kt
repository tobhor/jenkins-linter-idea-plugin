package com.github.tobhor.jenkins.linter.api

import com.github.tobhor.jenkins.linter.settings.JenkinsLinterCredentials
import com.intellij.credentialStore.Credentials

/**
 * @author Mike Safonov
 */
object JenkinsServerFactory {

    fun get(
        url: String,
        trustSelfSigned: Boolean = true,
        ignoreCertificate: Boolean = false,
        isOAuthToken: Boolean = false,
        useCrumbIssuer: Boolean = false
    ): JenkinsServer {
        val credentials = JenkinsLinterCredentials.get()
        return JenkinsServerImpl(url, trustSelfSigned, ignoreCertificate, credentials, isOAuthToken, useCrumbIssuer)
    }

    fun get(
        url: String,
        trustSelfSigned: Boolean = true,
        ignoreCertificate: Boolean = false,
        credentials: Credentials?,
        isOAuthToken: Boolean = false
    ): JenkinsServer {
        return JenkinsServerImpl(url, trustSelfSigned, ignoreCertificate, credentials, isOAuthToken)
    }
}
