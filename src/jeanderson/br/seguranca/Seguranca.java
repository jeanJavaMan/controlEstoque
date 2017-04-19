/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.seguranca;

import java.io.Serializable;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Seguranca implements Serializable {

    private static final long serialVersionUID = 10122545781548L;
    private final String USERADMIN = "jeandersonfju@gmail.com";
    private final String PASSWORDADMIN = "jean1012x";
    private String user;
    private String password;
    private boolean lembrar = false;

    public Seguranca(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Seguranca() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserAdmin(){
        return this.USERADMIN;
    }
    public String getPasswordAdmin(){
        return this.PASSWORDADMIN;
    }

    public boolean getLembrar() {
        return lembrar;
    }

    public void setLembrar(boolean lembrar) {
        this.lembrar = lembrar;
    }
    

}
