package fr.ght1pc9kc.how;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class HowActivator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("HOW is now Activated !");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("HOW is now Stopped !");
    }
}
