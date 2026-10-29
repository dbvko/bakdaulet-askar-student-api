pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
    }

    environment {
        STUDENT_NAME = 'Bakdaulet Askar'
        DOCKER_IMAGE = 'bakdaulet-askar-student-api:v1.0-bakdaulet-askar'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Student: ${STUDENT_NAME}"
                echo "Repository checked out successfully."
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean assemble --no-daemon'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t "$DOCKER_IMAGE" .'
            }
        }

        stage('Verify') {
            steps {
                sh 'docker image inspect "$DOCKER_IMAGE"'
                sh 'docker image ls "$DOCKER_IMAGE"'
                echo "Docker image verified for ${STUDENT_NAME}."
            }
        }
    }

    post {
        success {
            echo "SUCCESS: Pipeline completed for ${STUDENT_NAME}."
        }
        failure {
            echo "FAILURE: Check the failed stage and console output."
        }
        always {
            echo "Pipeline finished for ${STUDENT_NAME}."
        }
    }
}
