def call(Map params = [:]) {
    def name = params.name ?: 'World'
    def greeting = params.greeting ?: 'Hello'
    echo "${greeting}, ${name}! Welcome to Jenkins."
}