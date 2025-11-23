package com.kangming.yu;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * used to load another jar to simulate spi mechanism
 */
public class SPIPlatformDemo {

    // The Leak: Holding references to instances keeps their ClassLoader alive
    private static List<HealthCheck> activePlugins = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // We expect the plugin to be in a 'plugins' folder next to the app jar
        File pluginJar = new File("plugins/redis-plugin-1.0-SNAPSHOT.jar");

        if (!pluginJar.exists()) {
            System.err.println("Error: Could not find plugins/redis-plugin-1.0.0.jar");
            System.exit(1);
        }

        System.out.println(">>> Platform Starting...");
        int iteration = 0;

        while (true) {
            iteration++;

            // 1. Create a NEW URLClassLoader every time (Simulating bad hot-reload)
            URL[] urls = { pluginJar.toURI().toURL() };
            URLClassLoader pluginLoader = new URLClassLoader(urls, SPIPlatformDemo.class.getClassLoader());

            // 2. Load the Service
            ServiceLoader<HealthCheck> serviceLoader = ServiceLoader.load(HealthCheck.class, pluginLoader);

            for (HealthCheck service : serviceLoader) {
                service.check();
                // 3. LEAK: Add to list, preventing GC of the ClassLoader
                activePlugins.add(service);
            }

            if (iteration % 100 == 0) {
                System.out.println("Iteration: " + iteration + " | Plugins Loaded: " + activePlugins.size());
                Thread.sleep(10); // Small delay to allow monitoring
            }
        }
    }
}
