pipeline {
    agent any
    options {
        skipDefaultCheckout(true)
    }
    stages {
        stage('GetProject') {
            steps {
                echo "get project placeholder"
                //git 'https://github.com/BartoszPerepeczo/CT5171_test1Maven'
                git 'https://github.com/BartoszPerepeczo/bartspetitions'
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