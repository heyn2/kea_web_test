pipeline {
    agent any

    environment {
        GRADLE_OPTS = '-Dorg.gradle.daemon=false'
    }

    triggers {
        // Enable GitHub webhook trigger when configured in Jenkins job
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                sh "./gradlew compileJava"
            }
        }

        stage('Build') {
            steps {
                sh "./gradlew build -x test"
            }
        }

        stage('Unit test') {
            steps {
                sh "./gradlew test"
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Package Jar') {
            steps {
                sh "ls -al build/libs || true"
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }
    post {
        success {
            echo '✅ Build & tests passed. Artifact archived.'
        }
        failure {
            echo '❌ Build failed.'
        }
    }
}
