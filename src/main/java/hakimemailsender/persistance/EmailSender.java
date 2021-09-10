package hakimemailsender.persistance;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;
import hakimemailsender.domain.Emailer;
import hakimemailsender.presentation.WelcomeMailDto;

import java.io.IOException;

/**
 * Created by Jacaranda Perez
 * Date: 2021-09-05
 * Project: HakimEmailSender
 */

public class EmailSender implements Emailer {
        private String apiKey;
        private String mailFrom;

    public EmailSender(String apiKey, String mailFrom) {
        this.apiKey = apiKey;
        this.mailFrom = mailFrom;

    }

    @Override
    public String sendWelcomeMail(WelcomeMailDto welcomeMailDto) throws IOException {
        Email from = new Email(mailFrom);
        Email to = new Email(welcomeMailDto.getSendTo()); // hide

        String subject = welcomeMailDto.getSubject();
        Content content = new Content("text/plain",welcomeMailDto.getContent());

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sg.api(request);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
        return response.getBody();
    }


}
