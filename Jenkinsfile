pipeline {
    agent any

    stages {
        stage('GetProject') {
            steps {
                echo "get project placeholder"
                git (
                    url : 'https://github.com/BartoszPerepeczo/bartspetition',
                    branch : master
                )
            }
        }
        stage('Build') {
            steps {
                echo "steps placeholder"
                //sh "mvn clean"

                //sh 'mvn dependency:copy-dependencies'

                //sh "mvn compiler:compile"
            }
        }
        stage('Package') {
            steps {
                echo "package placeholder"
                //sh "mvn package"
            }
        }
        stage('Deploy') {
            steps {
                echo "deploy placeholder"
            }
        }

    }
}