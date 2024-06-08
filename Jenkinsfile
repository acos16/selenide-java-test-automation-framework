pipeline {
    agent {
        docker {
            image 'gradle:7.5.1-jdk11'
            args '-v /home/gradle/.gradle:/home/gradle/.gradle' // Mount the gradle cache
        }
    }

    environment {
        GRADLE_USER_HOME = "/home/gradle/.gradle"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/acos16/selenide-java-test-automation-framework.git', branch: 'main'
            }
        }

        stage('Compile') {
            steps {
                sh './gradlew clean compileJava'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew customTest'
            }
        }

        stage('Publish JUnit Report') {
            steps {
                junit 'build/test-results/test/*.xml'
            }
        }

        stage('Publish HTML Report') {
            steps {
                publishHTML(target: [
                    reportName           : 'HTML Report',
                    reportDir            : 'build/reports/tests/test',
                    reportFiles          : 'index.html',
                    keepAll              : true,
                    alwaysLinkToLastBuild: true,
                    allowMissing         : true
                ])
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
            }
        }
    }
}