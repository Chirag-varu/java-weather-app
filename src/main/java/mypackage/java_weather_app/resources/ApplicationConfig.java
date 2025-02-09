package mypackage.java_weather_app.resources;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")  // Base URL for all endpoints
public class ApplicationConfig extends Application {
}
