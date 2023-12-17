package soa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.Reglement;
import soa.metier.ReglementMetierInterface;
import soa.repository.ReglementRepository;


@SpringBootApplication
public class SpringJpaApplication
{


    public static void main(String[] args) throws ParseException {

        ApplicationContext contexte = SpringApplication.run(SpringJpaApplication.class, args);





    }

}
