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
                echo "steps placeholder"
                sh "mvn clean:clean"

                //sh 'mvn dependency:copy-dependencies'

                //sh "mvn compiler:compile"
            }
        }
        stage('Package') {
            steps {
                echo "package placeholder"
                sh "mvn package"
            }
        }
        stage ('Archive') {
            steps {
                echo "archive placeholder"
                archiveArtifacts allowEmptyArchive: true,
                artifacts: '**/demo*.war'
            }
        }
        stage('Deploy') {
            steps {
                echo "deploy placeholder"
            }
        }

    }
}