pipeline {
    agent any

    stages {
        stage('GetProject') {
            steps {
                git (
                    url : 'https://github.com/BartoszPerepeczo/bartspetition',
                    branch : master
                )
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean"

                //sh 'mvn dependency:copy-dependencies'

                //sh "mvn compiler:compile"
            }
        }
        stage('Package') {
            steps {
                sh "mvn package"
            }
        }
        Stage('Deploy') {
            steps {
            }
        }

    }
}