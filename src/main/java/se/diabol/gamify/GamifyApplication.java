package se.diabol.gamify;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GamifyApplication extends Application<GamifyConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GamifyApplication().run(args);
    }

    @Override
    public String getName() {
        return "Gamify";
    }

    @Override
    public void initialize(final Bootstrap<GamifyConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GamifyConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
