package com.github.tobhor.jenkins.linter.settings

import com.github.tobhor.jenkins.linter.JenkinsLinterException
import com.github.tobhor.jenkins.linter.api.JenkinsConnectionVerifyer
import com.intellij.credentialStore.Credentials
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task

/**
 * @author Mike Safonov
 */
class JenkinsCheckConnectionTask(
    private val jenkinsUrl: String,
    private val trustSelfSigned: Boolean,
    private val ignoreCertificate: Boolean,
    private val credentials: Credentials?,
    private val isOAuthToken: Boolean
) :
    Task.Modal(null, "Test Connection to Jenkins", false) {

    var success: Boolean = false

    override fun run(indicator: ProgressIndicator) {
        indicator.text = "Connecting to $jenkinsUrl ... "
        indicator.isIndeterminate = true

        try {
            JenkinsConnectionVerifyer().verify(
                jenkinsUrl,
                trustSelfSigned,
                ignoreCertificate,
                credentials,
                isOAuthToken
            )
            success = true
        } catch (e: JenkinsLinterException) {
            Logger.getInstance(JenkinsCheckConnectionTask::class.java).debug(e)
        }
    }
}
