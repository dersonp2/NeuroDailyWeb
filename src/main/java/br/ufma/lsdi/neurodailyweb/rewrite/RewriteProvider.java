package br.ufma.lsdi.neurodailyweb.rewrite;


import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class RewriteProvider extends HttpConfigurationProvider {

    public static final String DASHBOARD = "/";
    public static final String LOGIN = "/login";
    public static final String LOGOUT = "/logout";

    public static final String BUSCAR_PACIENTE = "/paciente/busca";
    public static final String CADASTRAR_PACIENTE = "/paciente/cadastro";
    public static final String AVALIACAO_PACIENTE = "/paciente/avaliacoes";

    public static final String FORMULARIO_AVALIACAO = "/avaliacao";

    public static final String CADASTRAR_PROFISSIONAL = "/profissional/cadastro";
    public static final String BUSCAR_PROFISSIONAL = "/profissional/busca";

    @Override
    public Configuration getConfiguration(final ServletContext servletContext) {
        return ConfigurationBuilder
                .begin()
                .addRule(Join.path(DASHBOARD).to("/page/public/dashboard.xhtml"))
                .addRule(Join.path(LOGIN).to("/page/public/login.xhtml"))

                .addRule(Join.path(BUSCAR_PACIENTE).to("/page/private/paciente/busca-paciente.xhtml"))
                .addRule(Join.path(CADASTRAR_PACIENTE).to("/page/private/paciente/cadastro-paciente.xhtml"))
                .addRule(Join.path(AVALIACAO_PACIENTE).to("/page/private/paciente/avaliacao-paciente.xhtml"))

                .addRule(Join.path(FORMULARIO_AVALIACAO).to("/page/private/avaliacao/formulario-avaliacao.xhtml"))

                .addRule(Join.path(CADASTRAR_PROFISSIONAL).to("/page/private/profissional/cadastro-profissional.xhtml"))
                .addRule(Join.path(BUSCAR_PROFISSIONAL).to("/page/private/profissional/busca-profissional.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
