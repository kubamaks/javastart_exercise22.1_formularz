package pl.km.exercise221;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
class MailService {
    static final String CONTACT_EMAIL_ADDRESS = "kubamaktesting@gmail.com";
    private final JavaMailSender javaMailSender;
    private final MailRepository mailRepository;

    public MailService(MailRepository mailRepository, JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
        this.mailRepository = mailRepository;
    }

    public void addMail(Mail mail) {
        mailRepository.addMail(mail);
    }

    public void sendMail(Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mail.getReceiverMail());
        mailMessage.setTo(CONTACT_EMAIL_ADDRESS);
        mailMessage.setSubject("zapytanie od: " + mail.getSenderName());
        mailMessage.setText(mail.getMessage() + "email:" + mail.getReceiverMail());
        javaMailSender.send(mailMessage);
    }
}
