package ua.com.andromeda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.com.andromeda.entities.*;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    private final ApplicationContext ctx;

    @Autowired
    public HibernateConfig(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(ctx.getResource(
                "classpath:/hibernate.cfg.xml"));
        sessionFactory.setAnnotatedClasses(User.class, Role.class, Media.class, Ticket.class,
                                    TicketType.class, Movie.class, MovieDetails.class);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
