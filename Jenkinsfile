pipeline {
    agent any
    options {
        skipDefaultCheckout(true)
    }
    stages {
        stage('GetProject') {
            steps {
                git 'https://github.com/BartoszPerepeczo/bartspetitions'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean:clean"
            }
        }
        stage('Package') {
            steps {
                sh "mvn package"
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker build -f Dockerfile -t myapp .'
            }
        }

    }
    post {
        success {
             archiveArtifacts allowEmptyArchive: true,
             artifacts: '**/bartspetitions*.war'
        }
    }
}