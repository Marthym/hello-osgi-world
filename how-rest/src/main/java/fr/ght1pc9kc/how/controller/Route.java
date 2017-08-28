package fr.ght1pc9kc.how.controller;

import io.undertow.server.HttpHandler;

public interface Route extends HttpHandler {
    String getRoute();
}
