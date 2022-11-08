package com.supplychainpoc.dropwizardapp.entities;

class PingEntity constructor(
    greeting: String?
) {
    var greeting: String?

    init {
        this.greeting = greeting ?: "Pong"
    }
}
