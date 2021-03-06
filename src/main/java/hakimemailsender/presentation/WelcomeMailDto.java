package hakimemailsender.presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Created by Jacaranda Perez
 * Date: 2021-09-05
 * Project: HakimEmailSender
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WelcomeMailDto {
    private String sendTo;
    private String mailfrom;
    private String content;
    private String subject;

    public WelcomeMailDto() {
    }
    @JsonCreator
    public WelcomeMailDto(@JsonProperty("email") String sendTo, @JsonProperty("sender") String mailfrom,
                          @JsonProperty("content") String content, @JsonProperty("subject") String subject) {
        this.sendTo = sendTo;
        this.mailfrom = mailfrom;
        this.content = content;
        this.subject = subject;
    }


}
