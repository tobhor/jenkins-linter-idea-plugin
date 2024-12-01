package com.github.tobhor.jenkins.linter.api

import com.github.tobhor.jenkins.linter.JenkinsLinterException
import com.intellij.credentialStore.Credentials

/**
 * @author Mike Safonov
 */
class JenkinsConnectionVerifyer {

    fun verify(
        host: String,
        trustSelfSigned: Boolean = false,
        ignoreCertificate: Boolean = false,
        credentials: Credentials?,
        isOAuthToken: Boolean = false
    ) {
        val jenkinsServer =
            JenkinsServerFactory.get(host, trustSelfSigned, ignoreCertificate, credentials, isOAuthToken)
        jenkinsServer.use {
            val response = jenkinsServer.checkConnection()
            if (!response.success) {
                throw JenkinsLinterException("Request return status code ${response.code}", response.code)
            }
        }
    }
}
