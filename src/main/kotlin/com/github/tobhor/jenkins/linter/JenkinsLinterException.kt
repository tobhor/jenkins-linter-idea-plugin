package com.github.tobhor.jenkins.linter

import java.lang.RuntimeException

/**
 * @author Mike Safonov
 */
class JenkinsLinterException(message: String, val statusCode: Int) : RuntimeException(message)
