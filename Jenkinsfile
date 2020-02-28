pipeline {
    agent any

    stages{
        stage('Preparation') {
            steps {
                git 'https://github.com/EvgeniaKosyakABM/Lesson7.git'
            }
        }
        //отдельной командой запускаем Unit tests
        stage('Unit tests') {
            steps{
                bat 'mvn clean -DsuiteXmlFile=unittests.xml test'
            }
        }
        //отдельной командой запускаем UI tests
        stage('UI tests') {
            steps{
                bat 'mvn clean -DsuiteXmlFile=testng.xml test'
            }
        }
    }
    //записываются отчеты всегда
    post{
        always{
            script {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                ])
            }
        }
    }
}
