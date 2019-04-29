package ejemploGmail02;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailTLS {
    private String destino, asunto, cuerpo;

    public SendEmailTLS(String destino, String asunto, String cuerpo) {
        this.destino = destino;
        this.asunto = asunto;
        this.cuerpo = cuerpo;

        final String username = "agriarte@gmail.com";
        final String password = "xxxx";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destino)
            );
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}

