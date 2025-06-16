def call(Map params = [:]) {
    def name = params.name ?: 'World'
    echo "👋 Hello, ${name}! Welcome to Jenkins."
}