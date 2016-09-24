	package se.diabol.gamify;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.diabol.gamify.core.domain.*;
import se.diabol.gamify.resources.SlackResource;

public class GamifyApplication extends Application<GamifyConfiguration> {

	private final HibernateBundle<GamifyConfiguration> hibernate = new HibernateBundle<GamifyConfiguration>(
			User.class, Action.class, Achievement.class, UserAction.class, UserAchievement.class
			) {
		@Override
		public DataSourceFactory getDataSourceFactory(GamifyConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};
	
    public static void main(final String[] args) throws Exception {
        new GamifyApplication().run(args);
    }

    @Override
    public String getName() {
        return "Gamify";
    }

    @Override
    public void initialize(final Bootstrap<GamifyConfiguration> bootstrap) {
    	bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final GamifyConfiguration configuration, final Environment environment) {
        SlackResource resource = new SlackResource();
        environment.jersey().register(resource);
    }
    
}
