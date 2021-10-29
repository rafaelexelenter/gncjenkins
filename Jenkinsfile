pipeline {
    agent any

    stages {
        stage ('Run Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
                    sh './mvnw clean test'
                }

            }
        }

        stage('Collect Results'){
            steps{
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/report', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
            }
        }
        stage('Generate HTML report') {
          steps{
                cucumber buildStatus: 'UNSTABLE',
                reportTitle: 'My report',
                fileIncludePattern: '**/*cucumber.json',
                sortingMethod: 'ALPHABETICAL',
                trendsLimit: 100
          }
        }
    }
}