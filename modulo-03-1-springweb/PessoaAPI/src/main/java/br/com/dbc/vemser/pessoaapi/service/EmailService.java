package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;
    private String to = "ceciliaalicesilva88@gmail.com";

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Assunto TESTE");
        message.setText("Meu e-mail!");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws Exception {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(message,
                    true);
        } catch (MessagingException e) {
            throw new Exception(e.getMessage());
        }

        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Assunto Assunto");
        mimeMessageHelper.setText("Meu e-mail!");

//        File file = new File("static/imagem.jpg");
//        FileSystemResource fileSr
//                = new FileSystemResource(file);
//        mimeMessageHelper.addAttachment(file.getName(), fileSr);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("static/eras.webp").getFile());
        FileSystemResource fileRs = new FileSystemResource(file);
        mimeMessageHelper.addAttachment(file.getName(), fileRs);

        System.out.println("File: " + file.getPath());

        emailSender.send(message);
    }

    public void sendEmail() throws Exception {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Assunto Teste Template");
            mimeMessageHelper.setText(geContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public void sendWelcomeEmail(PessoaDTO pessoaDTO) throws Exception {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Bem-vindo ao Sistema");
            mimeMessageHelper.setText(getWelcomeEmailContent(pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            throw new Exception(e.getMessage());
        }
    }

    public void sendUpdateEmail(PessoaDTO pessoaDTO) throws Exception{
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Alteração de dados na sua conta");
            mimeMessageHelper.setText(getUpdateEmailContent(pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            throw new Exception(e.getMessage());
        }
    }

    public void sendDeleteEmail(PessoaDTO pessoaDTO) throws Exception {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Você perdeu o acesso ao nosso sistema");
            mimeMessageHelper.setText(getDeleteEmailContent(pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            throw new Exception(e.getMessage());
        }
    }

    private String geContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Cecília");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    private String getWelcomeEmailContent(PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("email", to);

        Template template = fmConfiguration.getTemplate("welcome-email-template.ftl");
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
    }

    private String getUpdateEmailContent(PessoaDTO pessoaDTO) throws IOException, TemplateException{
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", to);

        Template template = fmConfiguration.getTemplate("alter-data-email-template.ftl");
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
    }

    private String getDeleteEmailContent(PessoaDTO pessoaDTO) throws Exception{
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());

        Template template = fmConfiguration.getTemplate("delete-email-template.ftl");
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
    }
}