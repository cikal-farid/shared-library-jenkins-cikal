// vars/html.groovy

def call(String command = '') {
    sh "chmod +x ./html.sh && ./html.sh ${command}"
}
