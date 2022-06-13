package br.com.senai.DennisSouza.application.bean;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private Usuario usuarioLogado;
    private String login;
    private String senha;
    // esse objeto dao depende do banco que você está usando
    //ou seja é preciso configurar dependo do ambiente de desenvolvimento
    //configurando isso o login funciona normalmente
    @Inject
    private UsuarioDAO usuarioDAO;

    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        this.login = "";
        this.senha = "";
        usuarioDAO.salvar(new Usuario("Benigno Sales", "benigno", "1"));
        usuarioDAO.salvar(new Usuario("Gabriela Sales", "gabriela", "2"));
        usuarioDAO.salvar(new Usuario("Letícia Sales", "leticia", "3"));
    }

    public String logIn() {
        usuarioLogado = usuarioDAO.buscar(login, senha);
        if (usuarioLogado == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválidos", "Login Inválido"));
            return null;
        } else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (session != null) {
                session.setAttribute("usuario", usuarioLogado);
            }
            return "despesas";
        }
    }

    public String logOff() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/login?faces-redirect=true";
    }